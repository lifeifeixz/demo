package com.baixiang.chuxing.user.utils;

import freemarker.cache.MruCacheStorage;
import freemarker.template.*;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

/**
 * <p/>
 * <p><b>introduction:</b>
 * </p>
 * <p><b>packageName:</b>com.st.user.utils</p>
 * <p><b>projectName:</b>st</p>
 * <p><b>User:</b> lipengfei <a href="mailto:lipengfei90@live.cn">lipengfei90@live.cn</a></p>
 * <p><b>Date:</b>2016/9/12</p>
 *
 * @author lipengfei
 */
public class FreemarkerUtil {

    private static FreemarkerUtil fmutil = null;
    private static Configuration cfg = null;

    private static final int MAX_STRONG_APPOINT_NUM = 20; //最大的强引用对象数
    private static final int MAX_WEAK_APPOINT_NUM = 250; //最大的弱引用对象数

    public static FreemarkerUtil getInstance(String path) {

        if (cfg == null) {
            synchronized (FreemarkerUtil.class) {
                if (cfg == null) {
                    try {
                        Version freeMarkerVersion = Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS;
                        cfg = new Configuration(freeMarkerVersion);
                        cfg.setDefaultEncoding("UTF-8");
                        cfg.setCacheStorage(new MruCacheStorage(MAX_STRONG_APPOINT_NUM, MAX_WEAK_APPOINT_NUM));
                        cfg.setObjectWrapper(new DefaultObjectWrapper(freeMarkerVersion));
                        cfg.setDirectoryForTemplateLoading(new File(path));

                        fmutil = new FreemarkerUtil();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return fmutil;
    }

    public static String getTemplate(String templateName, Map<String, Object> params) {

        Template template = null;
        StringWriter out = new StringWriter();

        try {
            template = cfg.getTemplate(templateName);
            template.process(params, out);
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return out.toString();
    }

}

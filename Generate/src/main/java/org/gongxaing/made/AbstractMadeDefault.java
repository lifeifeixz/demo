package org.gongxaing.made;

import jars.ResourceTransportationUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.gongxaing.BaseInfo;
import org.gongxaing.BeanFactory;
import org.gongxaing.model.Field;
import org.gongxaing.GenerateConfig;
import org.gongxaing.analysis.Analysis;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author flysLi
 * @date 2018/3/15
 */
public abstract class AbstractMadeDefault implements MadeStrategy {
    List<Field> fieldList;
    Analysis analysis = BeanFactory.getAnalysisInstance();
    MadeStrategy madeStrategy;
    File rafaelia;

    /**
     * 根据类型读取模板
     *
     * @param type
     * @return
     */
    public Document getTemplateByType(String type) {
        Document document = null;
        try {
            document = Jsoup.parse(new File(BaseInfo.TEMPLATE_BASEPATH, type + BaseInfo.TEMPLATE_SUFFIX), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return document;
    }

    @Override
    public void out(String dom) {
        ResourceTransportationUtil.writer(dom, BaseInfo.PRODUCT_BASEPATH + GenerateConfig.generateConfig.getModularName() + ".html");
    }
}

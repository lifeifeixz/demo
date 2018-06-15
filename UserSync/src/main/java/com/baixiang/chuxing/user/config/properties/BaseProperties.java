package com.baixiang.chuxing.user.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <p/>
 * <p><b>introduction:</b>
 * </p>
 * <p><b>packageName:</b>com.st.user.config.properties</p>
 * <p><b>projectName:</b>st</p>
 * <p><b>User:</b> lipengfei <a href="mailto:lipengfei90@live.cn">lipengfei90@live.cn</a></p>
 * <p><b>Date:</b>2016/9/6</p>
 *
 * @author lipengfei
 */
@ConfigurationProperties(prefix="base")
public class BaseProperties {

    private String webUrl;
    private String picPath;
    private String picShowUri;
    private String picCdnUri;
    private String[] includeUrlPattern;
    private String[] jsonpCallbackName;

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public String getPicShowUri() {
        return picShowUri;
    }

    public void setPicShowUri(String picShowUri) {
        this.picShowUri = picShowUri;
    }

    public String getPicCdnUri() {
        return picCdnUri;
    }

    public void setPicCdnUri(String picCdnUri) {
        this.picCdnUri = picCdnUri;
    }

    public String[] getIncludeUrlPattern() {
        return includeUrlPattern;
    }

    public void setIncludeUrlPattern(String[] includeUrlPattern) {
        this.includeUrlPattern = includeUrlPattern;
    }

    public String[] getJsonpCallbackName() {
        return jsonpCallbackName;
    }

    public void setJsonpCallbackName(String[] jsonpCallbackName) {
        this.jsonpCallbackName = jsonpCallbackName;
    }
}

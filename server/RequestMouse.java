package server;

import java.net.Socket;
import java.util.List;
import java.util.Map;

/**
 * Created by flysLi on 2017/9/25.
 */
@SuppressWarnings("all")
public class RequestMouse implements Request {

    private Map<String, Object> params;
    private List<String> header;
    private String host;
    private String method;
    private String resource;

    public String getResource() {
        return resource;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public RequestMouse() {

    }

    public RequestMouse(Socket socket) {

    }

    /**
     * 针对类型获取请求中的参数
     *
     * @param name
     * @param t
     * @param <T>  你想要转换成的类型,只支持简单类型
     * @return
     */
    public <T> T getParam(String name, T t) {
        if (name == null || name.length() == 0) {
            return null;
        }
        Object val = this.params.get(name);
        return (T) val;
    }

    /**
     * 获取请求中的参数
     *
     * @param name 请求中=号左边的字符
     * @return
     */
    public String getParam(String name) {
        if (name == null || name.length() == 0) {
            return null;
        }
        Object val = this.params.get(name);
        return val == null ? null : String.valueOf(val);
    }

    public String[] getParams() {
        return new String[0];
    }
}

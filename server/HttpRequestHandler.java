package server;

/**
 * @author flysLi
 * @date 2017/12/11
 */
public class HttpRequestHandler implements Request {

    private String method;

    @Override
    public <T> T getParam(String name, T t) {
        return null;
    }

    @Override
    public String getParam(String name) {
        return null;
    }

    @Override
    public String[] getParams() {
        return new String[0];
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}

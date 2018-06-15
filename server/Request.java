package server;

/**
 * Created by flysLi on 2017/9/25.
 */
@SuppressWarnings("all")
public interface Request {
    <T> T getParam(String name, T t);

    String getParam(String name);

    String[] getParams();
}

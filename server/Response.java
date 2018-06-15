package server;

/**
 * Created by flysLi on 2017/9/25.
 */
@SuppressWarnings("all")
public interface Response {

    /**
     * ·¢ËÍ½á¹û
     *
     * @param result
     */
    void send(byte[] data);
}

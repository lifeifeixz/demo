package server;

/**
 * Created by flysLi on 2017/9/25.
 */
@SuppressWarnings("all")
public interface Response {

    /**
     * ���ͽ��
     *
     * @param result
     */
    void send(byte[] data);
}

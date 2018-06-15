package server;

import java.net.Socket;

/**
 * Created by flysLi on 2017/9/25.
 */
@SuppressWarnings("all")
public class ResponseMouse implements Response {
    private Socket socket;

    public ResponseMouse(Socket socket) {
        this.socket = socket;
    }

    public void send(byte[] data) {

    }
}

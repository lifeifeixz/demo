package org.server.server2;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by flysLi on 2017/8/14.
 */
public class DispatcharRequest implements Runnable {


    private Socket socket;

    public DispatcharRequest(Socket socket) {
        super();
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("=======接收到请求=======");
        InputStream in = null;
        OutputStream out = null;
        try {
            in = socket.getInputStream();

            System.out.println("按照http协议解析客户端数据...");

            out = socket.getOutputStream();
            byte[] b = new byte[1024];
            in.read(b);
            System.out.println(new String(b));
            System.out.println("=======处理并输出请求=======");
            out.write("<html><title>欢迎访问MyTomcat</title><head></head><body>欢迎访问MyTomcat</body></html>".getBytes());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    in = null;
                }
            }
            if (null != out) {
                try {
                    out.close();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    out = null;
                }
            }
        }

    }

}
package org.server.http.server;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {
    /**
     * WEB_ROOT是存放HTML文件的目录
     */
    public static final String WEB_ROOT = System.getProperty("user.dir") + File.separator + "webroot";

    //关闭命令
    private static final String SHUTDOWN_COMMAND = "/SHUTDOWN";

    //收到关闭命令
    private boolean shutdown = false;

    /**
     * @param args
     */
    public static void main(String[] args) {
        HttpServer server = new HttpServer();
        server.await();

    }

    public void await() {
        ServerSocket serverSocket = null;
        int port = 8080;
        try {
            serverSocket = new ServerSocket(port, 1, InetAddress.getByName("127.0.0.1"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        //等待请求
        while (!shutdown) {
            Socket socket = null;
            InputStream inputStream = null;
            OutputStream outputStream = null;
            try {

                socket = serverSocket.accept();
                inputStream = socket.getInputStream();
                outputStream = socket.getOutputStream();

                //创建请求对象并解析
                Request request = new Request(inputStream);
                request.parse();

                //创建响应对象
                Response response = new Response(outputStream);
                response.setRequest(request);

                //关闭socket
                if (socket != null) {
                    socket.close();
                }

                //检查URI是否是一个关闭命令
                shutdown = SHUTDOWN_COMMAND.equals(request.getUri());

            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }
    }

}
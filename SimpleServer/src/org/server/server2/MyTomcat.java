package org.server.server2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by flysLi on 2017/8/14.
 */
public class MyTomcat {

    private ServerSocket serverSocket;
    //监听端口
    private int port;

    private boolean startup = true;

    public MyTomcat(int port) {
        super();
        this.port = port;
    }

    /**
     * 启动服务器
     */
    public void startup(){
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("启动成功，监听端口："+port);
            while(startup){
                //等待客户端连接
                Socket socket = serverSocket.accept();
                //启动线程讲客户端socket交给DispatcharRequest处理
                new Thread(new DispatcharRequest(socket)).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new MyTomcat(8888).startup();
    }



}
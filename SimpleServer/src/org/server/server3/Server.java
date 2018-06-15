package org.server.server3;

import org.server.server3.logs.Logger;
import sun.rmi.runtime.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * Created by flysLi on 2017/8/14.
 */
public class Server {

    //服务对象
    private ServerSocket serverSocket;

    //端口号
    private int port = 8888;

    public Server() {
        // TODO: 2017/8/14 读取web.xml配置文件

        // TODO: 2017/8/14 调用需要init时执行的类

        //实例化服务
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            Logger.log("实例化服务器失败");
        }
    }

    public Server(int port) {
        this.port = port;
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            Logger.log("实例化服务器失 败");
        }
    }

    /**
     * 启动服务
     */
    public void run() {
        while (true) {
            try {
                Logger.log("开始监听请求:");
                Socket socket = serverSocket.accept();
                InputStream inputStream = socket.getInputStream();
                System.out.println(this.parse(inputStream));

            } catch (IOException e) {
                Logger.log("服务超时");
            }
        }
    }

    public static void main(String[] args) {
        new Server().run();
    }

    /**
     * 将请求数据转换成 string
     *
     * @param inputStream
     * @return
     */
    public String parse(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuffer stringBuffer = new StringBuffer();
        String temp = null;
        try {
            while ((temp = bufferedReader.readLine()) != null) {
                stringBuffer.append(temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }
}

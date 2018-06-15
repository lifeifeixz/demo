/**
 * 监听端口
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 数据
 */
package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;

/**
 * @author flysLi
 * @date 2017/9/25
 */
public class Server {
    ServerSocket serverSocket;// 服务器Socket
    private static ExecutorService executorService;//初始化线程池
    private static int PORT = 8001;
    public static int POOL_SIZE = 20;

    public Server() {
        try {
            serverSocket = new ServerSocket(PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 启动服务
     */
    public void startup() {

        System.out.println("服务已经启动");
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                /**
                 * 创建一个线程
                 */
                new Thread(new HandlerMouse(socket)).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) throws IOException {
        new Server().startup();
    }
}

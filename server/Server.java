/**
 * �����˿�
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
 * ����
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
    ServerSocket serverSocket;// ������Socket
    private static ExecutorService executorService;//��ʼ���̳߳�
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
     * ��������
     */
    public void startup() {

        System.out.println("�����Ѿ�����");
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                /**
                 * ����һ���߳�
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

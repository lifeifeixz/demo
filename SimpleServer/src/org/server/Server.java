package org.server;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by flysLi on 2017/8/14.
 */
public class Server {
    private static ServerSocket serverSocket;
    private static ExecutorService executorService;
    private final static int POOL_SIZE = 15;

    public static void main(String[] args) throws IOException {
        serverSocket = new ServerSocket(8888);
        Socket socket = null;
        executorService = Executors.newFixedThreadPool(POOL_SIZE);

        while (true) {
            socket = serverSocket.accept();
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"));
            writer.println("HTTP/1.1 200 OK");
            writer.println("Content-Type: text/html;charset=UTF-8");
            writer.println();

            writer.flush();
            writer.close();
        }
    }
}

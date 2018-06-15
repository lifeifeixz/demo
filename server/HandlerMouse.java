package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by flysLi on 2017/9/25.
 * һ��������
 */
@SuppressWarnings("all")
public class HandlerMouse implements Runnable {
    private Socket socket;

    public HandlerMouse() {

    }

    public HandlerMouse(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String requestHeader;
        int contentLength = 0;
        try {
            while ((requestHeader = reader.readLine()) != null && !requestHeader.isEmpty()) {
                /**
                 * ���GET����
                 */
                if (requestHeader.startsWith(Http.Method.GET)) {
                    int begin = requestHeader.indexOf("/?") + 2;
                    int end = requestHeader.indexOf("HTTP/");
                    String condition = requestHeader.substring(begin, end);
                }

                /**
                 * ���POST����
                 * 1.��ȡ�������ݳ���
                 */
                if (requestHeader.startsWith("Content-Length")) {
                    int begin = requestHeader.indexOf("Content-Lengh:") + "Content-Length:".length();
                    String postParamterLength = requestHeader.substring(begin).trim();
                    contentLength = Integer.parseInt(postParamterLength);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        /**
         * ���ͻ�ִ
         */
        StringBuffer sb = new StringBuffer();
        if (contentLength > 0) {
            for (int i = 0; i < contentLength; i++) {
                try {
                    sb.append((char) reader.read());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //���ͻ�ִ
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(socket.getOutputStream());
            pw.println("HTTP/1.1 200 OK");
            pw.println("Content-type:text/html");
            pw.println();
            pw.println("<h1>yes success!</h1>");
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

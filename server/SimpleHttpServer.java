package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLDecoder;
import java.util.*;

/**
 * ��Java����ʵ��HTTP������,��������һ��java.net.ServerSocket���ṩ����Ķ˿��ϼ�������.��ͻ������ı�ʱ,������
 * PrintWriter,����������ض���������,�����ʹ��OutputStream.write(byte[])����,���ص�Ӧ����Ϣ�ַ�������ʹ��
 * String.getBytes()����ת��Ϊ�ֽ����鷵��,����ʹ��PrintStream��print()����д���ı�,��
 * write(byte[])����д�����������.
 * <p>
 * �Թ�������Ŀ¼Ϊweb�ĸ�Ŀ¼�� �ڹ��̵ĸ�Ŀ¼�·�һ��������µ�index.html
 * <p>
 * <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
 * "http://www.w3.org/TR/html4/loose.dtd"> <html> <head> <meta
 * http-equiv="Content-Type" content="text/html; charset=UTF-8">
 * <title>�򵥵Ĳ���</title> </head> <body> ��ã�����һ�� �򵥵�web��������<br>
 * ����һ��ͼƬ��<br>
 * <p>
 * <form action="/index.html"> <img alt="" src="images/test.gif"><br>
 * ������<input type="text" name="name" /><br>
 * ���룺<input type="password" name="pass"></input><br>
 * <input type="submit"/> </form> </body> </html>
 * <p>
 * ����ͼƬλ�ã� ���̸�Ŀ¼/images/test.gif <br>
 * �����������http://localhost/index.html ����չʾindex.html
 *
 * @author guazi
 */
@SuppressWarnings("all")
public class SimpleHttpServer implements Runnable {

    ServerSocket serverSocket;// ������Socket


    /**
     * �����������˿�, Ĭ��Ϊ 80.
     */
    public static int PORT = 80;// ��׼HTTP�˿�

    /**
     * ��ʼ������ Socket �߳�.
     */
    public SimpleHttpServer() {
        try {
            serverSocket = new ServerSocket(PORT);
        } catch (Exception e) {
            System.out.println("�޷�����HTTP������:" + e.getMessage());
        }
        if (serverSocket == null) {
            System.exit(1);// �޷���ʼ������
        }


        new Thread(this).start();
        System.out.println("HTTP��������������,�˿�:" + PORT);
    }


    /**
     * ���з��������߳�, �����ͻ������󲢷�����Ӧ.
     */
    public void run() {
        while (true) {
            try {
                Socket client = null;// �ͻ�Socket
                client = serverSocket.accept();// �ͻ���(������ IE �������)�Ѿ����ӵ���ǰ������
                if (client != null) {
                    System.out.println("���ӵ����������û�:" + client);
                    try {
                        // ��һ�׶�: ��������
                        BufferedReader in = new BufferedReader(
                                new InputStreamReader(client.getInputStream()));

                        System.out.println("�ͻ��˷��͵�������Ϣ: ***************");
                        // ��ȡ��һ��, �����ַ
                        System.out.println("httpЭ��ͷ����Ϣ��");
                        String line = in.readLine();
                        System.out.println(line);
                        String resource = line.substring(line.indexOf('/'),
                                line.lastIndexOf('/') - 5);
                        // ����������Դ�ĵ�ַ
                        resource = URLDecoder.decode(resource, "UTF-8");// ������

                        String method = new StringTokenizer(line).nextElement()
                                .toString();// ��ȡ���󷽷�, GET ���� POST

                        // ��ȡ��������͹������������ͷ����Ϣ
                        while ((line = in.readLine()) != null) {
                            System.out.println(line);

                            if (line.equals("")) {
                                break;
                            }

                        }

                        System.out.println("httpЭ��ͷ������ ***************");
                        System.out.println("�û��������Դ��:" + resource);
                        System.out.println("�����������: " + method);

                        String params = null;

                        if (resource.indexOf("?") > -1) {
                            params = resource
                                    .substring(resource.indexOf("?") + 1);
                            resource = resource.substring(0, resource
                                    .indexOf("?"));
                        }

                        // ��ʾ POST ���ύ������, �������λ����������岿��
                        if ("POST".equalsIgnoreCase(method)) {
                            if (params != null) {
                                params += "&" + in.readLine();
                            } else {
                                params = in.readLine();
                            }
                        }

                        System.out.println("��ӡ�ύ�����ݣ�");
                        printParams(params);

                        // ��ȡ��Դ�����ظ��ͻ���
                        fileReaderAndReturn(resource, client);
                        // �رտͻ�������
                        client.close();
                        System.out.println("�ͻ��˷�����ɣ�");
                    } catch (Exception e) {
                        System.out.println("HTTP����������:" + e.getMessage());
                    }
                }

            } catch (Exception e) {
                System.out.println("HTTP����������:" + e.getMessage());
            }
        }
    }

    /**
     * ��ȡһ���ļ������ݲ����ظ��������.
     *
     * @param fileName �ļ���
     * @param socket   �ͻ��� socket.
     * @throws IOException
     */
    void fileReaderAndReturn(String fileName, Socket socket) throws IOException {
        if ("/".equals(fileName)) {// ���û�ӭҳ�棬�Ǻǣ�
            fileName = "/index.html";
        }
        fileName = fileName.substring(1);

        PrintStream out = new PrintStream(socket.getOutputStream(), true);
        File fileToSend = new File(fileName);

        String fileEx = fileName.substring(fileName.indexOf(".") + 1);
        String contentType = null;
        // ���÷��ص���������
        // �˴���������tomcat/conf/web.xml�����õ�mime-mapping������һ�µġ�����֮�ã���д��ô������
        if ("htmlhtmxml".indexOf(fileEx) > -1) {
            contentType = "text/html;charset=utf8";
        } else if ("jpegjpggifbpmpng".indexOf(fileEx) > -1) {
            contentType = "application/binary";
        }

        if (fileToSend.exists() && !fileToSend.isDirectory()) {
            // http Э�鷵��ͷ
            out.println("HTTP/1.0 200 OK");// ����Ӧ����Ϣ,������Ӧ��
            out.println("Content-Type:" + contentType);
            out.println("Content-Length:" + fileToSend.length());// ���������ֽ���
            out.println();// ���� HTTP Э��, ���н�����ͷ��Ϣ

            FileInputStream fis = null;
            try {
                fis = new FileInputStream(fileToSend);
            } catch (FileNotFoundException e) {
                out.println("<h1>404����</h1>" + e.getMessage());
            }
            byte data[];
            try {
                data = new byte[fis.available()];

                fis.read(data);
                out.write(data);
            } catch (IOException e) {
                out.println("<h1>500����!</h1>" + e.getMessage());
                e.printStackTrace();
            } finally {
                out.close();
                try {
                    fis.close();
                } catch (IOException e) {

                    e.printStackTrace();
                }
            }
        } else {
            out.println("<h1>404����</h1>" + "�ļ�û���ҵ�");
            out.close();

        }

    }

    /**
     * ���������еĲ���
     *
     * @param params
     * @throws IOException
     */
    List<Map<String, Object>> printParams(String params) throws IOException {
        if (params == null) {
            return null;
        }
        List<Map<String, Object>> p = new ArrayList();
        String[] maps = params.split("&");
        for (String temp : maps) {
            String[] map = temp.split("=");
            Map<String, Object> m = new HashMap<String, Object>();
            m.put(map[0], map[1]);
            p.add(m);
        }
        return p;
    }

    /** */
    /**
     * ���� HTTP ������
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            if (args.length != 1) {
                System.out.println("����һ���򵥵�web������ ���˿��ǣ� 80.");
            } else if (args.length == 1) {
                PORT = Integer.parseInt(args[0]);
            }
        } catch (Exception ex) {
            System.err.println("��������ʼ������" + ex.getMessage());
        }

        new SimpleHttpServer();
    }
}



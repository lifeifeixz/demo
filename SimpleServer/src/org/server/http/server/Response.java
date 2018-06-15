package org.server.http.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Response {
    private static final int BUFFER_SIZE = 1024;
    Request request;
    OutputStream outputStream;

    public Response(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public void sendStaticResource() throws IOException {
        byte bytes[] = new byte[BUFFER_SIZE];
        FileInputStream fis = null;
        try {
            File file = new File(HttpServer.WEB_ROOT, request.getUri());
            if (file.exists()) {
                fis = new FileInputStream(file);
                int ch = fis.read(bytes, 0, BUFFER_SIZE);
                while (ch != -1) {
                    outputStream.write(bytes, 0, ch);
                    ch = fis.read(bytes, 0, BUFFER_SIZE);
                }
            } else {
                String errorMessage = "<h1>File not found</h1>";
                outputStream.write(errorMessage.getBytes());
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            if (fis != null)
                fis.close();
        }
    }

    public void parseResponse(String htmlContent) {
        String res = "HTTP/1.1 200 OK\r\nContent-Type: text/html; charset=gbk\r\nContent-Length: " + htmlContent.length() + "\r\n\r\n";
        try {
            outputStream.write(res.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

            try {
                outputStream.flush();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}
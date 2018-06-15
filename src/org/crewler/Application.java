package org.crewler;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by flysLi on 2017/8/12.
 */
public class Application {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://www.jianshu.com/c/yD9GAd?utm_medium=index-collections&utm_source=desktop");
        URLConnection connection = url.openConnection();
        connection.setConnectTimeout(5000);
        InputStream inputStream = connection.getInputStream();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuffer stringBuffer = new StringBuffer();
        String temp = null;
        while ((temp = bufferedReader.readLine()) != null){
            System.out.println(temp);
        }
    }
}

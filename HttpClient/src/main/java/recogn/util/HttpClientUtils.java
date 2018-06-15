package recogn.util;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * http请求工具
 *
 * @author flysLi
 * @date 2018/5/24
 */
public class HttpClientUtils {

    public static Object post() {


        return null;
    }

    public void upload2() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        CloseableHttpResponse httpResponse = null;
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(200000).setSocketTimeout(200000000).build();
        HttpPost httpPost = new HttpPost("https://openapi.saicmotor.com/services/cloud/driverlicense/v1.0.0/driver");
        httpPost.setConfig(requestConfig);
        MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
        File file = new File("D:\\L临时数据\\图片\\驾驶证3.jpg");
        multipartEntityBuilder.addBinaryBody("image_file", file);
        HttpEntity httpEntity = multipartEntityBuilder.build();
        httpPost.setEntity(httpEntity);
        httpPost.setHeader("Authorization", "Bearer 901c81e6-0f42-434c-866a-46090d009a71");

        httpResponse = httpClient.execute(httpPost);
        HttpEntity responseEntity = httpResponse.getEntity();
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        if (statusCode == 200) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(responseEntity.getContent()));
            StringBuffer buffer = new StringBuffer();
            String str = "";
            while ((str = reader.readLine()) != null) {
                buffer.append(str);
            }
            System.out.println(buffer.toString());
        }
        httpClient.close();
        if (httpResponse != null) {
            httpResponse.close();
        }

    }

    public static void main(String[] args) throws IOException {
        HttpClientUtils httpClientUtils = new HttpClientUtils();
        httpClientUtils.upload2();
    }
}

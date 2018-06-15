package org.disktop.workers;

import org.disktop.environ.Localhost;
import org.springframework.util.ClassUtils;

import java.io.IOException;

/**
 * Created by flysLi on 2017/8/25.
 */
public class Bat {
    public void execute() {

    }

    /**
     * 打开一个文件夹
     *
     * @param path
     */
    public void openDir(String path) {
        try {
            Runtime.getRuntime().exec("explorer /, " + "D:\\APP\\屏幕吸色器.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 启动一个软件
     * @param path
     */
    public void startUp(String path) {
        try {
            Runtime.getRuntime().exec("explorer /, " + path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws IOException {
//        System.out.println(Localhost.location());
//        Runtime.getRuntime().exec("C:\\Program Files (x86)\\EditPlus\\editplus.exe");

//        String cmd = "explorer.exe ::{645FF040-5081-101B-9F08-00AA002F954E}";
//        Process process =  Runtime.getRuntime().exec(cmd);

        Runtime.getRuntime().exec("explorer /select, " + "D:\\APP\\屏幕吸色器.exe");//打开某个文件夹并选中某个目录
    }
}

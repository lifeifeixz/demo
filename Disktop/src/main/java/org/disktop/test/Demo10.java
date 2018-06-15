package org.disktop.test;

import java.io.File;
import java.util.Arrays;

/**
 * Created by flysLi on 2017/8/26.
 * 将文件系统生成json
 */
public class Demo10 {
    public static void main(String[] args) {
        Demo10 d = new Demo10();
        d.scan("D:\\学习\\vue\\vue2\\node_modules\\ajv\\lib");
        d.println();
    }

    public void scan(String path) {
        File f = new File(path);
        if (f.isDirectory()) {
            scan(new File(path));
            buf.delete(buf.length() - 2, buf.length());
        } else System.out.format("{\"name\" : \"%s\"}", f.getName());
    }

    StringBuilder buf;
    int kai = 0;

    public Demo10() {
        buf = new StringBuilder();
    }

    public void println() {
        System.out.println(buf);
    }

    private void scan(File f) {
        if (f.isDirectory()) {
            buf.append(space(kai)).append("{\n").append(space(++kai)).append("\"name\" : \"").append(f.getName()).append("\",\n").append(space(kai)).append("\"children\" : [\n");
            kai++;
            Arrays.asList(f.listFiles()).forEach(this::scan);
            buf.delete(buf.length() - 2, buf.length());
            buf.append("\n").append(space(--kai)).append("]\n").append(space(--kai)).append("},\n");
        } else
            buf.append(space(kai)).append("{\n").append(space(++kai)).append("\"name\" : \"").append(f.getName()).append("\"\n").append(space(--kai)).append("},\n");
    }

    public String space(int kai) {
        if (kai <= 0) {
            return "";
        }
        char[] cs = new char[kai << 1];
        Arrays.fill(cs, ' ');
        return new String(cs, 0, cs.length);
    }
}

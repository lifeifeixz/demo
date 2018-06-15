package org.gongxaing.analysis;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * 手机所有模块信息
 *
 * @author flysLi
 * @date 2018/3/29
 */
@SuppressWarnings("All")
public class AnalysisModulars {
    public static void main(String[] args) throws IOException {
        Document document = Jsoup.parse(new File("D:\\temp\\工作\\产品\\原型\\v2.4.0租车后端20180312\\v2.4.020180312租车后端完整版\\review\\screens\\e24d5044-9eeb-43b9-aff0-d74bddd44506.html"), "UTF-8");
        Element table = document.getElementById("s-Table_1");
        Element tbody = table.child(0);
        Element tr = tbody.child(0);
        Elements tds = tr.children();
        for (Element td : tds) {
            System.out.println(td.text());
        }
        System.out.println("以下是查询条件字段");
        Elements singlelines = document.getElementsByClass("singleline");
        for (Element singleline : singlelines) {
            System.out.println(singleline.text());
        }
    }
}

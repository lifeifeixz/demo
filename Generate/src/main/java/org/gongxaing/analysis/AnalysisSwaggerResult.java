package org.gongxaing.analysis;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.gongxaing.model.Field;
import org.gongxaing.model.Fields;

import java.io.File;
import java.io.IOException;

/**
 * 解析出字段的key
 *
 * @author flysLi
 * @date 2018/3/12
 */
public class AnalysisSwaggerResult extends AbstractAnalysisDefault {
    protected String type = "-swaggerResult";

    @Override
    public Fields analysis(File file) {
        if (this.isContain(file.getPath())) {
            return this.analysisLine(file);
        } else {
            return this.analysis(file);
        }
    }

    @Override
    public Fields analysisLine(File file) {
        Fields fields = new Fields();
        try {
            Document document = Jsoup.parse(file, "UTF-8");
            String className = "description";
            Elements fs = document.getElementsByClass(className).get(0).getElementsByClass("propName");
            Elements texts = document.getElementsByClass(className).get(0).getElementsByClass("propDesc");
            for (int i = 0; i < fs.size(); i++) {
                String field = fs.get(i).text();
                String name = texts.get(i).select("p").text();
                fields.add(new Field(field, name));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fields;
    }

    @Override
    public boolean isContain(String path) {
        int index = path.indexOf(type);
        return index > 0 ? true : false;
    }
}

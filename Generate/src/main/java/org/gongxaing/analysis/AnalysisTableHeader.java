package org.gongxaing.analysis;

import org.gongxaing.model.Field;
import org.gongxaing.model.Fields;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * -tableHeader类型
 * 用于解析从原型中复制过来的表格头部字段,
 * 基本上都是一行显示一条的形式呈现。详情请看field.txt
 *
 * @author flysLi
 * @date 2018/3/12
 */
public class AnalysisTableHeader extends AbstractAnalysisDefault {

    protected String type = "-table";

    public List<String> getNames() throws Exception {
        List<String> names = new ArrayList<>(10);
        File file = new File("field-tableHeader.txt");
        //BufferedReader是可以按行读取文件
        FileInputStream inputStream = new FileInputStream("D:\\workspace_student\\FileClient\\src\\main\\java\\test\\gongxaing\\field-tableHeader.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String str = null;
        while ((str = bufferedReader.readLine()) != null) {
            names.add(str.trim());
        }

        //close
        inputStream.close();
        bufferedReader.close();
        return names;
    }

    @Override
    public Fields analysis(File file) {
        if (this.isContain(file.getPath())) {
            return this.analysisLine(file);
        } else {
            return this.analysis.analysis(file);
        }
    }

    @Override
    public Fields analysisLine(File file) {
        Fields names = new Fields();
        //BufferedReader是可以按行读取文件
        FileInputStream inputStream;
        try {
            inputStream = new FileInputStream(file);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                if (str.trim().length() > 0) {
                    Field field = new Field();
                    field.setName(str.trim());
                    names.add(field);
                }
            }
            //close
            inputStream.close();
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return names;
    }

    @Override
    public boolean isContain(String path) {
        int index = path.indexOf(type);
        return index > 0 ? true : false;
    }
}

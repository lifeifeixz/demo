package org.gongxaing.analysis;

import org.gongxaing.model.Field;
import org.gongxaing.model.Fields;

import java.io.*;

/**
 * 解析详情(表单)的责任者
 * 凡是文件名称中包含[-detail]字符串者都被该实例解析
 *
 * @author flysLi
 * @date 2018/3/15
 */
public class AnalysisDetailText extends AbstractAnalysisDefault {
    protected String type = "-detail";

    @Override
    public Fields analysis(File file) {
        /*文件类型是detail*/
        if (this.isContain(file.getPath())) {
            return this.analysisLine(file);
        } else {/*传递给下一个解析者*/
            return this.analysis.analysis(file);
        }
    }

    @Override
    public Fields analysisLine(File file) {
        FileInputStream inputStream = null;
        BufferedReader bufferedReader = null;
        Fields fields = new Fields();
        try {
            inputStream = new FileInputStream(file);
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                str = str.trim();
                if (str.length() > 0 && str.endsWith("：")) {
                    Field field = new Field();
                    field.setName(str);
                    fields.add(field);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                //close
                inputStream.close();
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return fields;
    }

    @Override
    public boolean isContain(String path) {
        int index = path.indexOf(type);
        return index > 0 ? true : false;
    }
}

package org.gongxaing;

import org.gongxaing.analysis.AnalysisSwaggerResult;
import org.gongxaing.analysis.AnalysisTableHeader;

import java.util.List;

/**
 * 流程线
 *
 * @author flysLi
 * @date 2018/3/12
 */
public class AssemblyLine {

    public static void main(String[] args) throws Exception {
        AnalysisTableHeader analysisTableHeader = new AnalysisTableHeader();
        List<String> names = analysisTableHeader.getNames();
        AnalysisSwaggerResult analysisSwaggerResult = new AnalysisSwaggerResult();
        for (int i = 0; i < names.size(); i++) {
//            Field field = analysisSwaggerResult.getFieldByName(names.get(i));
//            if (field != null) {
//                System.out.println("匹配成功:" + field.getName() + "==" + field.getField());
//            }
        }
    }
}

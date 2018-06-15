package org.gongxaing.analysis;

import org.gongxaing.model.Field;
import org.gongxaing.model.Fields;

import java.io.File;
import java.util.List;

/**
 * @author flysLi
 * @date 2018/3/15
 */
public class AnalysisDefault extends AbstractAnalysisDefault {
    @Override
    public Fields analysis(File file) {
        return null;
    }

    @Override
    public List<Field> analysisLine(File file) {
        return null;
    }

    @Override
    public boolean isContain(String path) {
        int index = path.indexOf(type);
        return index > 0 ? true : false;
    }
}

package org.gongxaing.analysis;

import org.gongxaing.model.Fields;

import java.io.File;

/**
 * @author flysLi
 * @date 2018/3/15
 */
public interface Analysis {

    /**
     * 解析出字段
     *
     * @return
     */
    Fields analysis(File file);
}

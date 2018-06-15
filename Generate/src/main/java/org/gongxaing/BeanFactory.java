package org.gongxaing;

import org.gongxaing.analysis.*;
import org.gongxaing.made.MadeDefault;
import org.gongxaing.made.MadeDetail;
import org.gongxaing.made.MadeStrategy;
import org.gongxaing.made.MadeTable;

/**
 * 提供一些复杂bean的组装
 *
 * @author flysLi
 * @date 2018/3/15
 */
public class BeanFactory {

    /**
     * 获取解析责任链bean
     *
     * @return
     */
    public static Analysis getAnalysisInstance() {
        AbstractAnalysisDefault detailAnalysis = new AnalysisDetailText();
        AbstractAnalysisDefault tableHeaderAnalysis = new AnalysisTableHeader();
        AbstractAnalysisDefault swaggerResult = new AnalysisSwaggerResult();
        AbstractAnalysisDefault analysisDefault = new AnalysisDefault();

        detailAnalysis.setAnalysis(tableHeaderAnalysis);
        tableHeaderAnalysis.setAnalysis(swaggerResult);
        swaggerResult.setAnalysis(analysisDefault);
        return detailAnalysis;
    }

    public static MadeStrategy getMadeStrategyInstance() {
        MadeStrategy detailStrategy = new MadeDetail();
        MadeStrategy tableStrategy = new MadeTable();
        MadeStrategy defaultStrategy = new MadeDefault();

        detailStrategy.setMadeStrategy(tableStrategy);
        tableStrategy.setMadeStrategy(defaultStrategy);
        return detailStrategy;
    }
}

package org.gongxaing.product;

import org.gongxaing.BeanFactory;
import org.gongxaing.analysis.Analysis;
import org.gongxaing.made.MadeStrategy;
import org.gongxaing.model.Modular;

/**
 * @author flysLi
 * @date 2018/4/10
 */
public class MainStructureProxy implements MainStructure {
    Analysis analysis = BeanFactory.getAnalysisInstance();
    MadeStrategy madeStrategy = BeanFactory.getMadeStrategyInstance();
    Modular modular;

    public MainStructureProxy() {
    }

    public MainStructureProxy(Analysis analysis) {
        this.analysis = analysis;
    }

    public MainStructureProxy(MadeStrategy madeStrategy) {
        this.madeStrategy = madeStrategy;
    }

    public MainStructureProxy(Analysis analysis, MadeStrategy madeStrategy) {
        this.analysis = analysis;
        this.madeStrategy = madeStrategy;
    }

    public void made(Modular modular) {
        madeStrategy.make(modular);
        System.out.println("制作完成");
    }
}

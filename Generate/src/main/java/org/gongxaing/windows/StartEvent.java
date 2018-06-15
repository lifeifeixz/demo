package org.gongxaing.windows;

import jars.ResourceTransportationUtil;
import org.gongxaing.BaseInfo;
import org.gongxaing.BeanFactory;
import org.gongxaing.made.MadeStrategy;
import org.gongxaing.model.Field;
import org.gongxaing.model.Fields;
import org.gongxaing.model.Modular;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * @author flysLi
 * @date 2018/3/29
 */
public class StartEvent implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Button start = (Button) e.getSource();
        IndexFrame indexFrame = (IndexFrame) start.getParent();
        FileDialog upload = indexFrame.d1;

        //1.得到输入的source(使用客户端传入的source暂时使用新的解析器TextAreaAnalysis)
        String source = indexFrame.sourceArea.getText();
        String[] tds = source.split("\n");
        //2.得到type
        String type = indexFrame.type.getSelectedItem();
        Fields fieldList = new Fields();
        for (int i = 0; i < tds.length; i++) {
            Field field = new Field();
            field.setName(tds[i]);
            fieldList.add(field);
        }
        //3.开始生成
        Modular modular = new Modular();
        modular.setTds(fieldList);
        modular.setType(type);
        /*made*/
        MadeStrategy madeStrategy = BeanFactory.getMadeStrategyInstance();
        String product = madeStrategy.make(modular);
        String outPath = BaseInfo.PRODUCT_BASEPATH + System.currentTimeMillis() + new Random().nextInt(100000) + ".vue";
        ResourceTransportationUtil.writer(product, outPath);
        //4.打开生成文件
        File file = new File(outPath);
        Runtime ce = Runtime.getRuntime();
        try {
            ce.exec("cmd   /c   start  " + file.getAbsolutePath());
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}

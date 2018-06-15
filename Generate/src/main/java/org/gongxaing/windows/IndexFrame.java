package org.gongxaing.windows;

import java.awt.*;

/**
 * @author flysLi
 * @date 2018/3/29
 */
public class IndexFrame extends Frame {
    public Button start, choiceFileBtn, exitout;
    public int baseX = 0;
    public FileDialog d1;
    public Label uploadLabel;
    public TextArea sourceArea;
    public Choice type;

    public IndexFrame(String str) {
        super(str);
    }

    public void init() {
        /*设置窗口居中显示*/
        this.setLayout(null);
        /*设置icon*/
        setSize(600, 800);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

        /*源label*/
        uploadLabel = new Label("SOURCE");
        uploadLabel.setBounds(baseX + 50, 170, 60, 30);
        add(uploadLabel);
        /*源输入*/
        sourceArea = new TextArea();
        sourceArea.setBounds(baseX + 110, 170, 50, 30);
        int sourAreaHeight = 100;
        sourceArea.setSize(300, sourAreaHeight);
        add(sourceArea);

        /*下拉框label*/
        Label select = new Label("TYPE");
        select.setBounds(baseX + 50, 200 + sourAreaHeight, 60, 30);
        add(select);
        //下拉框组件
        type = new Choice();
        type.setBounds(baseX + 110, 200 + sourAreaHeight, 150, 30);
        type.add("-table");
        type.add("-detail");
        type.add("-form");
        add(type);

         /*开始按钮*/
        start = new Button("执行");
        start.setBounds(baseX + 90, 280 + sourAreaHeight, 60, 30);
        start.addActionListener(new StartEvent());
        add(start);

        /*退出按钮*/
        exitout = new Button("退出");
        exitout.setBounds(baseX + 250, 280 + sourAreaHeight, 60, 30);
        exitout.addActionListener(new CloseEvent());
        add(exitout);

        /*文件选择窗口*/
        d1 = new FileDialog(this, "Open File", FileDialog.LOAD);
    }

    public static void main(String[] args) {
        IndexFrame indexFrame = new IndexFrame("生成工具");
        indexFrame.init();
    }
}

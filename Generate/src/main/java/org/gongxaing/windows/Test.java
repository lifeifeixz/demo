package org.gongxaing.windows;

import java.awt.*;

/**
 * @author flysLi
 * @date 2018/3/29
 */
public class Test {
    public static void main(String[] args) {
        Frame frame = new Frame("My first windows");
        int windowWidth = 500; //获得窗口宽
        int windowHeight = 360; //获得窗口高
        Toolkit kit = Toolkit.getDefaultToolkit(); //定义工具包
        Dimension screenSize = kit.getScreenSize(); //获取屏幕的尺寸
        int screenWidth = screenSize.width; //获取屏幕的宽
        int screenHeight = screenSize.height; //获取屏幕的高
        frame.setLocation(screenWidth / 2 - windowWidth / 2, screenHeight / 2 - windowHeight / 2);//设置窗口居中显示


        frame.setLayout(new GridLayout(7, 1));
        //lable组件
        frame.add(new Label("fuxuan (choice many):"));
        //checkbox组件
        frame.add(new Checkbox("you are shabi"));
        frame.add(new Checkbox("but no"));
        //Choice 组件
        Choice c = new Choice();
        c.add("Red");
        c.add("Green");
        c.add("Blue");
        frame.add(c);

        //List组件
        List l = new List(3, false);
        l.add("Java");
        l.add("C#");
        l.add("Object-c");
        frame.add(l);

        //Button组件
        Button button = new Button("close");
        button.addActionListener(new CloseEvent());
        frame.add(button);
        frame.pack();//调整窗口以容纳所有的组件
        frame.setVisible(true);//显示窗口
    }
}

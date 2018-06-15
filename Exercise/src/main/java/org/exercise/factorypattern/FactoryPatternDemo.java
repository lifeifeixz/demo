package org.exercise.factorypattern;

/**
 * Created by flysLi on 2017/9/6.
 */
public class FactoryPatternDemo {
    public static void main(String[] args) {
        //使用工厂，通过传递类型信息来获取实体类的对象
        ShapeFactory factory = new ShapeFactory();

        //获取Circle对象，并调用他的draw方法
        Shape circle = factory.getShape("CIRCLE");

        circle.draw();

    }
}

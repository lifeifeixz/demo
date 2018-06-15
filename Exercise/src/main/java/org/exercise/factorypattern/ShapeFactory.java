package org.exercise.factorypattern;

/**
 * Created by flysLi on 2017/9/6.
 * 创建一个工厂，生成基于给定信息的实体类的对象。
 */
public class ShapeFactory {
    public Shape getShape(String shapeType) {
        if (shapeType==null){
            return null;
        }
        if (shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        }else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        }else if (shapeType.equalsIgnoreCase("SOUARE")){
            return new Square();
        }
        return null;
    }
}

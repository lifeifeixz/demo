package demo;

/**
 * 测试子类改变父类属性时，当前类是否会得到最新的属性值
 *
 * @author flysLi
 * @date 2018/6/7
 */
public class SuperFieldClient {
    public static void main(String[] args) {
        Son son = new Son("小青");
        Father father = new Father();
        System.out.println(son.getName());
        System.out.println(father.getName());
    }
}

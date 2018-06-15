package com.xz.model;

/**
 * @author flysLi
 * @date 2018/6/14
 */
public class HelloWorld {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sayHello() {
        System.out.println("Hello" + name);
    }
}

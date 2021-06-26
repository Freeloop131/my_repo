package com.songhongkang;

/**
 * @author : lihuan.zheng
 * @version V1.0
 * @Project: learning
 * @Package com.songhongkang
 * @Description: 面向对象：类和对象的使用
 * @date Date : 2021年03月14日 16:09
 */
public class PersonTest {

    /**
     *一、类和对象的使用（面向对象思想的落地与实现）
     * 1.创建类，设计类的成员
     * 2.创建类的对象
     * 3.通过 对象.属性 或 对象.方法 调用对象的结构
     *
     * 二、如果创建了一个类的多个对象，则每个对象都独立拥有一套类的属性（非static的）
     *意味着如果我们修改一个对象的属性a的值，则不影响另一个对象的属性a的值。
     *
     */
    public static void main(String[] args) {

        //创建Person类的对象
        Person p1 = new Person();
        //调用对象的结构：属性，方法
        //调用属性：对象.属性
        p1.name = "Tom";
        p1.isMale = true;
        //调用方法：对象.方法
        p1.eat();
        p1.sleep();
        p1.talk(p1.name,"English");

        //**************************
        Person p2 = new Person();
        System.out.println(p2.name);
        System.out.println(p2.age);
        System.out.println(p2.isMale);

        //**************************
        Person p3 = p1; // 将p1的对象地址赋给了p3，导致p1,p3指向了堆空间中同一个对象实体。
        System.out.println(p3.name);
        System.out.println(p3.isMale);

        p3.age = 25;
        System.out.println(p1.age);
    }

}

class Person{

    //属性
    String name;
    int age = 20;
    boolean isMale;

    //方法
    public void eat(){
        System.out.println("I can eat.");
    }

    public void sleep(){
        System.out.println("I can sleep.");
    }

    public void talk(String name, String language){
        System.out.println(name + " can speak " + language);
    }

}
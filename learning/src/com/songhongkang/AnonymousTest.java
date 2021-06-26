package com.songhongkang;

/**
 * @author : lihuan.zheng
 * @version V1.0
 * @Project: learning
 * @Package com.songhongkang
 * @Description: 匿名类的测试
 * @date Date : 2021年03月21日 15:06
 */
public class AnonymousTest {

    public static void main(String[] args) {
        new Phone().sendEmail();    //对象1
        new Phone().playGame();  // 对象2

        new Phone().price = 1999;
        System.out.println(new Phone().price); //0.0  -- 不同于上面的对象，这是new的另一个对象

        System.out.println("***********************");

        //匿名对象的使用--常见
        PhoneFactory phoneFactory = new PhoneFactory();
        phoneFactory.showPhone(new Phone());
    }
}

class PhoneFactory{
    public void showPhone(Phone p){
        p.sendEmail();
        p.playGame();
    }
}

class Phone{

    double price;

    public void sendEmail(){
        System.out.println("This phone can send email.");
    }

    public void playGame(){
        System.out.println("This phone can play game.");
    }
}

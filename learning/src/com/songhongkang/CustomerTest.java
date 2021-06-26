package com.songhongkang;

/**
 * @author : lihuan.zheng
 * @version V1.0
 * @Project: learning
 * @Package com.songhongkang
 * @Description: TODO
 * @date Date : 2021年03月20日 16:45
 */
public class CustomerTest {

    public static void main(String[] args) {

        Customer c1 = new Customer();
        c1.sleep(8);
    }
}

class Customer{

    //属性
    String name;
    int age;
    boolean isMale;

    //方法
    public void eat(){
        System.out.println("I like eat.");
    }

    public void sleep(int hour){
        System.out.println("I sleep " + hour);
        eat();
    }

    public String getName(){
        return name;
    }

    public String getNation(String nation){
        String info = "My nation is " + nation;
        return nation;
    }
}

package com.songhongkang;

/**
 * @author : lihuan.zheng
 * @version V1.0
 * @Project: learning
 * @Package com.songhongkang
 * @Description: 在类中定义一个方法，打印1到time之间每个整数的半径和圆面积
 * @date Date : 2021年04月11日 15:46
 */
public class PassObject {

    public void printArea(MyCircle c,int time){
        System.out.println("Radius\t\tArea");

        for(int i = 1;i <= time;i++){
            c.radius = i;
            System.out.println(c.radius+"\t\t"+c.findArea());
        }
        c.radius = time + 1;
        System.out.println("Now radius is :" + c.radius);
    }

    public static void main(String[] args) {
        PassObject p = new PassObject();
        MyCircle c = new MyCircle();
        p.printArea(c,5);
        System.out.println("Now radius is :" + c.radius);
    }
}

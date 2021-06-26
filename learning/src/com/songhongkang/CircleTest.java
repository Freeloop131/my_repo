package com.songhongkang;

/**
 * @author : lihuan.zheng
 * @version V1.0
 * @Project: learning
 * @Package com.songhongkang
 * @Description: 利用面向对象编程，计算圆的面积
 * @date Date : 2021年03月20日 16:48
 */
public class CircleTest {

    public static void main(String[] args) {

        Circle c1 = new Circle();
        c1.radius = 2.1;
        double area = c1.calArea();
        System.out.println(area);
    }

}


class Circle{

    double radius;

    public double calArea(){
        double area = Math.PI * radius * radius;
        return area;
    }
}



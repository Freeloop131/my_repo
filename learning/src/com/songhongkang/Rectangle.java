package com.songhongkang;

/**
 * @author : lihuan.zheng
 * @version V1.0
 * @Project: learning
 * @Package com.songhongkang
 * @Description: 输出m行n列的由*组成的矩形，并输出其面积，用面向编程的思想
 * @date Date : 2021年03月20日 16:58
 */
public class Rectangle {

    public static void main(String[] args) {
        Rectangle r1 = new Rectangle();
        double area = r1.outputRectangle(10, 8);
        System.out.println("面积是：" + area);
    }

    public double outputRectangle(int m, int n){
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        return m*n;
    }
}

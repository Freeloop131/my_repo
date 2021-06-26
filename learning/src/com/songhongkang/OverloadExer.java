package com.songhongkang;

/**
 * @author : lihuan.zheng
 * @version V1.0
 * @Project: learning
 * @Package com.songhongkang
 * @Description:
 * 1.定义三个重载方法并调用：
 * 三个方法分别接收一个int参数，两个int参数，一个字符串参数
 * 分别执行平方运算并输出结果，相乘输出结果，输出字符串信息
 *
 * 2.定义三个重载方法max()
 * 分别求两个int值中的最大值，两个double值中的最大值，三个double值中的最大值
 * @date Date : 2021年03月21日 21:35
 */
public class OverloadExer {

    public void mOL(int i){
        System.out.println(i * i);
    }
    public void mOL(int i ,int j){
        System.out.println(i * j);
    }
    public void mOL(String s){
        System.out.println(s);
    }

    public int max(int i, int j){
        return (i > j)?i:j;
    }

    public double max(double m,double n){
        return (m > n)?m:n;
    }

    public double max(double x,double y ,double z){
        double tempMax = (x > y)?x:y;
        return (tempMax > z)?tempMax:z;
    }


    public static void main(String[] args) {
        OverloadExer o1 = new OverloadExer();
        o1.mOL(2);
        o1.mOL(2,3);
        o1.mOL("Hello World!");

        int m1 = o1.max(22, 34);
        double m2 = o1.max(23.2,23.4);
        double m3 = o1.max(656.5,90.1,34);
        System.out.println(m1 + "," + m2 + "," + m3);

    }
}

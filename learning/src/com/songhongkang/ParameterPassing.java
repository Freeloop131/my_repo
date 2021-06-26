package com.songhongkang;

/**
 * @author : lihuan.zheng
 * @version V1.0
 * @Project: learning
 * @Package com.songhongkang
 * @Description: 参数值传递题目：需要在method方法被调用之后，仅打印出a=100,b=200,请写出method方法的代码
 * @date Date : 2021年04月11日 12:16
 */
public class ParameterPassing {

    public static void main(String[] args) {

        int a = 10;
        int b = 10;
        ParameterPassing p = new ParameterPassing();
        p.method(a,b);
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

    public void method(int a , int b){
        a = a * 10;
        b = b * 20;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.exit(0);   //直接退出程序
    }
}

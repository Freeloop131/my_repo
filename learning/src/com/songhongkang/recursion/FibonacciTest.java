package com.songhongkang.recursion;

/**
 * @author : lihuan.zheng
 * @version V1.0
 * @Project: learning
 * @Package com.songhongkang.recursion
 * @Description:
 * 计算斐波那契数列第n个数的值
 * 斐波那契数列：
 * 1 1 2 3 5 8 13 21 34 55
 * 规律：一个数等于前面两个数之和
 * @date Date : 2021年04月11日 18:25
 */
public class FibonacciTest {

    public int fibonacci(int n){
        if(n == 1 || n == 2){
            return 1;
        }else{
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }

    public static void main(String[] args) {
        FibonacciTest f = new FibonacciTest();
        int res = f.fibonacci(10);
        System.out.println(res);
    }
}

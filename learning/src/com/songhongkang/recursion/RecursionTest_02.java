package com.songhongkang.recursion;

/**
 * @author : lihuan.zheng
 * @version V1.0
 * @Project: learning
 * @Package com.songhongkang.recursion
 * @Description:
 * 已知一个数列：f(0) = 1, f(1)=4, f(n+2) = 2*f(n+1) + f(n)
 * @date Date : 2021年04月11日 18:22
 */
public class RecursionTest_02 {

    public static void main(String[] args) {
        RecursionTest_02 f = new RecursionTest_02();
        System.out.println(f.f(10));
    }

    public int f(int n){
        if(n == 0){
            return 1;
        }else if(n == 1){
            return  4;
        }else{
            return 2*f(n-1) + f(n-2);
        }
    }
}

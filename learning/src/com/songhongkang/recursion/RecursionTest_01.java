package com.songhongkang.recursion;

/**
 * @author : lihuan.zheng
 * @version V1.0
 * @Project: learning
 * @Package com.songhongkang.recursion
 * @Description: 求1-100的累加
 * @date Date : 2021年04月11日 17:51
 */
public class RecursionTest_01 {

    public static void main(String[] args) {
        //用for循环实现
        int sum = 0;
        for(int i = 1;i <= 100;i++){
            sum += i;
        }
        System.out.println(sum);

        RecursionTest_01 r = new RecursionTest_01();
        System.out.println(r.getSum(100));

    }

    //用递归的方法实现
    public int getSum(int n){
        if(n == 1){
            return 1;
        }else{
            return n + getSum(n-1);
        }
    }
}

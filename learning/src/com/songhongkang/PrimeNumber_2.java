package com.songhongkang;

/**
 * 对 PrimeNumber_1.java 的优化
 * 需求：输出1-100000中的所有质数
 * 质数：素数。只能被1及本身整除的自然数。2是最小的质数
 * 实现思路：对于每个自然数，从2到这个数-1为止结束，都不能整除。
 */
public class PrimeNumber_2 {
    public static void main(String[] args) {

        boolean isFlag = true;  // 用于标识i是否被j除尽，一旦除尽，修改其值为false
        int count = 0;  //记录质数的个数

        //获取当前时间距离1970-01-01 00:00:00的毫秒数
        long start = System.currentTimeMillis();

        for(int i = 2;i <= 100000;i++) {

            //for (int j = 2; j < i; j++) {
            for (int j = 2; j <= Math.sqrt(i); j++) {   //优化二：对本身是质数的自然数也有效
                if (i % j == 0) {
                    isFlag = false;
                    break; // 优化一：只对本身非质数的自然数有效
                }
            }

            if(isFlag == true){

                //System.out.println(i);
                count++;
            }

            //重置isFlag
            isFlag = true;
        }

        long end = System.currentTimeMillis();
        System.out.println("质数的个数是："+count);
        System.out.println("所花费的时间为： "+ (end-start));   //10168-未优化  1002-优化一  11-优化二

    }
}

package com.songhongkang;
/*
对 PrimeNunber_2 的另一种写法
 */
public class PrimeNumber_3 {
    public static void main(String[] args) {

        int count = 0; //记录有多少个质数

        //获取当前时间距离1970-01-01 00:00:00 的毫秒数
        long start = System.currentTimeMillis();

        label:for(int i = 2;i <= 100000; i++){

            for(int j = 2;j <= Math.sqrt(i); j++){
                if(i % j == 0){
                    continue label;
                }
            }

            //能执行到此步骤的都是质数
            count++;
        }

        long end = System.currentTimeMillis();
        System.out.println("质数的个数为："+count);
        System.out.println("所花费的时间为："+(end-start));  //12

    }
}

package com.songhongkang;
/*
* 练习：100以内所有质数的输出 --> 从2开始，到这个数-1为止结束，都不能被整除
* 质数：素数，只能被1及其本身整除的自然数，2是最小的质数。
* */
public class PrimeNumber_1 {

    public static void main(String[] args) {

        for(int i = 2;i <= 100;i++){    //遍历100以内的自然数
            boolean isFlag = true;

            for(int j = 2;j < i;j++){
                if(i % j == 0){
                    isFlag = false;
                }
            }

            if(isFlag == true){
                System.out.println(i);
            }
            //重置isFlag
            isFlag = true;

        }
    }
}

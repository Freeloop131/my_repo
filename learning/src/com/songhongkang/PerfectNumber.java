package com.songhongkang;
/*
输出1000以内的所有完数。
完数：完全数。一个数恰好等于它的因子之和。如6=1+2+3。
因子：除去它本身的其他约数。
 */
public class PerfectNumber {
    public static void main(String[] args) {

        int factorTotal = 0;

        for(int i = 1;i <= 1000;i++) {

            for (int j = 1; j <= i/2; j++) {

                if (i % j == 0) {
                    factorTotal += j;
                }
            }

            if (factorTotal == i) {
                System.out.println(i);
            }

            //重置factorTotal
            factorTotal = 0;
        }
    }
}

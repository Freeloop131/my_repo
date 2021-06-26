package com.songhongkang;

/**
 * @author : lihuan.zheng
 * @version V1.0
 * @Project: learning
 * @Package com.songhongkang
 * @Description: TODO
 * @date Date : 2021年03月06日 18:32
 */
public class Array_exer_01 {

    public static void main(String[] args) {

        int sum = 0;
        int[][] arr = new int[][]{{3,5,8},{12,9},{7,0,6,4}};
        for(int i = 0;i < arr.length;i++){
            for(int j = 0;j < arr[i].length;j++){
                sum += arr[i][j];
            }
        }
        System.out.printf("Summary:"+sum);
    }
}

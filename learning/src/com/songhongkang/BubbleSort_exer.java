package com.songhongkang;

import java.util.Arrays;

/**
 * @author : lihuan.zheng
 * @version V1.0
 * @Project: learning
 * @Package com.songhongkang
 * @Description: 冒泡排序练习
 * @date Date : 2021年03月13日 12:34
 */
public class BubbleSort_exer {

    public static void main(String[] args) {

        int arr[] = new int[]{98,-12,-1,88,45,32};
        for(int i = 0;i < arr.length - 1;i++){
            for(int j = 0;j < arr.length - 1 - i;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));

        //TODO 冒泡排序的时间复杂度O(n^2);快排时间复杂度O(nlog2n);堆排序，归并排序
    }
}

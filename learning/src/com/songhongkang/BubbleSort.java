package com.songhongkang;

/**
 * @author : lihuan.zheng
 * @version V1.0
 * @Project: learning
 * @Package com.songhongkang
 * @Description: 冒泡排序
 * @date Date : 2021年03月07日 18:06
 */
public class BubbleSort {
    public static void main(String[] args) {

        int[] arr = new int[]{43,32,-98,90,2,45,-12,36};

        //冒泡排序
        for(int i = 0;i < arr.length -  1;i++){
            for(int j = 0;j < arr.length - 1 - i;j++){
                 if(arr[j] > arr[j+1]){
                     int temp = arr[j];
                     arr[j] = arr[j+1];
                     arr[j+1] = temp;
                 }
            }
            //每一大轮结束之后，输出当前结果
            for(int k = 0;k < arr.length;k++){
                System.out.print(arr[k]+"\t");
            }
            System.out.println();
        }

        for(int i = 0;i < arr.length;i++){
            System.out.print(arr[i]+"\t");
        }
        System.out.println();
    }
}

package com.songhongkang;

/**
 * @author : lihuan.zheng
 * @version V1.0
 * @Project: learning
 * @Package com.songhongkang
 * @Description: 数组的反转
 * @date Date : 2021年03月07日 12:39
 */
public class Array_exer_06 {

    public static void main(String[] args) {

        String[] arr = new String[]{"A","B","C","D","E","F","G","H"};

        //反转方法一
        /*for(int i = 0;i < arr.length / 2;i++){
            String temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }*/

        //反转方法二
        for(int i=0,j=arr.length-1;i<j;i++,j--){
            String temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        //遍历
        for(int i = 0;i < arr.length;i++){
            System.out.print(arr[i]+"\t");
        }
    }
}

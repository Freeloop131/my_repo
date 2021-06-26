package com.songhongkang;

/**
 * @author : lihuan.zheng
 * @version V1.0
 * @Project: learning
 * @Package com.songhongkang
 * @Description: 将arr1的值复制到arr2
 * @date Date : 2021年03月07日 12:01
 */
public class Array_exer_05 {
    public static void main(String[] args) {

        int[] arr1,arr2;
        arr1 = new int[]{2,3,5,7,11,13,17,19};

        for(int i = 0;i < arr1.length;i++){
            System.out.print(arr1[i]+"\t");
        }

        //将arr1的值复制到arr2
        arr2 = new int[arr1.length];
        for(int i = 0;i < arr1.length;i++){
            arr2[i] = arr1[i];
        }

        //修改arr2中偶索引元素，使其等于索引值(如arr2[0]=0;arr2[2]=2)
        for(int i = 0;i < arr2.length;i++){
            if(i % 2 == 0){
                arr2[i] = i;
            }
        }

        System.out.println();
        for(int i = 0;i < arr1.length;i++){
            System.out.print(arr1[i]+"\t");
        }

        System.out.println();
        for(int i = 0;i < arr2.length;i++){
            System.out.print(arr2[i]+"\t");
        }
    }
}

package com.songhongkang;

/**
 * @author : lihuan.zheng
 * @version V1.0
 * @Project: learning
 * @Package com.songhongkang
 * @Description: 将arr1的地址值赋给arr2
 * @date Date : 2021年03月07日 12:01
 */
public class Array_exer_04 {
    public static void main(String[] args) {

        int[] arr1,arr2;
        arr1 = new int[]{2,3,5,7,11,13,17,19};

        for(int i = 0;i < arr1.length;i++){
            System.out.print(arr1[i]+"\t");
        }

        //这里的操作不能说是数组的复制，是把arr1数组的地址给到arr2，那么此时arr2所指向的堆空间中的地址跟arr1所指向的是同一个地址
        //简单的说，就是arr1和arr2的地址值相同，都是指向了堆空间的同一个数组实体
        arr2 = arr1;

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

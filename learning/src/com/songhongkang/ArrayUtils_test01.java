package com.songhongkang;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author : lihuan.zheng
 * @version V1.0
 * @Project: learning
 * @Package com.songhongkang
 * @Description: 测试 Arrays工具类的各个方法
 * @date Date : 2021年03月11日 11:47
 */
public class ArrayUtils_test01 {

    public static void main(String[] args) {

        //1.boolean equals(int[] a, int[] b) 判断两个数组是否相等
        int[] arr1 = new int[]{1,2,3,4};
        int[] arr2 = new int[]{1,3,2,4};
        boolean isArrayEquals = Arrays.equals(arr1, arr2);
        System.out.println(isArrayEquals);      //false

        //2.String toSring(int[] a) 输出数组信息，实际上将数组元素以字符串的形式打印出来
        System.out.println(Arrays.toString(arr1)); //[1, 2, 3, 4]
        System.out.println(Arrays.toString(arr2)); //[1, 3, 2, 4]

        //3.void fill(int[] a,int val) 将数组中的每个元素都替换成指定的值
        Arrays.fill(arr1,10);
        System.out.println(Arrays.toString(arr1));  //[10, 10, 10, 10]

        //4.void sort(int[] a)  对数组排序
        Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr2));  // [1, 2, 3, 4]

        //5.int binarySearch(int[] a,int key) 二分查找法检索数组中的指定数据。使用二分查找的前提是：数组有序
        int[] arr3 = new int[]{-98,-34,2,34,56,105,43,88,-100};
        int index = Arrays.binarySearch(arr3, -64);
        if(index >= 0){
            System.out.printf("找到了！索引值为："+index);
        }else {
            System.out.printf("没有找到！");
        }
    }
}

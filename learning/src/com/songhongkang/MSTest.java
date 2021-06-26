package com.songhongkang;

/**
 * @author : lihuan.zheng
 * @version V1.0
 * @Project: learning
 * @Package com.songhongkang
 * @Description: 定义一个int类型数组，int[] arr = new int[]{12,3,3,34,56,77,432};
 * 让数组每个位置上的值除以首位置的元素，得到结果，作为该位置上的新值。
 * @date Date : 2021年04月11日 12:25
 */
public class MSTest {

    public static void main(String[] args) {
        int[] arr = new int[]{12,3,3,34,56,77,432};
        int temp = arr[0];
        for(int i = 0;i < arr.length;i++){
            arr[i] = arr[i] / temp;
        }

        for(int i = 0;i < arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}

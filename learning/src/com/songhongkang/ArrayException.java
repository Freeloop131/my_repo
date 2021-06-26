package com.songhongkang;

/**
 * @author : lihuan.zheng
 * @version V1.0
 * @Project: learning
 * @Package com.songhongkang
 * @Description: 数组中的常见异常
 * @date Date : 2021年03月13日 11:02
 */
public class ArrayException {
    /*
    1.数组角标的越界异常：ArrayIndexOutOfBoundException
    2.空指针异常：NullPointerException
     */
    public static void main(String[] args) {

        int[] arr = new int[]{1,2,3,4,5};
        //System.out.println(arr[6]);      //java.lang.ArrayIndexOutOfBoundsException
        //System.out.println(arr[-2]);    // java.lang.ArrayIndexOutOfBoundsException

        //空指针异常
        //情况一
        int[] arr1 = new int[]{1,2,3,4};
        arr1 = null;
        //System.out.println(arr1[0]);    //NullPointerException

        //情况二：
        int[][] arr2 = new int[4][];
        //System.out.println(arr2[0][0]); //NullPointerException

        //情况三：
        String[] arr3 = new String[]{"AA","BB","CC"};
        //arr3[0] = null;
        //System.out.println(arr3[0].toString());     // java.lang.NullPointerException
    }
}

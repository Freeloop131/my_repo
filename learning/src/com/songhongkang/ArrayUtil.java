package com.songhongkang;

/**
 * @author : lihuan.zheng
 * @version V1.0
 * @Project: learning
 * @Package com.songhongkang
 * @Description: 自定义数组工具类
 * @date Date : 2021年03月21日 15:25
 */
public class ArrayUtil {

    //求数组最大值
    public int getMax(int[] arr){
        int maxValue = arr[0];
        for(int i = 0;i < arr.length;i++){
            if(arr[i] > maxValue){
                maxValue = arr[i];
            }
        }
        return maxValue;
    }

    //求数组最小值
    public int getMin(int[] arr){
        int minValue = arr[0];
        for(int i = 0;i < arr.length;i++){
            if(arr[i] < minValue){
                minValue = arr[i];
            }
        }
        return minValue;
    }

    //求数组和
    public int getSum(int[] arr){
        int sumValue = 0;
        for(int i = 0;i < arr.length;i++){
            sumValue += arr[i];
        }
        return sumValue;
    }

    //求数组平均值
    public int getAvg(int[] arr){
        int avgValue = (int)getSum(arr)/arr.length;
        return avgValue;
    }

    //反转数组
    public void reverse(int[] arr){
        for(int i = 0;i < arr.length / 2;i++){
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }

    }

    //复制数组
    public int[] copy(int[] arr){
        int arr1[] = new int[arr.length];
        for(int i = 0;i < arr.length;i++){
            arr1[i] = arr[i];
        }
        return arr1;
    }

    //数组排序-冒泡排序
    public void sort(int[] arr){
        for(int i = 0;i < arr.length-1;i++){
            for(int j = 0;j < arr.length-1-i;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    //遍历数组，返回 [..,..,]
    public String print(int[] arr){
        String arrString = "";
        for(int i = 0;i < arr.length;i++){
            if( arr.length == 1){
                arrString = "[" + arr[i] + "]";
            }
            else {
                if (i == 0) {
                    arrString = "[" + String.valueOf(arr[i]) + ",";
                }
                if (i == arr.length - 1) {
                    arrString = arrString + String.valueOf(arr[i]) + "]";
                } else if (i != 0 && i != arr.length - 1) {
                    arrString = arrString + String.valueOf(arr[i]) + ",";
                }
            }

        }
        return arrString;
    }

    //查找指定元素-线性查找
    public int search(int[] arr,int des){
        for(int i = 0;i < arr.length;i++){
            if(arr[i] == des){
                return i;
            }
        }
        return -1;      // 返回-1表示没找到
    }
}

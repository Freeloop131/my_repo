package com.songhongkang;

/**
 * @author : lihuan.zheng
 * @version V1.0
 * @Project: learning
 * @Package com.songhongkang
 * @Description: 二分查找
 * @date Date : 2021年03月07日 15:09
 */
public class Array_exer_08 {
    public static void main(String[] args) {

        int[] arr = new int[]{-98,-50,1,45,67,78,90,107};
        int dest = 67;
        int head = 0; //首索引
        int end = arr.length - 1; //末索引

        boolean isFlag = true;

        while (head <= end){

            int middle = (head + end)/2;
            if(dest == arr[middle]){
                System.out.println("找到了指定的元素，位置为："+middle);
                isFlag = false;
                break;
            }else if (arr[middle] > dest){
                end = middle - 1;
            }else{  //arr[middle] < dest
                head = middle + 1;
            }
        }

        if(isFlag){
            System.out.println("没有找到！");
        }
    }
}

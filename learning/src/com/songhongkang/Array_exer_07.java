package com.songhongkang;

/**
 * @author : lihuan.zheng
 * @version V1.0
 * @Project: learning
 * @Package com.songhongkang
 * @Description: 线性查找
 * @date Date : 2021年03月07日 12:53
 */
public class Array_exer_07 {
    public static void main(String[] args) {

        String[] arr = new String[]{"AA","CC","DD","BB","KK"};
        String dest = "BB";

        //是否找到的标识
        boolean isFlag = true;

        for(int i = 0;i < arr.length;i++){

            if(dest.equals(arr[i])){
                System.out.println("找到了元素，位置为："+i);
                isFlag = false;
                break;
            }
        }

        if(isFlag) {
            System.out.println("没有找到该元素！");
        }
    }
}

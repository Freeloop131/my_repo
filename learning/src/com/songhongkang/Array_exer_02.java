package com.songhongkang;

/**
 * @author : lihuan.zheng
 * @version V1.0
 * @Project: learning
 * @Package com.songhongkang
 * @Description: 使用二维数组打印一个10行杨辉三角形
 * @date Date : 2021年03月06日 18:56
 */
public class Array_exer_02 {

    /**
     * 提示：
     * 1.第一行有1个元素，第n行有n个元素
     * 2.每一行的第一个元素和最后一个元素都是1
     * 3.从第三行开始，对于非第一个元素和最后一个元素，有：
     * yangHui[i][j] = yangHui[i-1][j-1] + yangHui[i-1][j];
     * @param args
     */
    public static void main(String[] args) {

        //1.声明并初始化数组
        int[][] yangHui = new int[10][];

        //2.给数组元素赋值
        for(int i = 0;i < yangHui.length;i++){
            yangHui[i] = new int[i+1];

            //2.1给首末元素赋值
            yangHui[i][0] = 1;
            yangHui[i][i] = 1;

            //2.2给每行的非首末元素赋值
            if(i >= 2){
                for(int j = 1;j < yangHui[i].length-1;j++){
                    yangHui[i][j] = yangHui[i-1][j-1] + yangHui[i-1][j];
                }
            }


        }

        //3.遍历二维数组
        for(int i = 0;i<yangHui.length;i++){
            for(int j = 0;j < yangHui[i].length;j++){
                System.out.printf(yangHui[i][j]+" ");
            }
            System.out.println();
        }

    }
}

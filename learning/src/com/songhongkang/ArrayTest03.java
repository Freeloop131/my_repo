package com.songhongkang;

/**
 * @author : lihuan.zheng
 * @version V1.0
 * @Project: learning
 * @Package com.songhongkang
 * @Description: 二维数组的使用
 * @date Date : 2021年02月28日 18:23
 */
public class ArrayTest03 {

    public static void main(String[] args) {

        //TODO:1.二维数组的声明和初始化
        //静态初始化
        int[][] arr01 = new int[][]{{1,2,3},{4,5},{6,7}};

        //动态初始化-1
        String[][] arr02 = new String[3][2];
        //动态初始化-2
        String[][] arr03 = new String[3][];

        //错误的情况
        //String arr04[][] = new String[][2];
        //String arr04[3][2] = new String[][];

        //正确-也可以这么写
        String arr04[][] = new String[3][2];
        String[] arr05[] = new String[3][2];
        int[][] arr06 = {{1,2,3},{4,5}};    //类型推断


        //TODO:2.如何调用指定位置的数组元素
        System.out.println(arr01[0][1]);    //2
        //System.out.println(arr03[0][0]);  //NullPointerException
        System.out.println(arr04[0][0]);    //null

        arr03[0] = new String[4];
        System.out.println(arr03[0][1]);    //null

        System.out.println("********************");
        //TODO:3.获取数组的长度
        System.out.println(arr04.length);
        System.out.println(arr03[0].length);

        //TODO:4.遍历二维数组
        for(int i=0;i<arr01.length;i++){
            for(int j = 0;j < arr01[i].length;j++){
                System.out.print("arr01["+i+"]["+j+"]="+arr01[i][j]+"\t");
            }
        }

        System.out.println("*******数组元素的初始值********");
        //TODO:4.数组元素的初始值
        int[][] arr000 = new int[4][3];
        System.out.println(arr000); // [[I@1b6d3586 ([[表示这是一个二维数组)
        System.out.println(arr000[0]);   //[I@1b6d3586 ([表示这是一维数组,I表示里面元素是Int型。@后面的就是地址-16进制表示)
        System.out.println(arr000[0][1]); //0
        System.out.println("===========");
        float[][] arr001 = new float[2][3];
        System.out.println(arr001); // [[F@74a14482
        System.out.println(arr001[0]);  // [F@1540e19d
        System.out.println(arr001[0][0]); //0.0
        System.out.println("===========");
        String[][] arr002 = new String[2][3];
        System.out.println(arr002); // [[Ljava.lang.String;@677327b6
        System.out.println(arr002[0]);  // [Ljava.lang.String;@14ae5a5
        System.out.println(arr002[0][0]); //null
        System.out.println("===========");
        String[][] arr003 = new String[2][];
        System.out.println(arr003); // [[Ljava.lang.String;@7f31245a
        System.out.println(arr003[0]);  // null
        //System.out.println(arr003[0][0]);   //报错

    }
}

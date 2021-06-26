package com.songhongkang;

/**
 * @author : lihuan.zheng
 * @version V1.0
 * @Project: learning
 * @Package com.songhongkang
 * @Description: TODO
 * @date Date : 2021年02月27日 22:27
 */
public class ArrayTest01 {

    public static void main(String[] args) {

        //TODO:1.数组的声明和赋值
        //方法1：数组的静态初始化：数组的声明和数组元素的赋值操作同时进行
        int[] ids; //声明
        ids = new int[]{1001,1002,1003,1004}; //数组元素赋值

        //方法2：数组的动态初始化：数组的声明和数组的元素的赋值操作分开
        String[] names = new String[5];

        //也是正确的写法
        int[] arr000 = {1,2,3,4}; //类型推断 - 注意，要写在一行才可以，如果像下面分开写，是会报错的
        int[] arr001;
        //arr001 = {1,2,3,4,5};


        //TODO:总结：数组一旦初始化完成，那么长度就确定了。

        //TODO:2.如何调用数组指定位置的元素：通过索引的方式
        names[0] = "stu_1001";
        names[1] = "stu_1002";
        names[2] = "stu_1003";
        names[3] = "stu_1004";
        names[4] = "stu_1005";

        //TODO:3.如何获取数组的长度。属性:length
        System.out.println(ids.length);
        System.out.println(names.length);

        //TODO:4.如何遍历数组元素
        for(int i = 0;i < names.length;i++){
            System.out.println(names[i]);
        }

        System.out.println("***********数组元素的默认初始化值*************");

        //TODO:5.数组元素的默认初始化值
        // >数组元素是整型(byte,short,int,long):0
        // >数组元素是浮点型(double,float):0.0
        // >数组元素是char型：0或'\u0000',而非‘0’。输出没有内容，但是可以通过判断的值是0。比如说'a'对应的97，这里的0就相当于97。
        // >数组元素是boolean型：false

        // >数组元素是引用数据类型：null ,注意不是"null"

        int[] arr01 = new int[5];
        for(int i = 0;i < arr01.length;i++){
            System.out.println(arr01[i]);
        }
        System.out.println("**************");
        double[] arr02 = new double[5];
        for(int i = 0;i < arr02.length;i++){
            System.out.println(arr02[i]);
        }
        System.out.println("**************");
        char[] arr03 = new char[5];
        for(int i = 0;i < arr03.length;i++){
            System.out.println("------" + arr03[i] + "--------");
        }
        if(arr03[0] == 0){
            System.out.println("hello");
        }
        System.out.println("**************");
        boolean[] arr04 = new boolean[5];
        for(int i = 0;i < arr04.length;i++){
            System.out.println(arr04[i]);
        }

        System.out.println("**************");
        String[] arr05 = new String[5];
        System.out.println(arr05[0]);


        //TODO:6.数组的内存解析

    }
}

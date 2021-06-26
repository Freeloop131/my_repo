package com.songhongkang;
/*
break和continue关键字的使用
                使用范围            循环中的作用(不同点)         相同点
break           switch-case
                循环结构             退出当前循环               关键字后面不能声明执行语句，否则编译报错
continue        循环结构             退出当次循环               关键字后面不能声明执行语句，否则编译报错
 */
public class BreakContinue {

    public static void main(String[] args) {

        for(int i = 1;i <= 10;i++){

            if(i % 4 == 0){
                //break;  //1 2 3
                continue;//1 2 3 5 6 7 9 10

            }
            System.out.print(i);

        }
        System.out.println("\n");
        //******************************

        label:for(int i = 1;i <= 4;i++){

            for(int j = 1;j <= 10;j++){
                if(j % 4 == 0){
                    //break;//默认跳出包裹此关键字最近一层循环
                    //continue; //默认跳出包裹此关键字的当次循环

                    //break label; //结束指定循环标识的一层循环结构
                    continue label; //结束执行循环标识的一层循环结构的当次循环

                }
                System.out.print(j);
            }
            System.out.println();
        }
    }
}

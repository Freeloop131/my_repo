package com.songhongkang;
/*
输出如下星号
******
*****
****
***
**
*

Process finished with exit code 0

嵌套循环：外层循环控制行数，内层循环控制列数。
 */
public class Asterisks {
    public static void main(String[] args) {

        for(int i = 1; i <= 6;i++){
            for(int j = 1; j <= 7-i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

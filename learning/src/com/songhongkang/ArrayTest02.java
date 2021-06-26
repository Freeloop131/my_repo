package com.songhongkang;

import java.util.Scanner;

/**
 * @author : lihuan.zheng
 * @version V1.0
 * @Project: learning
 * @Package com.songhongkang
 * @Description: 从键盘读入成绩，找到最高分，并给学生成绩评级。
 * @date Date : 2021年02月28日 17:14
 */
public class ArrayTest02 {
    public static void main(String[] args) {

        //1.成绩Scanner对象，读取学生成绩
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入学生人数：");
        int number = scanner.nextInt();

        //2.创建数组，存储学生成绩:动态初始化
        int[] scores = new int[number];
        int maxScore = 0;
        System.out.println("请输入"+number+"个学生的成绩：");
        for(int i = 0;i < scores.length;i++){
            scores[i] = scanner.nextInt();
            //3.找到成绩数组中的最大值
            if(maxScore < scores[i]){
                maxScore = scores[i];
            }
        }
        System.out.println("最高的成绩是："+maxScore);


        //4.根据每个成绩与最高分的差值，得到每个学生的等级，并输出等级和成绩
        char level;
        for(int i=0;i<scores.length;i++){
            if(maxScore - scores[i] <= 10){
                level = 'A';
            }else if(maxScore - scores[i] <= 20){
                level = 'B';
            }else if(maxScore - scores[i] <= 30){
                level = 'C';
            }else {
                level = 'D';
            }
            System.out.println("student "+i+" score is "+scores[i] +",grade is "+level);
        }

    }
}

package com.songhongkang;

/**
 * @author : lihuan.zheng
 * @version V1.0
 * @Project: learning
 * @Package com.songhongkang
 * @Description: 面向对象练习
 * 题目：定义Student类，包含三个属性：学号number，年级state，成绩score。
 * 创建20个学生对象，学号从1到20，年级范围1-6，成绩1-100，随机生成数字。
 * 功能一：输出打印所有学生信息
 * 功能二：输出3年级学生信息
 * 功能三：使用冒泡排序法对学生成绩进行排序，并输出
 * @date Date : 2021年03月20日 18:05
 */
public class StudentTest {

    public static void main(String[] args) {
        //声明一个长度为20，数据类型为Student的数组
        Student[] stus = new Student[20];

        //遍历数组，给每个数组元素赋值--初始化
        for(int i = 0;i < stus.length;i++){
            stus[i] = new Student();
            stus[i].number = i+1;
            stus[i].state = (int)(Math.random()*6) + 1;
            stus[i].score = (int)(Math.random()*100) + 1;
        }

        StudentTest st1 = new StudentTest();
        st1.printStuInfo(stus);

        System.out.println("**************************");
        st1.printStat3Info(stus);

        System.out.println("**************************");
        st1.bubbleSort(stus);
        st1.printStuInfo(stus);

    }

    /**
     * 功能一：遍历学生数组，输出学生信息
     * @param stus
     */
    public void printStuInfo(Student[] stus){
        for(int i = 0;i < stus.length;i++){
            stus[i].info();
        }
    }

    /**
     * 输出3年级学生信息
     * @param stus
     */
    public void printStat3Info(Student[] stus){
        for(int i = 0;i < stus.length;i++){
            if(stus[i].state == 3){
                stus[i].info();
            }
        }
    }

    /**
     * 利用冒泡排序法对stus数组进行排序
     * @param stus
     */
    public void bubbleSort(Student[] stus){
        for(int i = 0;i < stus.length-1;i++){
            for(int j = 0;j < stus.length - i - 1;j++){

                if(stus[j].score > stus[j+1].score){
                    Student temp = stus[j];
                    stus[j] = stus[j+1];
                    stus[j+1] = temp;
                }
            }
        }
    }



}


class Student{
    //属性
    int number; //学号
    int state;  //年级
    int score;   //成绩

    public void info(){
        System.out.println("学号：" + number + ",年级：" + state + ",成绩：" + score);
    }
}

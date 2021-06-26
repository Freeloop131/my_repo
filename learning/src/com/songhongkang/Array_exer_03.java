package com.songhongkang;

/**
 * @author : lihuan.zheng
 * @version V1.0
 * @Project: learning
 * @Package com.songhongkang
 * @Description: 定义一个int型的数组，赋随机数，然后求出所有元素的最大最小值，求和，平均值，并输出。要求所有随机数都是两位数。
 * @date Date : 2021年03月06日 20:15
 */
public class Array_exer_03 {

    /**
     *如何生成指定范围内的随机数：
     * Math.random(): [0.0,1)
     * Math.random()*90 : [0.0,90.0)
     * (int)(Math.random()*90): [0,89)
     * (int)(Math.random()*90+10): [10,99)
     * (int)(Math.random()*90+10+1):  [10,100)
     */
    public static void main(String[] args) {

        int[] randomArray = new int[10];

        for(int i = 0;i < randomArray.length;i++){
            randomArray[i] = (int)(Math.random()*(99-10+1)+10);
            System.out.println(randomArray[i]);
        }

        //1.求最大值
        int maxValue = randomArray[0];
        for(int i = 0;i < randomArray.length;i++){
            if(maxValue < randomArray[i]){
                maxValue = randomArray[i];
            }
        }
        System.out.println("最大值为："+maxValue);

        //2.求最小值
        int minValue = randomArray[0];
        for(int i = 0;i < randomArray.length;i++){
            if(minValue > randomArray[i]){
                minValue = randomArray[i];
            }
        }
        System.out.println("最小值为："+minValue);

        //3.求和
        int sumValue = 0;
        for(int i = 0;i < randomArray.length;i++){
            sumValue += randomArray[i];
        }
        System.out.println("求和为："+sumValue);

        //4.求平均
        double avgValue = 0.0;
        avgValue = sumValue/randomArray.length;
        System.out.println("平均数为："+avgValue);
    }

}

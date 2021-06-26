package com.songhongkang;

/**
 * @author : lihuan.zheng
 * @version V1.0
 * @Project: learning
 * @Package com.songhongkang
 * @Description: 求圆面积
 * @date Date : 2021年04月11日 15:49
 */
public class MyCircle {
    int radius;
    public double findArea(){
        double area = Math.PI * radius * radius;
        return area;
    }
}

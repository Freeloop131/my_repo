package com.songhongkang;

/**
 * @author : lihuan.zheng
 * @version V1.0
 * @Project: learning
 * @Package com.songhongkang
 * @Description: 测试ArrayUtil数组工具类
 * @date Date : 2021年03月21日 15:31
 */
public class ArrayUtilTest {

    public static void main(String[] args) {

        ArrayUtil util = new ArrayUtil();
        int[] arr = new int[]{32,34,5,8,-53,99,12,3};
        System.out.println(util.print(arr));
        System.out.println("最大值是：" + util.getMax(arr));
        System.out.println("最小值是：" + util.getMin(arr));
        System.out.println("总和为：" + util.getSum(arr));
        System.out.println("平均值为：" + util.getAvg(arr));
        util.reverse(arr);
        System.out.println("数组的反转结果：" + util.print(arr));
        util.sort(arr);
        System.out.println("数组的排序结果是：" + util.print(arr));
        System.out.println("元素值为8的索引为：" + util.search(arr,8));
        int[] arrCopy = util.copy(arr);
        System.out.println("数组的拷贝：" + util.print(arrCopy));

    }
}

package com.hive.udf;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * @author : lihuan.zheng
 * @version V1.0
 * @Project: naixuedp6
 * @Package com.hive.udf
 * @Description: 大写转小写
 * @date Date : 2021年05月03日 17:02
 */
public class ToLowerCase extends UDF {
    //必须是public，并且evaluate方法可以重载
    public String evaluate(String field){
        String result = field.toLowerCase();
        return result;
    }

    public static void main(String[] args) {
        ToLowerCase toLowerCase = new ToLowerCase();
        String fields = toLowerCase.evaluate("ABCdEFg");
        System.out.println(fields);
    }
}

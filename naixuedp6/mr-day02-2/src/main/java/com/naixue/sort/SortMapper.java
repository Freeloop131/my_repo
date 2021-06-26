package com.naixue.sort;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @author : lihuan.zheng
 * @version V1.0
 * @Project: naixuedp6
 * @Package com.naixue.sort
 * @Description: TODO
 * @date Date : 2021年04月14日 23:31
 */
public class SortMapper extends Mapper<LongWritable, Text, MySortBean, NullWritable> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        //1.拆分文本
        String[] words = value.toString().split(" ");

        //2.将对应的值设置到MySortBean对象中
        MySortBean mySortBean = new MySortBean();
        mySortBean.setWord(words[0]);
        mySortBean.setNum(Integer.parseInt(words[1]));

        //3.写入上下文
        context.write(mySortBean,NullWritable.get());
    }
}

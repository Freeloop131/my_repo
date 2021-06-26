package com.naixue.combiner;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @author : lihuan.zheng
 * @version V1.0
 * @Project: naixuedp6
 * @Package com.naixue.combiner
 * @Description: TODO
 * @date Date : 2021年04月17日 10:17
 */
public class WordMapper extends Mapper<LongWritable, Text, Text, LongWritable> {

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        //1.拆分一行文本
        String[] words = value.toString().split(" ");

        //2.遍历单词数组
        for (String word : words) {
            //3.写入上下文
            context.write(new Text(word), new LongWritable(1));
        }

    }
}

package com.naixue.partitioner;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @author : lihuan.zheng
 * @version V1.0
 * @Project: naixuedp6
 * @Package com.naixue.partitioner
 * @Description: 需求：根据单词的长度给单词出现的次数的结果存储到不同文件中，以便于快速查询。-- Mapper
 * @date Date : 2021年04月13日 21:11
 */
public class WordMapper extends Mapper<LongWritable, Text, Text, LongWritable> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        //1.单词切分
        String[] words = value.toString().split(" ");

        //2.单词转换
        for (String word : words) {
            //3.写入上下文
            context.write(new Text(word),new LongWritable(1));
        }

    }
}

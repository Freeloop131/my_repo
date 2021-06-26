package com.naixue.partitioner;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @author : lihuan.zheng
 * @version V1.0
 * @Project: naixuedp6
 * @Package com.naixue.partitioner
 * @Description: 需求：根据单词的长度给单词出现的次数的结果存储到不同文件中，以便于快速查询。-- Reducer
 * @date Date : 2021年04月13日 21:18
 */
public class WordReducer extends Reducer<Text,LongWritable,Text,LongWritable> {

    @Override
    protected void reduce(Text key, Iterable<LongWritable> values, Context context) throws IOException, InterruptedException {
        //1.定义一个统计变量
        long sum = 0;

        //2.迭代累加
        for (LongWritable value : values) {
            sum += value.get();
        }

        //3.写入上下文
        context.write(key, new LongWritable(sum));
    }
}

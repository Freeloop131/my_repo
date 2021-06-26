package com.naixue.combiner;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @author : lihuan.zheng
 * @version V1.0
 * @Project: naixuedp6
 * @Package com.naixue.combiner
 * @Description: TODO
 * @date Date : 2021年04月17日 10:17
 */
public class WordReducer extends Reducer<Text, LongWritable, Text,LongWritable> {

    @Override
    protected void reduce(Text key, Iterable<LongWritable> values, Context context) throws IOException, InterruptedException {

        //1.定义变量存储key的总和
        long sum = 0;

        //2.迭代values，对每个相同的key的value值进行累加
        for (LongWritable value : values) {
            sum += value.get();
        }

        //3.将结果写入上下文
        context.write(key, new LongWritable(sum));
    }
}

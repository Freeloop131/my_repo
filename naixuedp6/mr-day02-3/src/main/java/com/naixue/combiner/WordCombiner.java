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
 * @date Date : 2021年04月17日 10:18
 *
 * KEYIN: map传递过来的key类型
 * VALUEIN: map传递过来的value类型
 * KEYOUT: 局部汇总的key，也就是单词的类型
 * VALUEOUT: 局部汇总的value，也就是次数的类型
 *
 */
public class WordCombiner extends Reducer<Text, LongWritable,Text, LongWritable> {
    @Override
    protected void reduce(Text key, Iterable<LongWritable> values, Context context) throws IOException, InterruptedException {
        //1.定义一个变量
        long sum = 0;

        //2.对values进行迭代
        for (LongWritable value : values) {
            sum += value.get();
        }

        //3.写入上下文
        context.write(key, new LongWritable(sum));
    }
}

package com.naixue.mr;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @author : lihuan.zheng
 * @version V1.0
 * @Project: naixuedp6
 * @Package com.naixue.mr
 * @Description: 单词统计Reducer
 * @date Date : 2021年04月10日 19:41
 *
 * <KEYIN,VALUEIN,KEYOUT,VALUEOUT>
 *     KEYIN：map阶段输出的key的类型
 *     VALUEIN：数字
 *     KEYOUT：最终的结果的单词类型
 *     VALUEOUT：最终结果的单词的次数
 *
 */
public class WordReducer extends Reducer<Text, LongWritable,Text,LongWritable> {

    /**
     *
     * @param key 单词
     * @param values 相同单词的次数
     * @param context 上下文
     * @throws IOException
     * @throws InterruptedException
     */
    @Override
    protected void reduce(Text key, Iterable<LongWritable> values, Context context) throws IOException, InterruptedException {
        //1.定义一个统计变量
        long count = 0;

        //2.迭代累加
        for (LongWritable value : values) {
            count += value.get();
        }

        //3.写入上下文
        context.write(key,new LongWritable(count));
    }
}

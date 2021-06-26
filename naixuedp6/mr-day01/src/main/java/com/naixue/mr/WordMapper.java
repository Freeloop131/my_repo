package com.naixue.mr;


import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @author : lihuan.zheng
 * @version V1.0
 * @Project: naixuedp6
 * @Package com.naixue.mr
 * @Description: 单词统计Mapper
 * @date Date : 2021年04月10日 17:53
 *
 * Mapper<KEYIN, VALUEIN, KEYOUT, VALUEOUT>
 *
 *     KEYIN：指框架读取到的数据key的类型，在默认情况下，读取到的key就是一行数据相对于整个文本起始位置的偏移量。key的类型是不是可以为Long？
 *     VALUEIN：指框架读取到的数据的value的类型，在默认情况下，读取到的value就是一行数据。value类型是不是可以是String？
 *     KEYOUT：是指用户自定义的逻辑方法中返回数据的key的类型，由用户根据业务逻辑自己决定的。在wordcount程序中，这个key就是单词。key的类型是不是可以为String？
 *     VALUEOUT：是指用户自定义的逻辑方法中返回数据的value类型，由用户根据业务逻辑自己决定的。在wordcount程序中，这个value就是次数。value的类型是不是可以为Long？
 *
 *  但是，String，Long都是jdk里面的数据类型，在序列化（写磁盘，网络传输）的时候，效率低（继承关系都会在里面）
 *  hadoop为了提高效率，自定义了一套序列化框架
 *  在hadoop程序中，如果要序列化，一定要使用hadoop实现的序列化的数据类型
 *
 *  Long ——》LongWritable
 *  String ——》 Text
 *  Integer ——》 IntWritable
 *  Null ——》 NullWritable
 *
 */
public class WordMapper extends Mapper<LongWritable, Text, Text, LongWritable> {

    /**
     *
     * @param key 就是偏移量
     * @param value 就是一行文本数据
     * @param context 上下文 数据传输的载体
     * @throws IOException
     * @throws InterruptedException
     */
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        //1.单词的切分
        String[] words = value.toString().split(" ");

        //2.计数1次,将单词转换成类似于 <hello,1>这样的key，value类型向外输出
        for (String word : words) {
            //3.写入到上下文当中（后续数据将会传送到reducer中进行汇总）
            context.write(new Text(word), new LongWritable(1));
        }

    }
}
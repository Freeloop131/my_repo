package com.naixue.partitioner;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

/**
 * @author : lihuan.zheng
 * @version V1.0
 * @Project: naixuedp6
 * @Package com.naixue.partitioner
 * @Description: 需求：根据单词的长度给单词出现的次数的结果存储到不同文件中，以便于快速查询。-- Partitioned
 * @date Date : 2021年04月13日 21:28
 */
public class MyPartitioner extends Partitioner<Text, LongWritable>{
    @Override
    public int getPartition(Text text, LongWritable longWritable, int numPartitions) {
        //根据单词长度判断进入哪个分区
        if(text.toString().length() >= 5){
            return 0;
        }else{
            return 1;
        }
    }
}

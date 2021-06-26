package com.naixue.partitioner;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

import java.io.IOException;

/**
 * @author : lihuan.zheng
 * @version V1.0
 * @Project: naixuedp6
 * @Package com.naixue.partitioner
 * @Description: 需求：根据单词的长度给单词出现的次数的结果存储到不同文件中，以便于快速查询。-- 主调程序
 * @date Date : 2021年04月13日 21:39
 */
public class JobMain {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

        //一、初始化job对象
        Configuration configuration = new Configuration();
        Job job = Job.getInstance(configuration, "partitioner_wc");
        job.setJarByClass(JobMain.class);

        //二、对job进行各种配置
        //1.设置输入路径
        job.setInputFormatClass(TextInputFormat.class);
        TextInputFormat.addInputPath(job,new Path("hdfs://bigdata001:9000/wcinput"));

        //2.设置Mapper类，输出的key，value类型
        job.setMapperClass(WordMapper.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(LongWritable.class);

        //3.4,5,6 shuffle阶段
        //3.设置分区
        job.setPartitionerClass(MyPartitioner.class);

        //设置 NumReduceTask个数（默认是1，如果不设置，就只会生成一个文件part-r-00000）
        job.setNumReduceTasks(2);

        //7.设置Reducer，输出的key，value类型
        job.setReducerClass(WordReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LongWritable.class);

        //8.设置输出路径
        job.setOutputFormatClass(TextOutputFormat.class);
        TextOutputFormat.setOutputPath(job,new Path("hdfs://bigdata001:9000/output_partitioner"));

        //三、等待完成
        boolean result = job.waitForCompletion(true);
        System.out.println(result);
        System.exit(result?0:1);

    }
}

package com.naixue.mr;

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
 * @Package com.naixue.mr
 * @Description: MapReduce的主调度入口，主类：将Mapper和Reducer串联起来，并且提供了运行的入口。
 * @date Date : 2021年04月10日 19:59
 */
public class JobMain {

    /**
     * 这个main提供了WordCount程序运行的入口
     * 其中用一个Job类对象管理程序运行的很多参数
     * 如指定哪个类作为Mapper的业务逻辑类，哪个类作为Reducer的业务逻辑类
     * ......其他各种需要的参数
     * @param args
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        //一、初始化一个Job对象
        Configuration configuration = new Configuration();
        Job job = Job.getInstance(configuration, "wordcount");
        job.setJarByClass(JobMain.class);  

        //二、设置Job对象相关的信息，包含8个小步骤
        //1.设置输入路径，让程序找到源文件位置
        job.setInputFormatClass(TextInputFormat.class);
        TextInputFormat.addInputPath(job,new Path("hdfs://bigdata001:9000/wcinput/wordcount.txt"));

        //2.设置Mapper类型，并设置输出的key，value类型
        job.setMapperClass(WordMapper.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(LongWritable.class);

        //3.4.5.6 四个步骤，都是Shuffle阶段，现在先使用默认的即可

        //7.设置Reducer类型，设置输出的key，value类型
        job.setReducerClass(WordReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LongWritable.class);

        //8.设置输出路径，让程序存放到某个地方去
        job.setOutputFormatClass(TextOutputFormat.class);
        TextOutputFormat.setOutputPath(job,new Path("hdfs://bigdata001:9000/wcoutput"));

        //三、等待程序完成(底层就是submit)
        boolean b = job.waitForCompletion(true);
        System.out.println(b);
        System.exit(b ? 0:1);
    }

}

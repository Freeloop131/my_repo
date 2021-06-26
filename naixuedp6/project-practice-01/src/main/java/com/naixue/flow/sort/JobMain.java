package com.naixue.flow.sort;

import com.naixue.flow.sum.FlowSumReducer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

import java.io.IOException;

/**
 * @author : lihuan.zheng
 * @version V1.0
 * @Project: naixuedp6
 * @Package com.naixue.flow.sort
 * @Description: 倒排主调程序
 * @date Date : 2021年04月17日 12:32
 */
public class JobMain {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

        //一、初始化job对象
        Configuration configuration = new Configuration();
        Job job = Job.getInstance(configuration, "flowsort");
        job.setJarByClass(JobMain.class);

        //二、对job对象进行各种设置
        //1.设置输入路径
        job.setInputFormatClass(TextInputFormat.class);
        TextInputFormat.addInputPath(job,new Path("hdfs://bigdata001:9000/test/output_flow01/part-r-00000"));

        //2.设置Mapper类，输出的key，value类型
        job.setMapperClass(FlowSortMapper.class);
        job.setMapOutputKeyClass(FlowSortBean.class);
        job.setMapOutputValueClass(NullWritable.class);

        //3.4,5,6 shuffle阶段

        //7.设置Reducer类，输出的key，value类型
        job.setReducerClass(FlowSortReducer.class);
        job.setOutputKeyClass(FlowSortBean.class);
        job.setOutputValueClass(NullWritable.class);

        //8.设置输出路径
        job.setOutputFormatClass(TextOutputFormat.class);
        TextOutputFormat.setOutputPath(job,new Path("hdfs://bigdata001:9000/test/output_flow02"));

        //9.等待完成
        boolean result = job.waitForCompletion(true);
        System.out.println(result);
        System.exit(result?0:1);
    }
}
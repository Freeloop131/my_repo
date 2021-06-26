package com.naixue.flow.sum;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

import java.io.IOException;

/**
 * @author : lihuan.zheng
 * @version V1.0
 * @Project: naixuedp6
 * @Package com.naixue.flow.sum
 * @Description: 流量求和主调程序
 * @date Date : 2021年04月17日 11:38
 */
public class JobMain {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        //一、初始化job对象
        Configuration configuration = new Configuration();
        Job job = Job.getInstance(configuration, "flowsum");
        job.setJarByClass(JobMain.class);

        //二、设置job对象的相关信息
        //1.设置输入路径
        job.setInputFormatClass(TextInputFormat.class);
        //TextInputFormat.addInputPath(job,new Path("hdfs://bigdata001:9000/test/flow.log"));
        TextInputFormat.addInputPath(job,new Path("E://test_files/flow.log"));

        //2.设置Mapper类，及输出的key，value的类型
        job.setMapperClass(FlowSumMapper.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(FlowBean.class);

        //3.设置Reducer类，及输出key，value的类型
        job.setReducerClass(FlowSumReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(FlowBean.class);

        //4.设置输出路径
        job.setOutputFormatClass(TextOutputFormat.class);
        //TextOutputFormat.setOutputPath(job, new Path("hdfs://bigdata001:9000/test/output_flow01"));
        TextOutputFormat.setOutputPath(job, new Path("E://test_files/output_flowsum_01"));

        //三、等待程序完成
        boolean result = job.waitForCompletion(true);
        System.out.println(result);
        System.exit(result?0:1);
    }
}

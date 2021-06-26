package com.naixue.flow.partitioner;

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
 * @Package com.naixue.flow.partitioner
 * @Description: 主调程序
 * @date Date : 2021年04月17日 13:28

该程序在map阶段无法执行成功，实在不知道怎么解决了，报错如下：
Error: java.io.IOException: Initialization of all the collectors failed. Error in last collector was :class com.naixue.flow.partitioner.FlowBean
at org.apache.hadoop.mapred.MapTask.createSortingCollector(MapTask.java:414)
at org.apache.hadoop.mapred.MapTask.access$100(MapTask.java:81)
at org.apache.hadoop.mapred.MapTask$NewOutputCollector.<init>(MapTask.java:698)
at org.apache.hadoop.mapred.MapTask.runNewMapper(MapTask.java:770)
at org.apache.hadoop.mapred.MapTask.run(MapTask.java:341)

 */
public class JobMain {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        //一、初始化job对象
        Configuration configuration = new Configuration();
        Job job = Job.getInstance(configuration, "flowpartitioner");
        job.setJarByClass(JobMain.class);

        //二、对job进行各种配置
        //1.设置输入路径
        job.setInputFormatClass(TextInputFormat.class);
        TextInputFormat.addInputPath(job,new Path("E://test_files/flow.log"));

        //2.设置Mapper类，输出的key，value类型
        job.setMapperClass(FlowPartitionerMapper.class);
        job.setMapOutputKeyClass(FlowBean.class);
        job.setMapOutputValueClass(NullWritable.class);

        //3.4,5,6 shuffle阶段
        //3.设置分区
        job.setPartitionerClass(FlowPartitioner.class);

        //设置 NumReduceTask个数
        job.setNumReduceTasks(4);

        //7.设置Reducer，输出的key，value类型
        job.setReducerClass(FlowPartitionerReducer.class);
        job.setOutputKeyClass(FlowBean.class);
        job.setOutputValueClass(NullWritable.class);

        //8.设置输出路径
        job.setOutputFormatClass(TextOutputFormat.class);
        TextOutputFormat.setOutputPath(job,new Path("E://test_files/output_flow03"));

        //三、等待完成
        boolean result = job.waitForCompletion(true);
        System.out.println(result);
        System.exit(result?0:1);
    }
}

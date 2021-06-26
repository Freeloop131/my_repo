package com.naixue.flow.partitioner;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @author : lihuan.zheng
 * @version V1.0
 * @Project: naixuedp6
 * @Package com.naixue.flow.partitioner
 * @Description: 按手机号分区Mapper
 * @date Date : 2021年04月17日 13:11
 */
public class FlowPartitionerMapper extends Mapper<LongWritable,Text,FlowBean, NullWritable> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        //1.拆分文本
        System.out.println("map start...");
        String[] split = value.toString().split("\t");

        //2.将数组元素封装到bean对象
        FlowBean flowBean = new FlowBean();
        flowBean.setTs(Long.parseLong(split[0]));
        flowBean.setPhoneNumber(split[1]);
        flowBean.setId(split[2]);
        flowBean.setIp(split[3]);
        flowBean.setUrl(split[4]);
        flowBean.setType(split[5]);
        flowBean.setUpFlow(Integer.parseInt(split[6]));
        flowBean.setDownFlow(Integer.parseInt(split[7]));
        flowBean.setUpCountFlow(Integer.parseInt(split[8]));
        flowBean.setDownCountFlow(Integer.parseInt(split[9]));
        flowBean.setStatus(split[10]);

        //3.写入上下文
        context.write(flowBean,NullWritable.get());
    }
}

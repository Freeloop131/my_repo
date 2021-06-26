package com.naixue.flow.sort;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @author : lihuan.zheng
 * @version V1.0
 * @Project: naixuedp6
 * @Package com.naixue.flow.sort
 * @Description: 倒排Mapper
 * @date Date : 2021年04月17日 12:27
 */
public class FlowSortMapper extends Mapper<LongWritable, Text,FlowSortBean, NullWritable> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        //1.拆分文本
        String[] split = value.toString().split("\t");

        //2.将值封装到FlowSortBean中
        FlowSortBean flowSortBean = new FlowSortBean();
        flowSortBean.setPhoneNumber(split[0]);
        flowSortBean.setUpFlow(Integer.parseInt(split[1]));
        flowSortBean.setDownFlow(Integer.parseInt(split[2]));
        flowSortBean.setUpCountFlow(Integer.parseInt(split[3]));
        flowSortBean.setDownCountFlow(Integer.parseInt(split[4]));

        //3.写入上下文
        context.write(flowSortBean,NullWritable.get());
    }
}

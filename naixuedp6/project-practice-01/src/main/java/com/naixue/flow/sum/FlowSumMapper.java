package com.naixue.flow.sum;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @author : lihuan.zheng
 * @version V1.0
 * @Project: naixuedp6
 * @Package com.naixue.flow.sum
 * @Description: 流量求和Mapper
 * @date Date : 2021年04月17日 11:28
 */
public class FlowSumMapper extends Mapper<LongWritable, Text, Text, FlowBean> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        //1.拆分文本，得到手机号，流量，数据包等字段
        String[] split = value.toString().split("\t");
        String phoneNumber = split[1];

        //2.创建FlowBean对象，将需要的数据封装进去
        FlowBean flowBean = new FlowBean();
        flowBean.setUpFlow(Integer.parseInt(split[6]));
        flowBean.setDownFlow(Integer.parseInt(split[7]));
        flowBean.setUpCountFlow(Integer.parseInt(split[8]));
        flowBean.setDownCountFlow(Integer.parseInt(split[9]));

        //3.写入上下文
        context.write(new Text(phoneNumber), flowBean);
    }
}

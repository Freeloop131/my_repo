package com.naixue.flow.partitioner;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Partitioner;

/**
 * @author : lihuan.zheng
 * @version V1.0
 * @Project: naixuedp6
 * @Package com.naixue.flow.partitioner
 * @Description: 分区：135开头一个分区；136开头一个分区；137开头一个分区，其余的一个分区；
 * @date Date : 2021年04月17日 13:19
 */
public class FlowPartitioner extends Partitioner<FlowBean, NullWritable> {

    @Override
    public int getPartition(FlowBean flowBean, NullWritable nullWritable, int numPartitions) {
        //1.获取手机号前三位
        int phoneNumber = Integer.parseInt(flowBean.getPhoneNumber().substring(1,3));
        System.out.println(phoneNumber);
        //2.根据手机号前三位判断要进入的分区
        if(phoneNumber == 135){
            return 1;
        }else if(phoneNumber == 136){
            return 2;
        }else if(phoneNumber == 137){
            return 3;
        }else {
            return 4;
        }
    }
}

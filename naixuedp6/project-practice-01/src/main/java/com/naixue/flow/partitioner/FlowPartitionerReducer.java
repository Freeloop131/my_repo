package com.naixue.flow.partitioner;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @author : lihuan.zheng
 * @version V1.0
 * @Project: naixuedp6
 * @Package com.naixue.flow.partitioner
 * @Description: 按手机号分区Reducer
 * @date Date : 2021年04月17日 13:17
 */
public class FlowPartitionerReducer extends Reducer<FlowBean, NullWritable,FlowBean,NullWritable> {
    @Override
    protected void reduce(FlowBean key, Iterable<NullWritable> values, Context context) throws IOException, InterruptedException {
        //1.写入上下文
        context.write(key, NullWritable.get());
    }
}

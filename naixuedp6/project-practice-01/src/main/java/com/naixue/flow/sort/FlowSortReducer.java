package com.naixue.flow.sort;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @author : lihuan.zheng
 * @version V1.0
 * @Project: naixuedp6
 * @Package com.naixue.flow.sort
 * @Description: 倒排Reducer
 * @date Date : 2021年04月17日 12:31
 */
public class FlowSortReducer extends Reducer<FlowSortBean, NullWritable,FlowSortBean, NullWritable> {
    @Override
    protected void reduce(FlowSortBean key, Iterable<NullWritable> values, Context context) throws IOException, InterruptedException {

        //1.写入上下文
        context.write(key,NullWritable.get());
    }
}

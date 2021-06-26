package com.naixue.sort;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @author : lihuan.zheng
 * @version V1.0
 * @Project: naixuedp6
 * @Package com.naixue.sort
 * @Description: 这里的reducer不需要处理什么，只是把从mapper传输过来的数据再输出就行了
 * @date Date : 2021年04月16日 12:49
 *
 * KEYIN:map阶段输出的key类型
 * VALUEIN: map阶段输出的value类型
 * KEYOUT: MySortBean
 * VALUEOUT: NullWritable
 */
public class SortReducer extends Reducer<MySortBean, NullWritable,MySortBean,NullWritable> {
    @Override
    protected void reduce(MySortBean key, Iterable<NullWritable> values, Context context) throws IOException, InterruptedException {
        //1.写入上下文
        context.write(key, NullWritable.get());
    }
}

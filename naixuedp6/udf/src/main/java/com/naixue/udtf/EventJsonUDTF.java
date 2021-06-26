package com.naixue.udtf;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.hive.ql.exec.UDFArgumentException;
import org.apache.hadoop.hive.ql.metadata.HiveException;
import org.apache.hadoop.hive.ql.udf.generic.GenericUDTF;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorFactory;
import org.apache.hadoop.hive.serde2.objectinspector.StructObjectInspector;
import org.apache.hadoop.hive.serde2.objectinspector.primitive.PrimitiveObjectInspectorFactory;
import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

/**
 * @author : lihuan.zheng
 * @version V1.0
 * @Project: naixuedp6
 * @Package com.naixue.udtf
 * @Description: TODO
 * 自定义UDTF函数，需要继承GenericUDTF:重写initialize(), process(),close();
 * @date Date : 2021年06月14日 15:14
 *
 * 案例数据：
 * [{"ett":"1598647856166","en":"newsdetail","kv":{"entry":"2","goodsid":"0","news_staytime":"16","loading_time":"9","action":"3","showtype":"1","category":"73","type1":"201"}}
 * ,{"ett":"1598654400505","en":"loading","kv":{"extend2":"","loading_time":"12","action":"1","extend1":"","type":"2","type1":"","loading_way":"1"}}
 * ,{"ett":"1598603902380","en":"active_background","kv":{"active_source":"3"}}
 * ,{"ett":"1598632379633","en":"error","kv":{"errorDetail":"java.lang.NullPointerException\\n    at cn.lift.appIn.web.AbstractBaseController.validInbound(AbstractBaseController.java:72)\\n at cn.lift.dfdf.web.AbstractBaseController.validInbound","errorBrief":"at cn.lift.dfdf.web.AbstractBaseController.validInbound(AbstractBaseController.java:72)"}}
 * ,{"ett":"1598686251553","en":"comment","kv":{"p_comment_id":1,"addtime":"1598693035607","praise_count":283,"other_id":9,"comment_id":4,"reply_count":8,"userid":7,"content":"焉蔫分偏挽拄久蝇寝堤蛇脸钉潘医都"}}
 * ]
 */
public class EventJsonUDTF extends GenericUDTF {
    //该方法中，将指定输出参数名称和参数类型
    @Override
    public StructObjectInspector initialize(ObjectInspector[] argOIs) throws UDFArgumentException {
        ArrayList<String> fieldNames = new ArrayList<>();
        ArrayList<ObjectInspector> fieldOIs = new ArrayList<>();

        fieldNames.add("event_name");
        fieldOIs.add(PrimitiveObjectInspectorFactory.javaStringObjectInspector);
        fieldNames.add("event_json");
        fieldOIs.add(PrimitiveObjectInspectorFactory.javaStringObjectInspector);

        return ObjectInspectorFactory.getStandardStructObjectInspector(fieldNames,fieldOIs);
    }

    //输入一条记录，输出若干条数据
    @Override
    public void process(Object[] objects) throws HiveException {
        //获取传入的et
        String input = objects[0].toString();

        if(StringUtils.isBlank(input)){
            return;
        }else{
            try {
                //获取json数组中
                JSONArray ja = new JSONArray(input);
                if(ja == null) return;

                //循环遍历每个事件
                for(int i = 0;i < ja.length();i++){
                    String[] result = new String[2];

                    try {
                        //取出事件的名称
                        result[0] = ja.getJSONObject(i).getString("en");

                        //取出事件的整体
                        result[1] = ja.getString(i);
                    } catch (JSONException e) {
                        continue;
                    }

                    //结果返回
                    forward(result);
                }

            } catch (JSONException e) {
                //e.printStackTrace();

            }
        }
    }

    //没有记录处理的时候该方法会被调用，清理使用
    @Override
    public void close() throws HiveException {

    }
}

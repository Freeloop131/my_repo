package com.naixue.udf;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.hive.ql.exec.UDF;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author : lihuan.zheng
 * @version V1.0
 * @Project: naixuedp6
 * @Package com.naixue.udf
 * @Description: TODO
 * @date Date : 2021年06月14日 9:57
 */
public class BaseFieldUDF extends UDF {

    public String evaluate(String line, String jsonkeyString) throws JSONException {

        //0.准备StringBuilder
        StringBuilder builder = new StringBuilder();

        //1.切割jsonkeys mid,uid,vc,vn,l,sr,os,ar,md,ba,sv,g,hw,nw,ln,la,t
        String[] jsonkeys = jsonkeyString.split(",");

        //2.处理line  服务器时间 |json
        String[] logContent = line.split("\\|");

        //3.校验
        if(logContent.length != 2 || StringUtils.isBlank(logContent[1])){
            return "";
        }

        //4.开始处理json
        JSONObject jsonObject = new JSONObject(logContent[1]);

        //获取cm里面的对象
        JSONObject cm = jsonObject.getJSONObject("cm");

        //循环遍历取值
        for(int i=0;i<jsonkeys.length;i++){
            String fieldName = jsonkeys[i].trim();

            if(cm.has(fieldName)){
                builder.append(cm.getString(fieldName)).append("\t");
            }else{
                builder.append("\t");
            }
        }

        builder.append(jsonObject.getString("et")).append("\t");
        builder.append(logContent[0]).append("\t");

        return builder.toString();
    }

    public static void main(String[] args) throws JSONException {
        String line = "1598693683508|{\"cm\":{\"ln\":\"-108.1\",\"sv\":\"V2.7.4\",\"os\":\"8.0.4\",\"g\":\"6G07BL4X@gmail.com\",\"mid\":\"3\",\"nw\":\"4G\",\"l\":\"pt\",\"vc\":\"11\",\"hw\":\"750*1134\",\"ar\":\"MX\",\"uid\":\"3\",\"t\":\"1598627949192\",\"la\":\"5.0\",\"md\":\"sumsung-0\",\"vn\":\"1.0.0\",\"ba\":\"Sumsung\",\"sr\":\"X\"},\"ap\":\"app\",\"et\":[{\"ett\":\"1598647856166\",\"en\":\"newsdetail\",\"kv\":{\"entry\":\"2\",\"goodsid\":\"0\",\"news_staytime\":\"16\",\"loading_time\":\"9\",\"action\":\"3\",\"showtype\":\"1\",\"category\":\"73\",\"type1\":\"201\"}},{\"ett\":\"1598654400505\",\"en\":\"loading\",\"kv\":{\"extend2\":\"\",\"loading_time\":\"12\",\"action\":\"1\",\"extend1\":\"\",\"type\":\"2\",\"type1\":\"\",\"loading_way\":\"1\"}},{\"ett\":\"1598603902380\",\"en\":\"active_background\",\"kv\":{\"active_source\":\"3\"}},{\"ett\":\"1598632379633\",\"en\":\"error\",\"kv\":{\"errorDetail\":\"java.lang.NullPointerException\\\\n    at cn.lift.appIn.web.AbstractBaseController.validInbound(AbstractBaseController.java:72)\\\\n at cn.lift.dfdf.web.AbstractBaseController.validInbound\",\"errorBrief\":\"at cn.lift.dfdf.web.AbstractBaseController.validInbound(AbstractBaseController.java:72)\"}},{\"ett\":\"1598686251553\",\"en\":\"comment\",\"kv\":{\"p_comment_id\":1,\"addtime\":\"1598693035607\",\"praise_count\":283,\"other_id\":9,\"comment_id\":4,\"reply_count\":8,\"userid\":7,\"content\":\"焉蔫分偏挽拄久蝇寝堤蛇脸钉潘医都\"}}]}";
        String jsonkeys = "mid,uid,vc,vn,l,sr,os,ar,md,ba,sv,g,hw,nw,ln,la,t";
        String res = new BaseFieldUDF().evaluate(line, jsonkeys);
        System.out.println("The result is :"+res);
    }

}


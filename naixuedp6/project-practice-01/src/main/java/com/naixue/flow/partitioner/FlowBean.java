package com.naixue.flow.partitioner;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * @author : lihuan.zheng
 * @version V1.0
 * @Project: naixuedp6
 * @Package com.naixue.flow.partitioner
 * @Description: Bean类
 * @date Date : 2021年04月17日 13:04
 */
public class FlowBean implements Writable{
    private long ts;    //时间戳
    private String phoneNumber; //手机号
    private String id;  //基站编号
    private String ip;  //IP
    private String url; //URL
    private String type;    //URL类型
    private int upFlow; //上行数据包
    private int downFlow;   //下行数据包
    private int upCountFlow;    //上行流量
    private int downCountFlow;  //下行流量
    private String status;  //响应

    public long getTs() {
        return ts;
    }

    public void setTs(long ts) {
        this.ts = ts;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getUpFlow() {
        return upFlow;
    }

    public void setUpFlow(int upFlow) {
        this.upFlow = upFlow;
    }

    public int getDownFlow() {
        return downFlow;
    }

    public void setDownFlow(int downFlow) {
        this.downFlow = downFlow;
    }

    public int getUpCountFlow() {
        return upCountFlow;
    }

    public void setUpCountFlow(int upCountFlow) {
        this.upCountFlow = upCountFlow;
    }

    public int getDownCountFlow() {
        return downCountFlow;
    }

    public void setDownCountFlow(int downCountFlow) {
        this.downCountFlow = downCountFlow;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return ts +
                "\t" + phoneNumber +
                "\t" + id +
                "\t" + ip +
                "\t" + url +
                "\t" + type +
                "\t" + upFlow +
                "\t" + downFlow +
                "\t" + upCountFlow +
                "\t" + downCountFlow +
                "\t" + status
                ;
    }

    /**
     * 实现序列化
     * @param out
     * @throws IOException
     */
    @Override
    public void write(DataOutput out) throws IOException {
        out.writeLong(ts);
        out.writeUTF(phoneNumber);
        out.writeUTF(id);
        out.writeUTF(ip);
        out.writeUTF(url);
        out.writeUTF(type);
        out.writeInt(upFlow);
        out.writeInt(downFlow);
        out.writeInt(upCountFlow);
        out.writeInt(downCountFlow);
        out.writeUTF(status);
    }

    /**
     * 实现反序列化
     * @param in
     * @throws IOException
     */
    @Override
    public void readFields(DataInput in) throws IOException {
        this.ts = in.readLong();
        this.phoneNumber = in.readUTF();
        this.id = in.readUTF();
        this.ip = in.readUTF();
        this.url = in.readUTF();
        this.type = in.readUTF();
        this.upFlow = in.readInt();
        this.downFlow = in.readInt();
        this.upCountFlow = in.readInt();
        this.downCountFlow = in.readInt();
        this.status = in.readUTF();
    }

    public static void main(String[] args) {
        FlowBean flowBean = new FlowBean();
        long ts = 1000;
        String phoneNumber = "1234454";
        String id = "aabblajlsd";
        String ip = "192.168.123.122";
        String url = "www.baidu.com";
        String type = "hello";
        int upFlow = 123;
        int downFlow = 456;
        int upCountFlow = 12344;
        int downCountFlow = 243;
        String status = "400";
        flowBean.setTs(ts);
        flowBean.setPhoneNumber(phoneNumber);
        flowBean.setId(id);
        flowBean.setIp(ip);
        flowBean.setUrl(url);
        flowBean.setType(type);
        flowBean.setUpFlow(upFlow);
        flowBean.setDownFlow(downFlow);
        flowBean.setUpCountFlow(upCountFlow);
        flowBean.setDownCountFlow(downCountFlow);
        String s = flowBean.toString();
        System.out.println(s);
    }
}

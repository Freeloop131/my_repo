package com.naixue.sort;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * @author : lihuan.zheng
 * @version V1.0
 * @Project: naixuedp6
 * @Package com.naixue.sort
 * @Description: 排序的实例化对象
 * @date Date : 2021年04月13日 23:30
 */
public class MySortBean implements WritableComparable<MySortBean> {
    private String word;    //单词
    private int num;    //次数

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "MySortBean{" +
                "word='" + word  +
                ", num=" + num +
                '}';
    }

    /**
     * 比较器，按照用户自定义的规则进行排序
     * 规则：第一列按字典顺序排列，若第一列相同，则按照第二列升序排
     * @param o
     * @return
     */
    @Override
    public int compareTo(MySortBean o) {
        //1.先对第一列进行比较  word
        int result = this.word.compareTo(o.word);

        //2.第一列相同的话，再对第二列进行比较 num
        if(result == 0){
            return this.num - o.num;
        }
        return result;
    }

    /**
     * 实现序列化
     * @param out
     * @throws IOException
     */
    @Override
    public void write(DataOutput out) throws IOException {
        out.writeUTF(word);
        out.writeInt(num);
    }

    /**
     * 实现反序列化
     * @param in
     * @throws IOException
     */
    @Override
    public void readFields(DataInput in) throws IOException {
        this.word = in.readUTF();
        this.num = in.readInt();
    }
}

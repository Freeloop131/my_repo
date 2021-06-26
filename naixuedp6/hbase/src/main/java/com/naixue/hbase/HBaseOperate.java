package com.naixue.hbase;

/**
 * @author : lihuan.zheng
 * @version V1.0
 * @Project: naixuedp6
 * @Package com.naixue.hbase
 * @Description: TODO
 * @date Date : 2021年05月22日 18:00
 */

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * HBase常用的操作
 * Java API
 * 1.HBaseConfiguration： 封装了HBase集群所有的配置信息，即所运行需要的那么环境信息
 * 2.HBaseAdmin：HBase系统管理员角色，对数据表进行操作或者管理都放在这里
 * 3.HTable：封装了表的所有信息（表名，列簇，等的信息），提供了操作这些表的数据的方法
 * 4.HTableDescriptor：所有列簇的信息（一个或多个列簇）
 * 5.HColumnDescriptor：一个列簇的信息
 * 6.Cell：封装了一个列的所有信息
 * 7.Put：增加或更新
 * 8.Delete：删除
 * 9.Get：查看
 * 10.Scan：查看，可以设置过滤条件
 * 11.Result：封装一个rowkey的数据信息
 * 12.ResultScanner:封装多个Result结果集
 * 13.
 */
public class HBaseOperate {
    public static void main(String[] args) throws IOException {
        //System.out.println(isTableExist("student"));
        //createTable("student002","base_info","extra_info");
        //dropTable("sutdent001");
        //注意添加数据，不存在就是添加，存在就是修改
        //addData("student002","1003","base_info","name","John");
        //addData("student002","1003","base_info","age","31");
        //addData("student002","1003","extra_info","job","manager");
        //getAllData("student002");
        //getRowData("student002","1001");
        //getRowQualifierData("student002","1002","base_info","name");
        //deleteRowsData("student002","1003","1004");
        getDescription("student002");
    }

    //获取Configuration对象
    public static Configuration conf;
    static {
        //使用HBaseConfiguration的单例方法实例化
        conf = HBaseConfiguration.create();
        //通过zk就能带到hbase的入口地址
        conf.set("hbase.zookeeper.quorum","bigdata001:2181,bigdata002:2181,bigdata003:2181");
    }

    //1.判断表是否存在
    public static boolean isTableExist(String tableName) throws IOException {
        //新方法
        Connection connection = ConnectionFactory.createConnection(conf);
        HBaseAdmin admin = (HBaseAdmin)connection.getAdmin();
        //老方法简单
        /*HBaseAdmin admin = new HBaseAdmin(conf);
        */
        boolean b = admin.tableExists(tableName);
        return b;
    }

    //2.创建表
    public static void createTable(String tableName,String... columnFamily) throws IOException {

        HBaseAdmin admin = new HBaseAdmin(conf);
        //判断表是否存在
        if(isTableExist(tableName)){
            System.out.println("Table "+tableName+"already exists!");
        }else{
            //创建表属性对象
            HTableDescriptor hTableDescriptor = new HTableDescriptor(tableName);
            //创建多个列簇
            for (String s : columnFamily) {
                hTableDescriptor.addFamily(new HColumnDescriptor(s));
            }
            //根据对表的配置，创建表
            admin.createTable(hTableDescriptor);
            System.out.println("Table:"+tableName+" is created successfully!");
        }
    }

    //3.删除表
    public static void dropTable(String tableName) throws IOException {
        HBaseAdmin admin = new HBaseAdmin(conf);
        if(!isTableExist(tableName)){
            System.out.printf("Table "+tableName+" not exists!");
        }else{
            admin.disableTable(tableName);
            admin.deleteTable(tableName);
            System.out.println("Table "+tableName+" is dropped successfully!");
        }
    }

    //4.插入数据
    public static void addData(String tableName,String rowKey,String columnFamily,String column,String value) throws IOException {
        //创建HTable对象
        HTable hTable = new HTable(conf, tableName);
        //向表中插入数据
        Put put = new Put(Bytes.toBytes(rowKey));
        //向Put对象中组装数据
        put.add(Bytes.toBytes(columnFamily),Bytes.toBytes(column),Bytes.toBytes(value));
        hTable.put(put);
        hTable.close();
        System.out.printf("Data inserted into "+tableName+" successfully!");
    }

    //5.获取数据，也就是获取所有行
    public static void getAllData(String tableName) throws IOException {
        //HTable:封装了所有表相关的信息(表名，列簇，等的信息),提供了操作该表的所有业务方法
        HTable hTable = new HTable(conf,tableName);
        //得到用于扫描region的对象scan
        //Scan：封装查询信息，跟get有一点不同，Scan可以设置filter
        Scan scan = new Scan();
        //使用HTable得到resultscanner实现类的对象
        ResultScanner scanner = hTable.getScanner(scan);
        for (Result result : scanner) {
            //Cell:封装了column所有信息：rowkey，column，value，时间戳
            Cell[] cells = result.rawCells();
            for (Cell cell : cells) {
                System.out.printf("rowKey:"+Bytes.toString(CellUtil.cloneRow(cell)) +
                " colmnFamily:"+Bytes.toString(CellUtil.cloneFamily(cell)) +
                " qualifier:"+Bytes.toString(CellUtil.cloneFamily(cell)) +
                " value:"+Bytes.toString(CellUtil.cloneValue(cell)) + "\n");
            }
        }
        hTable.close();
    }

    //6.根据rowkey获取数据
    public static void getRowData(String tableName,String rowKey) throws IOException {
        HTable hTable = new HTable(conf,tableName);
        Get get = new Get(Bytes.toBytes(rowKey));
        Result result = hTable.get(get);
        for (Cell cell : result.rawCells()) {
            System.out.println("rowKey:"+Bytes.toString(cell.getRow()) +
                    " columnFamily:"+Bytes.toString(CellUtil.cloneFamily(cell)) +
                    " qualifier:"+Bytes.toString(CellUtil.cloneQualifier(cell)) +
                    " value:"+Bytes.toString(CellUtil.cloneValue(cell))+"\n"
            );
        }
        hTable.close();
    }

    //7.获取某行指定的数据，比如指定某个列簇的某个列限定符
    public static void getRowQualifierData(String tableName,String rowKey,String columnFaily,String qualifier) throws IOException {
        HTable hTable = new HTable(conf,tableName);
        Get get = new Get(Bytes.toBytes(rowKey));
        get.addColumn(Bytes.toBytes(columnFaily),Bytes.toBytes(qualifier));
        Result result = hTable.get(get);
        //循环获取所需要的信息，也可以单独打印自己需要的字段，这个一般根据业务需求修改
        for (Cell cell : result.rawCells()) {
            System.out.println("rowKey:"+Bytes.toString(cell.getRow()) +
                    " columnFamily:" + Bytes.toString(CellUtil.cloneFamily(cell)) +
                    " qualifier:" + Bytes.toString(CellUtil.cloneQualifier(cell)) +
                    " value:" + Bytes.toString(CellUtil.cloneValue(cell))
            );
        }
        hTable.close();
    }

    //8.删除单行或者多行
    public static void deleteRowsData(String tableName,String... rows) throws IOException {
        HTable hTable = new HTable(conf, tableName);
        List<Delete> deleteList = new ArrayList<>();
        //循环
        for (String row : rows) {
            Delete delete = new Delete(Bytes.toBytes(row));
            deleteList.add(delete);
        }
        hTable.delete(deleteList);
        hTable.close();
    }

    //9.获取表的所有列簇
    public static void getDescription(String tableName) throws IOException {
        Connection connection = ConnectionFactory.createConnection(conf);
        Table table = connection.getTable(TableName.valueOf(tableName));
        HTableDescriptor tableDescriptor = table.getTableDescriptor();
        for (HColumnDescriptor columnFamily : tableDescriptor.getColumnFamilies()) {
            System.out.printf(columnFamily.getNameAsString()+" ");
        }
    }

}

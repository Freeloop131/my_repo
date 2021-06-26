package com.naixue.hdfs;

import org.apache.commons.io.IOUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author : lihuan.zheng
 * @version V1.0
 * @Project: naixuedp6
 * @Package com.naixue.hdfs
 * @Description: TODO
 * @date Date : 2021年03月30日 21:47
 */
public class HdfsApi {

    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
        HdfsApi hdfsApi = new HdfsApi();
        //hdfsApi.getFileSystem4();
        //hdfsApi.listFiles();
        //hdfsApi.mkdirs();
        //hdfsApi.uploadFile();
        //hdfsApi.downloadFile1();
        hdfsApi.downloadFile2();
    }

    //********获取FileSystem********

    //方式一：set方式 + 通过get
    public void getFileSystem1() throws IOException {
        //1.创建Configuration对象
        Configuration conf = new Configuration();

        //2.设置文件系统类型
        conf.set("fs.defaultFS","hdfs://bigdata001:9000");

        //3.获取指定的文件系统
        FileSystem fileSystem = FileSystem.get(conf);

        //4.打印输出测试
        System.out.println(fileSystem);
    }

    //方式二：set方式 + 通过newInstance
    public void getFileSystem2() throws IOException {

        //1.创建Configuration对象
        Configuration conf = new Configuration();

        //2.设置文件系统类型
        conf.set("fs.defaultFS","hdfs://bigdata001:9000");

        //3.获取指定文件系统
        FileSystem fileSystem = FileSystem.newInstance(conf);

        //4.输出测试
        System.out.println(fileSystem);
    }

    //方式三：new URI + get
    public void getFileSystem3() throws URISyntaxException, IOException {
        FileSystem fileSystem = FileSystem.get(
                new URI("hdfs://bigdata001:9000"),
                new Configuration()
        );

        System.out.println("filesystem:" + fileSystem);
    }

    //方式四：new URI + newInstance
    public void getFileSystem4() throws URISyntaxException, IOException {
        FileSystem fileSystem = FileSystem.newInstance(
                new URI("hdfs://bigdata001:9000"),
                new Configuration()
        );

        System.out.println("filesystem:" + fileSystem);
    }


    //文件的遍历
    public void listFiles() throws URISyntaxException, IOException, InterruptedException {
        //1.获取FileSystem
        FileSystem fileSystem = FileSystem.get(new URI("hdfs://bigdata001:9000"), new Configuration(), "bigdata");

        //2.调用listFiles方法
        RemoteIterator<LocatedFileStatus> iterator = fileSystem.listFiles(new Path("/")
                , true);

        //3.迭代遍历
        while (iterator.hasNext()){
            LocatedFileStatus fileStatus = iterator.next();
            //4.打印输出
            System.out.println(fileStatus.getPath() + "====" + fileStatus.getPath().getName());
        }


    }

    //创建文件夹
    public void mkdirs() throws URISyntaxException, IOException {
        //1.获取FileSystem
        FileSystem fileSystem = FileSystem.get(new URI("hdfs://bigdata001:9000"), new Configuration());

        //2.创建文件件
        fileSystem.mkdirs(new Path("/aa/bb/cc"));

        //3.关闭FileSystem
        fileSystem.close();

    }


    //文件上传
    public void uploadFile() throws URISyntaxException, IOException {
        //1.创建FileSystme
        FileSystem fileSystem = FileSystem.get(new URI("hdfs://bigdata001:9000"), new Configuration());

        //2.上传文件
        fileSystem.copyFromLocalFile(new Path("E://tmp_note/广东省-area.json"),new Path("/aa/bb/cc"));

        //3.关闭FileSystem
        fileSystem.close();

    }

    //文件下载  通过流的方式
    public void downloadFile1() throws URISyntaxException, IOException {
        //1.获取FileSystem
        FileSystem fileSystem = FileSystem.get(new URI("hdfs://bigdata001:9000"), new Configuration());

        //2.获取HDFS的输入流
        FSDataInputStream inputStream = fileSystem.open(new Path("/aa/bb/cc/广东省-area.json"));

        //3.获取本地文件的输入流
        FileOutputStream outputStream = new FileOutputStream("E://tmp_note/gd-area.json");

        //4.文件的拷贝
        IOUtils.copy(inputStream,outputStream);

        //5.关闭FileSystem
        IOUtils.closeQuietly(inputStream);
        IOUtils.closeQuietly(outputStream);
        fileSystem.close();

    }

    //文件下载 不通过流的方式
    public void downloadFile2() throws URISyntaxException, IOException {
        //1.创建FileSystem
        FileSystem fileSystem = FileSystem.get(new URI("hdfs://bigdata001:9000"),new Configuration());

        //2.下载文件
        fileSystem.copyToLocalFile(false,new Path("/aa/bb/cc/aa.txt"),new Path("E://tmp_note/aa.txt"),true);

        //3.关闭FileSystem
        fileSystem.close();

    }

}

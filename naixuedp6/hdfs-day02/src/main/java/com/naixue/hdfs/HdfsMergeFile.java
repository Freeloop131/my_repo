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
 * @Description: 第一次作业：使用Java API方式实现合并小文件下载和上传
 * @date Date : 2021年03月31日 22:06
 */
public class HdfsMergeFile {

    /**
     * 将本地小文件合并上传到hdfs
     * @param src
     * @param dist
     * @throws URISyntaxException
     * @throws IOException
     */
    public void downloadMergeFile(String src,String dist) throws URISyntaxException, IOException {
        //1.创建文件系统
        FileSystem fileSystem = FileSystem.get(new URI("hdfs://bigdata001:9000"), new Configuration());

        //2.创建hdfs输出流
        FSDataOutputStream fsDataOutputStream = fileSystem.create(new Path(dist));

        //3.本地文件系统
        LocalFileSystem local = FileSystem.getLocal(new Configuration());

        //4.本地系统下所有文件
        FileStatus[] fileStatuses = local.listStatus(new Path(src));

        //5.遍历指定文件夹下的文件，获取每个文件的输入流
        for(int i = 0;i < fileStatuses.length;i++){
            FSDataInputStream inputStream = local.open(fileStatuses[i].getPath());

            IOUtils.copy(inputStream,fsDataOutputStream);
            IOUtils.closeQuietly(inputStream);
        }

        IOUtils.closeQuietly(fsDataOutputStream);
        local.close();
        fileSystem.close();

    }

    /**
     * hdfs小文件合并下载到本地
     * @param src
     * @param dist
     * @throws URISyntaxException
     * @throws IOException
     */
    public void uploadMergeFile(String src,String dist) throws URISyntaxException, IOException {
        //1.创建文件系统
        FileSystem fileSystem = FileSystem.get(new URI("hdfs://bigdata001:9000"), new Configuration());

        //2.获取本地系统输出流
        FileOutputStream fileOutputStream = new FileOutputStream(dist);

        //3.遍历hdfs文件，获取每个文件输入流
        RemoteIterator<LocatedFileStatus> iterator = fileSystem.listFiles(new Path(src),true);
        while (iterator.hasNext()){
            FSDataInputStream inputStream = fileSystem.open(iterator.next().getPath());
            //4.文件拷贝
            IOUtils.copy(inputStream,fileOutputStream);
            //5.关闭输入流
            IOUtils.closeQuietly(inputStream);
        }

        //关闭输出流
        IOUtils.closeQuietly(fileOutputStream);
        fileSystem.close();
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        HdfsMergeFile hdfsMergeFile = new HdfsMergeFile();
        String mergeFilename = "mergefile_" + System.currentTimeMillis() + ".txt";
        hdfsMergeFile.downloadMergeFile("E://test_files","/test/"+mergeFilename);
        hdfsMergeFile.uploadMergeFile("/aa/bb/cc/","E://test_files/"+mergeFilename);
    }
}

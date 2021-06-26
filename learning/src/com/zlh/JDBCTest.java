package com.zlh;

import java.sql.*;

/**
 * @author : lihuan.zheng
 * @version V1.0
 * @Project: learning
 * @Package com.zlh
 * @Description: TODO
 * @date Date : 2021年05月15日 12:17
 */
public class JDBCTest {
    static String url = "jdbc:postgresql://bigdata-config-dev.c3rvlb1lewx0.rds.cn-northwest-1.amazonaws.com.cn:5432/imdb_0";
    static String user = "postgres";
    static String pwd = "g30m8uc7SO3iF7Cshlva";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Class.forName("org.postgresql.Driver");
        DriverManager.getConnection(url,user,pwd);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select 1");
        while (resultSet.next()){
            System.out.println(resultSet.getString(1));
            System.out.println(" ");
            System.out.println(resultSet.getString(2));
        }

        resultSet.close();
        statement.close();
        connection.close();

    }
}

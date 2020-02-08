package com;

import com.mysql.jdbc.Driver;

import java.sql.*;

public class text {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //加载驱动类
        Class.forName("com.mysql.cj.jdbc.Driver");
        //建立连接
        long startTime = System.currentTimeMillis();
        Connection connection= DriverManager.getConnection("jdbc:mysql://123.57.138.105:3306/note","root","2997385765a");
        long time=System.currentTimeMillis()-startTime;
        System.out.println("连接成功 花费时间："+time);
        String sql="select * from t1 ";
        Statement statement=connection.createStatement();
        System.out.println(statement.execute("create table if not exists test(id int(3) auto_increment primary key ,uname varchar (3),age int(3)) auto_increment=0;")) ;
        statement.execute("insert into test (uname,age) values ('zha',18)");
        ResultSet resultSet =statement.executeQuery("select * from test");
        while (resultSet.next()) {
            System.out.println("resultSet.getString('uname') = " + resultSet.getString("uname"));
            System.out.println("resultSet.getInt(\"id\") = " + resultSet.getInt("id"));
        }
//        statement.execute("delete from test;");
    }
}

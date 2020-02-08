package com;
import java.sql.*;
public class  Preparedstatement {
    public static void main(String[] args) {
        Connection connection=null;
        PreparedStatement statement=null;
        ResultSet resultSet = null;
        try {
            //加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            //建立连接
            long startTime = System.currentTimeMillis();
            connection = DriverManager.getConnection("jdbc:mysql://123.57.138.105:3306/note", "root", "2997385765a");
            long time = System.currentTimeMillis() - startTime;
            System.out.println("连接成功 花费时间：" + time);
            String sql = "insert into test (uname ,age,date,time )values(?,?,?,?);";
            statement = connection.prepareStatement(sql);
            statement.setString(1, "yun");
            statement.setInt(2, 16);
            statement.setDate(3, new Date(System.currentTimeMillis()));
            statement.setTime(4, new Time(System.currentTimeMillis()));
            statement.execute();
            sql = " select * from  test;";
            PreparedStatement pm = connection.prepareStatement(sql);
            resultSet = pm.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + "====" + resultSet.getString(2) + "=====" + resultSet.getInt(3)
                        + "=====" + resultSet.getDate(4) + "======" + resultSet.getTime(5));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (resultSet!=null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement!=null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
//        statement.execute("delete from test;");
    }
}

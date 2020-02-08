package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    private Connection connection;
    private Statement statement;
    public Main(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://yunxiao.site:3306", "root", "2997385765a");
            statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }


    }
    public void addMsg(){

        String sql = "insert into note(uname,date,note)values(\"void\", \" \")";
    }
    public static void main(String[] args) {
        new Main();
    }
}

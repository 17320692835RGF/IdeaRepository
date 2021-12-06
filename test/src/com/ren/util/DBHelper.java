package com.ren.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//数据库连接类
public class DBHelper {

    //加载驱动
    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //获取数据库连接
    public static Connection getConnection(){
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Hongkong&characterEncoding=utf8"
            ,"root","123456");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    //关闭连接
    public static void closeConnection(Connection con){
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

package www.zh.utils;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;



//数据库工具包
public class DButils {

    private static Properties pro = new Properties();



    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            pro = new Properties();
            pro.load(DButils.class.getResourceAsStream("/mysql.properties"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    //创建连接
    private static final String URL = pro.getProperty("url");
    private static final String USERNAME = pro.getProperty("username");
    private static final String PASSWORD = pro.getProperty("password");

    public static Connection getConnection() {
        Connection con = null;
        try {
            if (null == con){
                con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    //关闭Connection的方法
    public static void closeConnection(Connection con){
        if (null != con){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    //关闭PreparedStatement的方法
    public static void closePreparedStatement(PreparedStatement ps){
        if (null != ps){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    //关闭ResultSet的方法
    public static void closeResultSet(ResultSet rs){
        if (null != rs){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

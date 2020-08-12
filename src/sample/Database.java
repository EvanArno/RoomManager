package sample;

import java.sql.*;

public class Database {
    private static final ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();
    public static void link() throws  Exception{
        String strCon = "jdbc:mysql://127.0.0.1:3306/dormitory";
        //System.out.println("正在连接数据库...");
        Class.forName("com.mysql.jdbc.Driver");
        Connection con;

        con = DriverManager.getConnection(strCon,"root","123456");
        if(con != null){
            //System.out.println("连接成功");
        }
    }
    public static Connection getConnection() {
        String strCon = "jdbc:mysql://127.0.0.1:3306/dormitory";
        Connection conn=threadLocal.get();// 从线程中获得数据库连接
        if (conn == null) {// 没有可用的数据库连接
            try {
                conn = DriverManager.getConnection(strCon, "root", "123456");// 创建新的数据库连接
                threadLocal.set(conn);// 将数据库连接保存到线程中
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //System.out.println("数据库连接成功 "); //控制台信息查看
        return conn; }
    public static String getdata(String sql){
        String a = "";
        return a;
    }
}

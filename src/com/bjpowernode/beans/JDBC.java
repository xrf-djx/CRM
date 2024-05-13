package com.bjpowernode.beans;

import java.sql.*;
import java.util.ResourceBundle;

public class JDBC {

    static ResourceBundle bundle = ResourceBundle.getBundle("com.bjpowernode.resources.jdbc");
    static String driver = bundle.getString("driver");
     static String url = bundle.getString("url");
   static String user = bundle.getString("user");
    static String password = bundle.getString("password");


    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;

    }

    public static void close(Connection conn, Statement ps, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}





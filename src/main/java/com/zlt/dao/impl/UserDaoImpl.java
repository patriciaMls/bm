package com.zlt.dao.impl;

import com.sun.org.apache.xerces.internal.impl.xpath.XPath;
import com.zlt.dao.UserDao;
import com.zlt.entity.User;

import java.sql.*;

/**
 * @description:
 * @author: Patricia
 * @date: Created in 2020/11/18 20:40
 * @version: 1.0
 * @modified By:
 */
public class UserDaoImpl implements UserDao {
    // JDBC操作 - 不去封装JDBC
    // 关键步骤-1：导入驱动包 mysql-connecter-java-5.1.39.jar
    // 关键步骤-2：定义数据库相关操作的属性
    // 关键步骤-3：加载驱动类

    private String username = "root";
    private String password = "mysql20200321";
    private String url = "jdbc:mysql://localhost:3306/tujian?serverTimezone=UTC";
    private String driver = "com.mysql.cj.jdbc.Driver";

    public UserDaoImpl() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 进行数据库操作
    // 关键接口-1：java.sql.Connection
    // 关键接口-2：java.sql.PreparedStatement
    // 关键接口-3：java.sql.ResultSet
    @Override
    public User getUser(String telphone) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        User user = null;
        String sql = "SELECT * FROM tujian.account WHERE telphone = ?";
        try {
            conn = DriverManager.getConnection(url, username, password);
            pstm = conn.prepareStatement(sql); // 预处理操作，防止SQL注入
            pstm.setString(1, telphone);
            rs = pstm.executeQuery();
            while (rs.next()){
                int id = rs.getInt(1);
                String username = rs.getString(2);
                String password = rs.getString(3);
                String tel = rs.getString(4);
                String idcard = rs.getString(5);
                user = new User(id, username, password, tel, idcard);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}

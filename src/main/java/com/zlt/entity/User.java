package com.zlt.entity;

/**
 * @description: 模型 - 表示存储用户表中的数据模型
 * @author: Patricia
 * @date: Created in 2020/11/18 20:41
 * @version: 1.0
 * @modified By:
 */
public class User {
    private int id;             // 用户的id
    private String username;    // 用户的名字
    private String password;    // 用户的密
    private String telphone;    // 用户的手机号
    private String idcard;      // 用户的身份证号码

    public User() {
    }

    public User(int id, String username, String password, String telphone, String idcard) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.telphone = telphone;
        this.idcard = idcard;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", telphone='" + telphone + '\'' +
                ", idcard='" + idcard + '\'' +
                '}';
    }
}

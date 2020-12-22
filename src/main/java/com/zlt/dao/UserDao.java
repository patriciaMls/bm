package com.zlt.dao;

import com.zlt.entity.User;

/**
 * @description:
 * @author: Patricia
 * @date: Created in 2020/11/18 20:40
 * @version: 1.0
 * @modified By:
 */
public interface UserDao {
    User getUser(String telphone);
}

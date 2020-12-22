package com.zlt.service.impl;

import com.zlt.dao.UserDao;
import com.zlt.dao.impl.UserDaoImpl;
import com.zlt.entity.User;
import com.zlt.service.UserService;

/**
 * @description:
 * @author: Patricia
 * @date: Created in 2020/11/18 20:39
 * @version: 1.0
 * @modified By:
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public User getUser(String telphone) {
        return userDao.getUser(telphone);
    }
}

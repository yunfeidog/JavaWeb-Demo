package com.cxk.service.impl;

import com.cxk.dao.UserDao;
import com.cxk.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        System.out.println("构造器注入userDao");
        this.userDao = userDao;
    }

    @Override
    public void save() {
        System.out.println("user service save ...");
    }
}

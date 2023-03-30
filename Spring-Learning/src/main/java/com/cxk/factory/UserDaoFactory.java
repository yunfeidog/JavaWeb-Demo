package com.cxk.factory;

import com.cxk.dao.UserDao;
import com.cxk.dao.impl.UserDaoImpl;

public class UserDaoFactory {
    public UserDao getUserDao(){
        return new UserDaoImpl();
    }
}
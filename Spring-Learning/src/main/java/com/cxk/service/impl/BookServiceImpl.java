package com.cxk.service.impl;


import com.cxk.dao.BookDao;
import com.cxk.dao.UserDao;
import com.cxk.dao.impl.BookDaoImpl;
import com.cxk.service.BookService;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class BookServiceImpl implements BookService, InitializingBean, DisposableBean {
    //5.删除业务层中使用new的方式创建的dao对象
    private BookDao bookDao;

    //注入userDao ,引用类型
    private UserDao userDao;

    //注入基本类型
    private String username;
    private int id;

    public BookServiceImpl(UserDao userDao) {
        this.userDao = userDao;
        System.out.println("构造器注入 userDao ...");
        System.out.println("book service constructor ...");
    }


    //6.提供对应的set方法
    public void setBookDao(BookDao bookDao) {
        System.out.println("book service setBookDao ...");
        this.bookDao = bookDao;
    }


    public void setUsername(String username) {
        System.out.println("book service setUsername ...");
        this.username = username;
    }

    public void setId(int id) {
        System.out.println("book service setId ...");
        this.id = id;
    }


    public void save() {
        System.out.println("setter 注入 username = " + username);
        System.out.println("setter 注入 id = " + id);
        System.out.println("book service save ...");
        bookDao.save();
        userDao.save();
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("book service destroy ...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("book service afterPropertiesSet ...");
    }
}

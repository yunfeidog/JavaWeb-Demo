package com.cxk.dao.impl;

import com.cxk.dao.BookDao;

public class BookDaoImpl implements BookDao {

    //构造器注入
    private  String username;
    private  int id;

    //Spring底层是使用无参构造器
    public BookDaoImpl(String username, int id) {
        this.username = username;
        this.id = id;
        System.out.println("create boookDaoImpl..."+username+"..."+id+"...");

    }

    public void save() {
        System.out.println("book dao save ...");
    }

    public void init(){
        System.out.println("book dao init...");
    }

    public void destroy(){
        System.out.println("book dao destroy...");
    }
}

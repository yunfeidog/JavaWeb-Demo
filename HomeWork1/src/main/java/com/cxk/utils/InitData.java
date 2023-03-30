package com.cxk.utils;

import com.cxk.model.User;

import java.util.ArrayList;
import java.util.List;


public class InitData {
    //初始化可以登录的用户数据
    public static List<User> userList = null;

    public static void initUser() {
        userList=new ArrayList<>();
        userList.add(new User("1","zhangsan","123456","1@qq.com"));
        userList.add(new User("2","lisi","123456","2@qq.com"));
        userList.add(new User("3","wangwu","123456","3@qq.com"));


    }
}

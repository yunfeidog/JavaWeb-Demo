package com.cxk.dao.Main;

import com.cxk.dao.BookDao;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppForLifeCycle {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookDao bookDao =(BookDao) ctx.getBean("bookDao");
        bookDao.save();
        ctx.close();

    }
}

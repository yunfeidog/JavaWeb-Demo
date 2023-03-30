package com.cxk.dao.Main;

import com.cxk.service.BookService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppForDiSetter {
    public static void main(String[] args) {
        //1.加载spring配置文件
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2.获取配置创建的对象
        BookService bookService = (BookService) ctx.getBean("bookService");
        //3.使用对象
        bookService.save();
    }
}

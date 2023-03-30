package com.cxk;

import com.cxk.dao.BookDao;
import com.cxk.service.BookService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookDao bookDao =(BookDao) ctx.getBean("bookDao2");
        bookDao.save();

        BookService bookService = (BookService) ctx.getBean("bookService2");
        bookService.save();
    }
}

package com.cxk;

import com.cxk.dao.BookDao;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class AppBeanFactory {
    public static void main(String[] args) {
        ClassPathResource classPathResource = new ClassPathResource("applicationContext.xml");
        BeanFactory xmlBeanFactory = new XmlBeanFactory(classPathResource);
        BookDao bookDao = xmlBeanFactory.getBean(BookDao.class);
        bookDao.save();

    }

}

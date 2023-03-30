package com.cxk.dao.Main;

import com.cxk.dao.OrderDao;
import com.cxk.factory.OrderDaoFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author houyunfei
 */
public class AppTestFactory {
    public static void main(String[] args) {
        //原始的工厂创建类的方式
//        OrderDao orderDao = OrderDaoFactory.getOrderDao();
//        orderDao.save();


        //spring
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        OrderDao orderDao = (OrderDao) ctx.getBean("orderDao");
        orderDao.save();

    }
}

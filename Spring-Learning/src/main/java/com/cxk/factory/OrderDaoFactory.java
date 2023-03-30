package com.cxk.factory;

import com.cxk.dao.OrderDao;
import com.cxk.dao.impl.OrderDaoImpl;

//静态工厂创建对象
public class OrderDaoFactory {
    public static OrderDao getOrderDao(){
        return new OrderDaoImpl();
    }
}
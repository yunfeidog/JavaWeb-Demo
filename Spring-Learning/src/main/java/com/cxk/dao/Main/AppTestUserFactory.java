package com.cxk.dao.Main;

import com.cxk.dao.UserDao;
import com.cxk.factory.UserDaoFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 实例工厂
 * @author houyunfei
 */
public class AppTestUserFactory {
    public static void main(String[] args) {
        //创建实例工厂对象，此处和静态工厂的工厂类不一样的地方是方法不是静态方法
        UserDaoFactory userDaoFactory = new UserDaoFactory();
        //通过实例工厂对象创建对象
        UserDao userDao = userDaoFactory.getUserDao();
        userDao.save();

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao1 = (UserDao) ctx.getBean("userDao2");
        userDao1.save();


    }
}

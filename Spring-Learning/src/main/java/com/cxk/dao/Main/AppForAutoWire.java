package com.cxk.dao.Main;

import com.cxk.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppForAutoWire {
    public static void main(String[] args) {
        //1.加载spring配置文件
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2.获取配置创建的对象
        UserService userService = (UserService) ctx.getBean("userService");
        //3.使用对象
        userService.save();
    }
}

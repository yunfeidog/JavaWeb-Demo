package com.cxk.servlet;

import com.cxk.model.User;
import com.cxk.utils.InitData;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletLogin", value = "/login")
public class ServletLogin extends HttpServlet {

    @Override
    public void init() throws ServletException {
        InitData.initUser();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean flag=false;
        for (User user : InitData.userList) {
            if (user.getName().equals(username) && user.getPassword().equals(password)) {
                request.getSession().setAttribute("user", user);
                flag=true;
                break;
            }
        }
        if (flag){
            request.setAttribute("msg", "登录成功,"+username+"欢迎你");
        }else  {
            request.setAttribute("msg", "用户名或密码错误");
        }
        System.out.println(request.getAttribute("msg"));
        request.getRequestDispatcher("/result.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}

/**
 * 在Servlet类上使用： @WebServlet
 *
 *  属性名	        类型	        属性描述
 *  name	        String	    指定servlet的name属性,等价于<Servlet-name>.如果没有显示指定，则该servlet的取值即为类的全限定名.
 *  value	        String[]	等价于urlPatterns,二者不能共存.
 *  urlPatterns	String[]	指定一组servlet的url的匹配模式,等价于<url-pattern>标签.
 *  loadOnStartup	int	        指定servlet的加载顺序,等价于<load-on-startup>标签.
 *  initParams	    WebInitParam[]	指定一组初始化参数,等价于<init-param>标签.
 *  asyncSupported	boolean	    声明servlet是否支持异步操作模式,等价于<async-supported>标签.
 *  displayName	String	    servlet的显示名,等价于<display-name>标签.
 *  description	String	    servlet的描述信息,等价于<description>标签.
 *
 * //注解配置
 * @WebServlet(
 *         displayName = "User类处理的Servlet" ,    //描述
 *         name = "UserServlet",                   //servlet名称
 *         urlPatterns = { "/userServlet" },       //url
 *         loadOnStartup = 1,                      //启动项
 *         initParams = { @WebInitParam(name = "username", value = "宋小怪") }    //初始化参数
 * )
 */

package cn.edu.usts.cs.servlet;

import com.alibaba.fastjson.JSON;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebServlet(name = "ServletHello", urlPatterns = "/hello")
@WebServlet(value = "/hello")
public class ServletHello extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 获取客户端的请求参数.
//        String name = request.getParameter("name");
        // 浏览器输出乱码，进行 编码格式转换：    iso-8859-1 ==> utf-8
         String name = new String(request.getParameter("name").getBytes("iso-8859-1"), "utf-8");
        System.out.println("name:" + name);

        String []strHobby  = request.getParameterValues("hobby");
        // 浏览器输出乱码，进行编码格式转换：    iso-8859-1 ==> utf-8
        for (int index = 0; (strHobby != null) && (index < strHobby.length) ; index ++  ) {
            strHobby[index] =  new String(strHobby[index].getBytes("iso-8859-1"), "utf-8");
        }

        System.out.println(JSON.toJSONString(strHobby));
        // 控制台乱码，设置tomcat的“vm.options”为: -Dfile.encoding=UTF-8

        // 2. 处理客户的请求.

        // 3. 返回响应.
//        response.setContentType("text/html;charset=UTF-8"); // 设置响应数据的MIME编码格式
//        PrintWriter writer = response.getWriter();          // 获取输出流对象
//
//        // 输出实际内容。此处省略了HTML文档的格式（如html、head、body等标签），仅作演示。
//        writer.println("Hello,World!<br>");
//        writer.println("Hello, Are you " + name + "?");
//        writer.println("<br>你的爱好： " + JSON.toJSONString(strHobby));

        HttpSession session = request.getSession();
        session.setAttribute("UserName" ,name );
//        response.sendRedirect("success.jsp");
        RequestDispatcher dispatcher =
                request.getRequestDispatcher("success.jsp");
        dispatcher.forward(request, response);
    }


}

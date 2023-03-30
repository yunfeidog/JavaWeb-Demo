<%--
  Created by IntelliJ IDEA.
  User: luwz
  Date: 2023/2/23
  Time: 8:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
  <head>
    <title>JAVA WEB APP Demo</title>
  </head>
  <body>
      <H1>Hello,World!</H1>

      <form action="./hello" method="post">
        姓名<input type="text" name="name" />
        个人爱好：
            <input type="checkbox" name="hobby" value="旅游" >旅游
            <input type="checkbox" name="hobby" value="音乐">音乐
            <input type="checkbox" name="hobby" value="登山">登山
        <input type="submit" value="提交"/>
      </form>

  </body>
</html>

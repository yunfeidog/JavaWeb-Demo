<%--
  Created by IntelliJ IDEA.
  User: Semoon
  Date: 2020-03-30
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="cn.edu.usts.cs.entity.Student" %>

<html>
<head>
    <title>JTSL Demo</title>
</head>
<body>
<%

    Student[]students = new  Student[5];
    for( int index = 0; index < students.length ; index ++) {
        students[index] = new Student(index + 1, "Tom " + index);
    }

    session.setAttribute("students",  students);

%>

运行结束了，<a href="JSTLDemo2.jsp" >请看JSTL的测试 </a>

对象系列化的问题。
</body>
</html>

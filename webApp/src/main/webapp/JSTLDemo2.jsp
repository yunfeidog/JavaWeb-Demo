<%--
  Created by IntelliJ IDEA.
  User: Semoon
  Date: 2020-03-30
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="cn.edu.usts.cs.entity.Student" %>

<html>
<head>
    <title>JSTL　DEMO</title>
</head>
<body>
    <table  border="1">
        <tr>
            <th>id</th>
            <th>name</th>
        </tr>

        <c:forEach  items="${sessionScope.students}" var="student" >
          <tr>
              <td>
                  ${student.id}
              </td>
              <td>
                  ${student.name}
              </td>
          </tr>
        </c:forEach>
    </table>

</body>
</html>

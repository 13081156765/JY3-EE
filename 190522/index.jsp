<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2019/5/22
  Time: 14:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <table border="1px">
      <thead>
        <th>ID</th>
        <th>用户名</th>
        <th>密码</th>
        <th>ALTER</th>
      </thead>
      <c:forEach items="${users}" var="user">
        <tr>
          <td>${user.id}</td>
          <td>${user.username}</td>
          <td>${user.password}</td>
          <td><a href="updateDemo.jsp"><button type="button">修改</button></a>&nbsp;&nbsp;&nbsp;&nbsp;<button type="button">删除</button></td>
        </tr>

      </c:forEach>
    </table>
  </body>
</html>

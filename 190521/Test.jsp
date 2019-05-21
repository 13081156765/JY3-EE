<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2019/5/21
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        pageContext.setAttribute("username","张三");
        pageContext.getRequest();
        pageContext.getResponse();
        pageContext.getServletConfig();
        pageContext.getServletContext();
        pageContext.getSession();
    %>
    <a href="test2.jsp">跳转</a>
</body>
</html>

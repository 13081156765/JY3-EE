<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2019/5/21
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        String str = (String) pageContext.getAttribute("username");
        System.out.print(str);
    %>
</body>
</html>

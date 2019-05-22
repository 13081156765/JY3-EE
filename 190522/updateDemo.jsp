<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2019/5/22
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改页面</title>
</head>
<body>
    <form action="uds.do" method="post">
        用户ID：<input type="text" name="ID">
        <br>
        请输入旧密码：<input type="text" name="oldpassword">
        <br>
        请输入新密码：<input type="text" name="newpassword">
        <br>
        <button href="/us.do">确认修改</button>
    </form>
</body>
</html>

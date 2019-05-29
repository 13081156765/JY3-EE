<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2019/5/24
  Time: 10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件传输</title>
</head>
<body>
    <form enctype="multipart/form-data" method="post" action="upload.do">
        <input type="file" name="file1"/>
        <input type="submit" value="上传文件" />
    </form>
</body>
</html>

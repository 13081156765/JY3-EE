<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2019/5/28
  Time: 18:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>查询商品</title>
</head>
<body>
    <table class="table table-hover">
        <thead>
        <th>商品ID</th>
        <th>商品名</th>
        <th>商品价格</th>
        <th>商品图片</th>
        <th>商品详情</th>
        <th>商品库存</th>
        <th>商品上架日期</th>
        <th>类别ID</th>
        <th>生产厂家</th>
        <th>操作</th>
        </thead>
        <c:forEach items="${pros}" var="pro">
            <tr>
                <td>${pro.pro_id}</td>
                <td>${pro.pro_name}</td>
                <td>${pro.pro_price}</td>
                <td><img src="/terraceimg/${pro.pro_image}" style="width: 100px"></td>
                <td>${pro.pro_des}</td>
                <td>${pro.pro_stock}</td>
                <td>${pro.pro_date}</td>
                <td>${pro.pro_category_id}</td>
                <td>${pro.pro_factory}</td>
                <td><a href="us.do?id=${pro.pro_id}&name=${pro.pro_name}&price=${pro.pro_price}&image=${pro.pro_image}&des=${pro.pro_des}
                &stock=${pro.pro_stock}&date=${pro.pro_date}&category=${pro.pro_category_id}&factory=${pro.pro_factory}">
                    <button type="button">修改</button></a>&nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="ds.do?id=${pro.pro_id}"><button type="button">删除</button></a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>

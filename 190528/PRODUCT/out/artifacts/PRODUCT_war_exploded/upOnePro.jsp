<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2019/5/28
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改页面</title>
</head>
<body>
    <form enctype="multipart/form-data" action="se.do">
        <div class="form-group" >
            <label for="pro_name">商品名</label>
            <input type="text" class="form-control" id="pro_name" placeholder="商品名" name="name">
        </div>
        <div class="form-group">
            <label for="pro_price">商品价格</label>
            <input type="number" class="form-control" id="pro_price" placeholder="商品价格" min="1.00" max="99999" name="price">
        </div>
        <div class="form-group">
            <label for="pro_image">选择图片</label>
            <input type="file" id="pro_image" name="image">
            <p class="help-block">请选择图片</p>
        </div>
        <div class="form-group">
            <label for="pro_des">商品详情</label>
            <br>
            <textarea placeholder="请输入商品详细信息" style="width: 100%" id="pro_des" name="des"></textarea>
        </div>
        <div class="form-group">
            <label for="pro_stock">商品库存</label>
            <input type="number" class="form-control" id="pro_stock" placeholder="商品库存" min="0" max="9999999" name="stock">
        </div>
        <div class="form-group">
            <label for="pro_date">商品上架日期</label>
            <input type="date" class="form-control" id="pro_date" placeholder="商品上架日期" name="date">
        </div>
        <div class="form-group">
            <label for="pro_category_id">类别ID</label>
            <input type="number" class="form-control" id="pro_category_id" placeholder="类别ID" name="category">
        </div>
        <div class="form-group">
            <label for="pro_factory">生产厂家</label>
            <input type="text" class="form-control" id="pro_factory" placeholder="生产厂家" name="factory">
        </div>
        <button type="submit" class="btn btn-default" name="Y">确认修改</button>
    </form>
</body>
</html>

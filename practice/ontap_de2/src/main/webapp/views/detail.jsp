<%--
  Created by IntelliJ IDEA.
  User: lehuu
  Date: 3/29/2026
  Time: 5:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>chi tiết</title>
</head>
<body>
<h2>Thông tin chi tiết sản phầm</h2>
<img src="images/${detail.anhDT}" width="80" height="60">

<p>${detail.maDT}</p>
<p>${detail.tenDT}</p>

<p>${detail.boNho}</p>

<p>${detail.giaBan}</p>
<a href="dienthoai?action=list">quay lại</a>
</body>
</html>

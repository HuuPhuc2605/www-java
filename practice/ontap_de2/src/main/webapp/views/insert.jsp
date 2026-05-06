<%--
  Created by IntelliJ IDEA.
  User: lehuu
  Date: 3/29/2026
  Time: 6:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Thêm mới sản phẩm</h2>
<form action="dienthoai" method="post">
    <input type="hidden" name="action" value="insert">
    Tên: <input type="text" name="tenDT"><br/>
    Giá: <input type="number" name="giaBan"><br/>
    Bộ nhớ: <input type="text" name="boNho"><br/>
    Ảnh: <input type="text" name="anhDT"><br/>
    Loại: <select name="maHang">
    <c:forEach var="h" items="${hangList}">
        <option value="${h.maHang}">${h.tenHang}</option>

    </c:forEach></select><br/>
    <button type="submit">Thêm</button>
</form>
</body>
</html>

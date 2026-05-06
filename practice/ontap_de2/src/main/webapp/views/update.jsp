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
<h2>Cập nhật</h2>
<form action="dienthoai" method="post">
<input type="hidden" name="action" value="update">
<input type="hidden" name="maDT" value="${edit.maDT}">
Tên: <input type="text" name="tenDT" value="${edit.tenDT}"><br/>
Tên: <input type="number" name="giaBan" value="${edit.giaBan}"><br/>
Tên: <input type="text" name="boNho" value="${edit.boNho}"><br/>
Tên: <input type="text" name="anhDT" value="${edit.anhDT}"><br/>
Loại: <select name="maHang"><c:forEach var="h" items="${hList}">
    <option value="${h.maHang}" ${h.maHang == edit.maHang.maHang ? 'selected':''}>${h.tenHang}</option>

</c:forEach></select><br/>
<button type="submit">Cập nhật</button>
</form>
</body>
</html>

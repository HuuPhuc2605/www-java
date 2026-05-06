<%--
  Created by IntelliJ IDEA.
  User: lehuu
  Date: 3/29/2026
  Time: 3:15 PM
  To change this template use File | Settings | File Templates.
--%>
<script src="https://cdn.tailwindcss.com"></script>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách điện thoại</title>
</head>
<a href="dienthoai?action=list">load lại</a>
<form action="dienthoai" method="get">
    <input type="hidden" name="action" value="search">
    Tên dt: <input type="text" name="name" value="${name}">
    <button type="submit">Tìm</button>
</form>
<form action="dienthoai" method="get">
    <input type="hidden" name="action" value="byHang">
    Chọn hãng: <select name="maHang" >
    <c:forEach var="h" items="${hangList}">
        <option value="${h.maHang}">${h.tenHang}</option>
    </c:forEach>
</select>
    <button type="submit">Lọc</button>
</form>
<a href="dienthoai?action=add">Thêm điện thoại mới</a>
<body>
<div class="grid grid-cols-3 gap-4">
    <c:forEach var="d" items="${list}">
        <div class="bg-green-100 rounded-lg">
            <img src="images/${d.anhDT}" width="80" height="60">
            <div>${d.maDT}</div>
            <div>${d.tenDT}</div>
            <div>${d.giaBan}</div>
            <div>${d.boNho}</div>
            <div>${d.giaBan}</div>
            <c:forEach var="h" items="${hangList}">
                <c:if test="${h.maHang == d.maHang.maHang}">
                    <div>${h.tenHang}</div>
                </c:if>

            </c:forEach>
            <div>
                <a href="dienthoai?action=detail&id=${d.maDT}">chi tiết</a>
                <a href="dienthoai?action=edit&maDT=${d.maDT}">cập nhật</a>
                <form action="dienthoai" method="post" style="display:inline;">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="maDT" value="${d.maDT}">
                    <button type="submit" onclick="return confirm('Bạn có chắc muốn xóa?')">Xóa</button>
                </form>

            </div>

        </div>
    </c:forEach>
</div>

</body>
</html>

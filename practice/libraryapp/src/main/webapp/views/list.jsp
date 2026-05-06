<%--
  Created by IntelliJ IDEA.
  User: lehuu
  Date: 3/28/2026
  Time: 9:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<script src="https://cdn.tailwindcss.com"></script>
<html>
<head>
    <title>Danh sách các loại sách</title>
</head>
<form action="sach" method="get">
    <input type="hidden" name="action" value="search"/>
    Tên sách: <input name="name" type="text" value="${name}">
    <button type="submit">Tìm</button>
</form>
<form action="sach" method="get">
    <input type="hidden" name="action" value="byTL"/>
    Chọn thể loại:
    <select name="maTL">
        <c:forEach var="tl" items="${theloaiList}">
            <option value="${tl.maTL}">${tl.tenTL}</option>
        </c:forEach>
    </select>
    <button type="submit">Lọc</button>
</form>
<body>
<div class="grid grid-cols-3 gap-4">
    <c:forEach var="s" items="${list}">
        <div class=" mt-6 w-52 border rounded-lg p-3 text-center bg-green-100">
            <img src="images/${s.hinhAnh}" width="80" class="w-full h-14 object-cover"/>
            <div>${s.maSach}</div>
            <div>${s.tenSach}</div>

            <div>${s.tacGia}</div>

            <div>${s.giaTien}</div>
            <c:forEach var="tl" items="${theloaiList}">
                <c:if test="${tl.maTL == s.maTL.maTL}">
                    <div>${tl.tenTL}</div>
                </c:if>
            </c:forEach>
            <div>
                <a href="sach?action=detail&id=${s.maSach}">Chi tiết</a>
                <a href="sach?action=edit&maSach=${s.maSach}">Sửa</a>
            </div>
        </div>
    </c:forEach>

</div>
</body>
</html>

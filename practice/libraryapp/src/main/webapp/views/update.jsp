<%--
  Created by IntelliJ IDEA.
  User: lehuu
  Date: 3/28/2026
  Time: 4:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>cập nhật</title>
</head>
<body>
<h2>Cập nhật căn hộ</h2>
<form action="sach" method="post">
    <input type="hidden" name="action" value="update"/>
    <input type="hidden" name="maSach" value="${s.maSach}"/><br/>
    Tên: <input type="text" name="tenSach" value="${s.tenSach}"/><br/>
    Tác giả: <input type="text" name="tacGia" value="${s.tacGia}"/><br/>
    Giá: <input type="number" name="giaTien" value="${s.giaTien}"/><br/>
    Ảnh: <input type="text" name="hinhAnh" value="${s.hinhAnh}"/><br/>
    Thể loại: <select name="maTL"> <c:forEach var="tl" items="${tlList}">
    <option value="${tl.maTL}" ${tl.maTL == s.maTL.maTL ? 'selected' : ''}>
            ${tl.tenTL}
    </option>
</c:forEach></select><br/>
    <button type="submit">Cập nhật</button>
</form>

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: lehuu
  Date: 3/28/2026
  Time: 3:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>chi tiết</title>
</head>
<body>
<h2> Thông tin chi tiết khóa học</h2>
<p>${detail.maSach}</p>
<p>${detail.tenSach}</p>
<p>${detail.tacGia}</p>
<p>${detail.giaTien}</p>
<a href="sach?action=list">quay lại</a>

</body>
</html>

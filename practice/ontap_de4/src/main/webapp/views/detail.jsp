<%--
  Created by IntelliJ IDEA.
  User: lehuu
  Date: 3/31/2026
  Time: 1:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="bg-green-100 p-3 mt-6 rounded-2xl">
    <div>${detail.tenDoi}</div>
    <div>${detail.hlv}</div>
    <div>${detail.thanhVien}</div>
    <div>${detail.logo}</div>
    <c:forEach var="g" items="${giaidauList}">
        <c:if test="${g.maGiai == detail.maGiai.maGiai}">
            <div>${g.tenGiai}</div>
        </c:if>
    </c:forEach>

</div>

</body>
</html>

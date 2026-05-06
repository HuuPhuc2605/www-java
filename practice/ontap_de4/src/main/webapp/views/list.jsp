<%--
  Created by IntelliJ IDEA.
  User: lehuu
  Date: 3/31/2026
  Time: 12:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<script src="https://cdn.tailwindcss.com"></script>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="doibong" method="get">
    <input type="hidden" name="action" value="search">
    ten: <input type="text" name="ten" value="${ten}">
    <button type="submit">tim</button>
</form>
<form action="doibong" method="get">
    <input type="hidden" name="action" value="byGD">
   <select name="id">
       <c:forEach var="g" items="${giaidauList}">
           <option value="${g.maGiai}">
               ${g.tenGiai}
           </option>
       </c:forEach>
   </select>
    <button type="submit">tim</button>
</form>
<div class="grid grid-cols-3 gap-6">
    <c:forEach var="d" items="${list}">
        <div class="bg-green-100 p-3 mt-6 rounded-2xl">
            <div>${d.tenDoi}</div>
            <div>${d.hlv}</div>
            <div>${d.thanhVien}</div>
            <div>${d.logo}</div>
        <c:forEach var="g" items="${giaidauList}">
            <c:if test="${g.maGiai == d.maGiai.maGiai}">
                <div>${g.tenGiai}</div>
            </c:if>
        </c:forEach>
            <a href="doibong?action=detail&id=${d.maDoi}">chi tiết</a>
        </div>
    </c:forEach>
</div>

</body>
</html>

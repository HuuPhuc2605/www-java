<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<body>

<h2>Danh sách sản phẩm</h2>
<a href="new">+ Thêm mới</a>

<table border="1">
  <tr>
    <th>ID</th>
    <th>Tên</th>
    <th>Giá</th>
    <th>Ảnh</th>
    <th>Hành động</th>
  </tr>

  <c:forEach var="p" items="${listProduct}">
    <tr>
      <td>${p.id}</td>
      <td>${p.name}</td>
      <td>${p.price}</td>
      <td><img src="${p.urlImage}" width="80"></td>
      <td>
        <a href="edit?id=${p.id}">Sửa</a> |
        <a href="delete?id=${p.id}">Xóa</a>
      </td>
    </tr>
  </c:forEach>

</table>

</body>
</html>

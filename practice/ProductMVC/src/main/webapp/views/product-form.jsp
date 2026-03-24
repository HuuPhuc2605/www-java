<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
  <title>Product Form</title>
</head>
<body>
<h2>${product == null ? "Add Product" : "Edit Product"}</h2>

<form action="products" method="post">
  <input type="hidden" name="id" value="${product.id}" />

  <label>Name:</label><br>
  <input type="text" name="name" value="${product.name}" required /><br><br>

  <label>Price:</label><br>
  <input type="number" step="0.01" name="price" value="${product.price}" required /><br><br>

  <label>Unit In Stock:</label><br>
  <input type="number" name="unitInStock" value="${product.unitInStock}" required /><br><br>

  <label>Image URL:</label><br>
  <input type="text" name="urlImage" value="${product.urlImage}" /><br><br>

  <button type="submit">Save</button>
  <a href="products">Back</a>
</form>
</body>
</html>
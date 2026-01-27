<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Product Form</title>

    <style>
        * {
            box-sizing: border-box;
            font-family: "Segoe UI", Arial, sans-serif;
        }

        body {
            background-color: #f4f6f8;
            padding: 40px;
        }

        .container {
            max-width: 600px;
            margin: auto;
            background: #fff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.1);
        }

        h2 {
            text-align: center;
            margin-bottom: 25px;
            color: #333;
        }

        .form-group {
            margin-bottom: 18px;
        }

        label {
            display: block;
            margin-bottom: 6px;
            font-weight: 600;
            color: #555;
        }

        input[type="text"],
        input[type="number"] {
            width: 100%;
            padding: 10px;
            border-radius: 6px;
            border: 1px solid #ccc;
            font-size: 15px;
        }

        input:focus {
            outline: none;
            border-color: #007bff;
        }

        .actions {
            display: flex;
            justify-content: space-between;
            margin-top: 25px;
        }

        button {
            padding: 10px 20px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 6px;
            font-size: 15px;
            cursor: pointer;
        }

        button:hover {
            background-color: #0056b3;
        }

        .cancel {
            text-decoration: none;
            padding: 10px 20px;
            background-color: #6c757d;
            color: white;
            border-radius: 6px;
        }

        .cancel:hover {
            background-color: #5a6268;
        }
    </style>
</head>

<body>

<div class="container">

    <h2>
        <c:if test="${product == null}">
             Thêm sản phẩm
        </c:if>
        <c:if test="${product != null}">
             Cập nhật sản phẩm
        </c:if>
    </h2>

    <form action="products" method="post">

        <!-- action -->
        <c:if test="${product != null}">
            <input type="hidden" name="action" value="update"/>
            <input type="hidden" name="id" value="${product.id}"/>
        </c:if>

        <c:if test="${product == null}">
            <input type="hidden" name="action" value="insert"/>
        </c:if>

        <div class="form-group">
            <label>Tên sản phẩm</label>
            <input type="text" name="name"
                   value="${product.name}" required>
        </div>

        <div class="form-group">
            <label>Giá</label>
            <input type="number" step="0.01" name="price"
                   value="${product.price}" required>
        </div>

        <div class="form-group">
            <label>Ảnh (URL)</label>
            <input type="text" name="url_image"
                   value="${product.url_image}">
        </div>

        <div class="actions">
            <button type="submit"> Lưu</button>
            <a href="products" class="cancel"> Hủy</a>
        </div>

    </form>

</div>

</body>
</html>

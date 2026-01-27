<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Danh sách sản phẩm</title>

    <style>
        * {
            box-sizing: border-box;
            font-family: "Segoe UI", Arial, sans-serif;
        }

        body {
            background-color: #f4f6f8;
            padding: 30px;
        }

        .container {
            max-width: 1000px;
            margin: auto;
            background: #ffffff;
            padding: 25px;
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
        }

        h2 {
            margin-bottom: 20px;
            color: #333;
        }

        .add-btn {
            display: inline-block;
            padding: 10px 16px;
            background-color: #28a745;
            color: #fff;
            text-decoration: none;
            border-radius: 6px;
            font-weight: 500;
            transition: background 0.2s;
        }

        .add-btn:hover {
            background-color: #218838;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        table thead {
            background-color: #007bff;
            color: white;
        }

        th, td {
            padding: 12px;
            text-align: center;
            border-bottom: 1px solid #ddd;
        }

        tr:hover {
            background-color: #f1f1f1;
        }

        img {
            border-radius: 6px;
            object-fit: cover;
        }

        .action a {
            margin: 0 5px;
            text-decoration: none;
            font-weight: 500;
        }

        .edit {
            color: #ffc107;
        }

        .delete {
            color: #dc3545;
        }

        .edit:hover {
            text-decoration: underline;
        }

        .delete:hover {
            text-decoration: underline;
        }
    </style>
</head>

<body>

<div class="container">

    <h2> Danh sách sản phẩm</h2>

    <a href="products?action=new" class="add-btn"> Thêm sản phẩm</a>

    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Tên</th>
            <th>Giá</th>
            <th>Ảnh</th>
            <th>Hành động</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${products}" var="p">
            <tr>
                <td>${p.id}</td>
                <td>${p.name}</td>
                <td>
                    <fmt:formatNumber value="${p.price}" type="currency"/>
                </td>
                <td>
                    <img src="${p.url_image}" width="80" height="60"/>
                </td>
                <td class="action">
                    <a class="edit" href="products?action=edit&id=${p.id}"> Sửa</a>

                    <a class="delete"
                       href="products?action=delete&id=${p.id}"
                       onclick="return confirm('Xóa sản phẩm này?')">
                         Xóa
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>

</body>
</html>

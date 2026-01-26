<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*" %>

<%
    String action = request.getParameter("action");
    String id = "";
    String name = "";
    String price = "";
    String url_image = "";

    if ("edit".equals(action)) {
        int editId = Integer.parseInt(request.getParameter("id"));
        List<Map<String, Object>> products =
                (List<Map<String, Object>>) session.getAttribute("products");

        for (Map<String, Object> p : products) {
            if ((int) p.get("id") == editId) {
                id = p.get("id").toString();
                name = p.get("name").toString();
                price = p.get("price").toString();
                url_image = p.get("url_image").toString();
                break;
            }
        }
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Form sản phẩm</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f6f8;
            padding: 30px;
        }

        .form-container {
            background: white;
            padding: 25px;
            border-radius: 8px;
            max-width: 500px;
            margin: auto;
            box-shadow: 0 4px 10px rgba(0,0,0,0.1);
        }

        h2 {
            margin-bottom: 20px;
        }

        label {
            font-weight: bold;
        }

        input {
            width: 100%;
            padding: 8px;
            margin: 8px 0 15px;
        }

        button {
            padding: 8px 15px;
            border: none;
            border-radius: 5px;
            background: #007bff;
            color: white;
            cursor: pointer;
        }

        a {
            margin-left: 10px;
            text-decoration: none;
            color: #555;
        }
    </style>
</head>
<body>

<div class="form-container">
    <h2><%= "edit".equals(action) ? "Cập nhật sản phẩm" : "Thêm sản phẩm" %></h2>

    <form method="post" action="index.jsp?action=<%= "edit".equals(action) ? "update" : "insert" %>">
        <input type="hidden" name="id" value="<%= id %>">

        <label>Tên sản phẩm</label>
        <input type="text" name="name" value="<%= name %>" required>

        <label>Giá</label>
        <input type="number" name="price" value="<%= price %>" required>

        <label>URL ảnh</label>
        <input type="text" name="url_image" value="<%= url_image %>">

        <button type="submit">Lưu</button>
        <a href="index.jsp">Hủy</a>
    </form>
</div>

</body>
</html>

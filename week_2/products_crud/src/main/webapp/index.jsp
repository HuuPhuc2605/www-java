<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*" %>

<%
    List<Map<String, Object>> products =
            (List<Map<String, Object>>) session.getAttribute("products");

    if (products == null) {
        products = new ArrayList<>();

        Map<String, Object> p1 = new HashMap<>();
        p1.put("id", 1);
        p1.put("name", "Laptop Dell XPS");
        p1.put("price", 25000000);
        p1.put("url_image", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSmhTv9ZEs6gbgDdD_W02m4sNZud6o8aAjIYA&s");

        Map<String, Object> p2 = new HashMap<>();
        p2.put("id", 2);
        p2.put("name", "iPhone 15 Pro");
        p2.put("price", 28000000);
        p2.put("url_image", "https://amstudio.vn/wp-content/uploads/2024/03/NAM02969-scaled.jpg");

        products.add(p1);
        products.add(p2);

        session.setAttribute("products", products);
        session.setAttribute("nextId", 3);
    }

    String action = request.getParameter("action");

    if ("insert".equals(action)) {
        int nextId = (int) session.getAttribute("nextId");

        Map<String, Object> p = new HashMap<>();
        p.put("id", nextId);
        p.put("name", request.getParameter("name"));
        p.put("price", Double.parseDouble(request.getParameter("price")));
        p.put("url_image", request.getParameter("url_image"));

        products.add(p);
        session.setAttribute("nextId", nextId + 1);
        response.sendRedirect("index.jsp");
        return;
    }

    if ("delete".equals(action)) {
        int id = Integer.parseInt(request.getParameter("id"));
        products.removeIf(p -> (int) p.get("id") == id);
        response.sendRedirect("index.jsp");
        return;
    }

    if ("update".equals(action)) {
        int id = Integer.parseInt(request.getParameter("id"));
        for (Map<String, Object> p : products) {
            if ((int) p.get("id") == id) {
                p.put("name", request.getParameter("name"));
                p.put("price", Double.parseDouble(request.getParameter("price")));
                p.put("url_image", request.getParameter("url_image"));
                break;
            }
        }
        response.sendRedirect("index.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Danh sách sản phẩm</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f6f8;
            padding: 30px;
        }

        .container {
            background: white;
            padding: 25px;
            border-radius: 8px;
            max-width: 1000px;
            margin: auto;
            box-shadow: 0 4px 10px rgba(0,0,0,0.1);
        }

        h2 {
            margin-bottom: 15px;
        }

        .add-btn {
            display: inline-block;
            margin-bottom: 15px;
            padding: 8px 14px;
            background: #007bff;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th {
            background: #007bff;
            color: white;
            padding: 10px;
        }

        td {
            padding: 10px;
            text-align: center;
            border-bottom: 1px solid #ddd;
        }

        img {
            width: 80px;
            border-radius: 5px;
        }

        .action a {
            margin: 0 5px;
            text-decoration: none;
            color: #007bff;
        }

        .action a.delete {
            color: red;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>Danh sách sản phẩm</h2>
    <a class="add-btn" href="product-form.jsp?action=new">+ Thêm mới</a>

    <table>
        <tr>
            <th>ID</th>
            <th>Tên</th>
            <th>Giá</th>
            <th>Ảnh</th>
            <th>Hành động</th>
        </tr>

        <%
            for (Map<String, Object> p : products) {
        %>
        <tr>
            <td><%= p.get("id") %></td>
            <td><%= p.get("name") %></td>
            <td><%= p.get("price") %></td>
            <td><img src="<%= p.get("url_image") %>"></td>
            <td class="action">
                <a href="product-form.jsp?action=edit&id=<%= p.get("id") %>">Sửa</a>
                <a class="delete" href="index.jsp?action=delete&id=<%= p.get("id") %>"
                   onclick="return confirm('Xóa sản phẩm này?')">Xóa</a>
            </td>
        </tr>
        <%
            }
        %>
    </table>
</div>

</body>
</html>

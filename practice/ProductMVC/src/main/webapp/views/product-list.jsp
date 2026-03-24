<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*, iuh.fit.se.productmvc.model.Product" %>

<h2>Product List</h2>

<a href="products?action=new">Add New</a>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Stock</th>
        <th>Image</th>
        <th>Action</th>
    </tr>

    <%
        List<Product> list = (List<Product>) request.getAttribute("productList");

        for (Product p : list) {
    %>
    <tr>
        <td><%=p.getId()%></td>
        <td><%=p.getName()%></td>
        <td><%=p.getPrice()%></td>
        <td><%=p.getUnitInStock()%></td>
        <td>
            <img src="<%=p.getUrlImage()%>" width="80" height="80">
        </td>
        <td>
            <a href="products?action=edit&id=<%=p.getId()%>">Edit</a>
            <a href="products?action=delete&id=<%=p.getId()%>">Delete</a>
        </td>
    </tr>
    <% } %>
</table>
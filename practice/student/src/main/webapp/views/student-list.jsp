<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, iuh.fit.se.student.model.Student" %>
<script src="https://cdn.tailwindcss.com"></script>
<!DOCTYPE html>
<html>
<head>
    <title>Giao diện quản lý học sinh</title>
</head>
<body class="gap-10  rounded">

<h2>Danh sách học sinh</h2>
<a class="bg-blue-500 p-4 border-2 " href="students?action=new">Add new</a>

<table class="bg-orange-300 p-4 border-4 border-gray-300">
    <tr>
        <th>ID</th>
        <th>Tên</th>

        <th>Tuổi</th>
        <th>Giới tính</th>
        <th>Ảnh</th>
        <th>Action</th>

    </tr>
    <%List<Student> list = (List<Student>) request.getAttribute("studentList");
    for (Student student: list){%>
    <tr>
        <td><%=student.getId()%></td>
        <td><%=student.getName()%></td>

        <td><%=student.getAge()%></td>

        <td><%=student.isGender() ? "Nam": "Nữ"%></td>
        <td>
            <img src="<%=student.getImage()%>" alt="image" width="80" height="80"></td>
        <td><a href="students?action=edit&id=<%=student.getId()%>">Edit</a>
            <a href="students?action=delete&id=<%=student.getId()%>">Delete</a></td>
    </tr>
    <%}%>
</table>

</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: lehuu
  Date: 3/22/2026
  Time: 5:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script src="https://cdn.tailwindcss.com"></script>

<head>
    <title>Student Form</title>
</head>
<body>
<h2>${student == null ? "Add Student": "Edit Student"}</h2>
<form action="students" method="post">
    <input type="hidden" name="id" value="${student.id}"/>
    <label for="">Name: </label><br>
    <input type="text" name="name" value="${student.name}" required/><br><br>
    <label for="">Age: </label><br>
    <input type="number" name="age" value="${student.age}" required/><br><br>
    <label>Gender:</label><br>
    <input type="radio" name="gender" value="true"
    ${student != null && student.gender ? "checked" : ""}/> Nam

    <input type="radio" name="gender" value="false"
    ${student != null && !student.gender ? "checked" : ""}/> Nữ
    <br><br>
    <label for="">Image: </label><br>
    <input type="text" name="image" value="${student.image}" required/><br><br>
    <button type="submit">Save</button>
    <a href="students">back</a>

</form>

</body>
</html>

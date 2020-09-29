<%--
  Created by IntelliJ IDEA.
  User: banshen
  Date: 2020/9/21
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加部门</title>
</head>
<body>
<%@include file="header.jsp"%>
<form action="<%=application.getContextPath()%>/dept?op=addDept" method="post">
    <input type="text" name="deptno" placeholder="请输入部门编号"></br>
    <input type="text" name="dname" placeholder="请输入部门名称"></br>
    <input type="text" name="loc" placeholder="请输入部门地点"></br>
    <input type="submit" value="添加部门">

</form>
</body>
</html>

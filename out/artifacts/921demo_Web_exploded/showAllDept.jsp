<%@ page import="com.csi.domin.Dept" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: banshen
  Date: 2020/9/21
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>显示所有部门</title>
    <%
       List<Dept> all = (List<Dept>) request.getAttribute("all");
    %>
    <style>
        table{
            margin: auto;
            text-align: center;
            border-collapse:collapse;
        }
        table,th,td{
            border: 1px solid black;
        }
    </style>
</head>
<body>
<%@include file="header.jsp"%>
<table>
    <tr>
        <th>编号</th>
        <th>名称</th>
        <th>地点</th>
        <th>操作</th>
    </tr>
    <%
        for (Dept d:all){
    %>
    <tr>
        <td><%=d.getDeptno()%></td>
        <td><%=d.getDname()%></td>
        <td><%=d.getLoc()%></td>
        <td>
            <a href="<%=application.getContextPath()%>/dept?op=findById&deptno=<%=d.getDeptno()%>"><button>编辑<button><a>
                <a href="<%=application.getContextPath()%>/dept?op=remove&deptno=<%=d.getDeptno()%>"><button>删除<button><a>
        <td>
    </tr>
    <%
        }
    %>

</table>
</body>
</html>

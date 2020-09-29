<%@ page import="com.csi.domin.Dept" %>
<%@ page import="java.util.List" %>
<%@page import="com.csi.domin.Emp" %>
<%--
  Created by IntelliJ IDEA.
  User: banshen
  Date: 2020/9/22
  Time: 23:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%
        //接收后台传递过来的信息
        //查询所有部门
        List<Dept> deptAll = (List<Dept>)request.getAttribute("deptAll");
        //查询所有领导
        List<Emp> managerAll = (List<Emp>) request.getAttribute("managerAll");
    %>
</head>
<body>
<%@include file="header.jsp"%>
<form action="<%=application.getContextPath()%>/emp?op=addEmp" method="post">
<input type="text" name="empno" placeholder="请输入编号"></br>
<input type="text" name="empno" placeholder="请输入姓名"></br>
    职位:
    <select name="job">
        <option value="MANAGER">MANAGER</option>
        <option value="PRESIDENT">PRESIDENT</option>
        <option value="ANALYST">ANALYST</option>
        <option value="ANALYST">CLERK</option>
        <option value="SALESMAN">SALESMAN</option>
    </select>
    </br>
    直系领导:
    <select name="mgr">
        <%
            for (Emp e :managerAll){
        %>
        <option value="<%=e.getEmpno()%>"><%=e.getEname()%></option>
        <%
            }
        %>
    </select>
</br>
<input type="date" name="hiredate" placeholder="请输入入职日期"></br>
    <input type="number" name="sal" placeholder="请输入薪资"></br>
    <input type="number" name="comm" placeholder="请输入提成"></br>
    请选择部门:
    <select name="deptno">
        <%
        for (Dept d:deptAll){
        %>
        <option value="<%=d.getDeptno()%>"><%=d.getDname()%></option>
        <%
            }
        %>
    </select>
</br>
    <input type="submit" value="添加员工">

</form>
</body>
</html>

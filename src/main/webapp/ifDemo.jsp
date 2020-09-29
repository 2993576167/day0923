<%@ page import="com.csi.dao.EmpDao" %>
<%@ page import="com.csi.dao.impl.EmpDaoImpl" %>
<%@ page import="com.csi.domin.Emp" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/24
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    EmpDao dao=new EmpDaoImpl();
    Emp emp=dao.selectByIdAndName(7788,"SMITH");
    session.setAttribute("emp",emp);
%>
<c:if test="$emp.ename ne null}">欢迎访问此网站</c:if>

</body>
</html>

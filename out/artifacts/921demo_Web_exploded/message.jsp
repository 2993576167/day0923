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
    <title>显示结果信息</title>
</head>
<body>
<%@include file="header.jsp"%>
<%--获取请求参数数据进行显示--%>
<%=request.getAttribute("info")%>
</body>
</html>

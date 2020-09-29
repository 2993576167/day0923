<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div style="margin: auto; text-align: center">
    <a href="<%=application.getContextPath()%>/addDept.jsp">添加类别</a>
    <a href="#">查询类别</a>
    <a href="<%=application.getContextPath()%>/dept?op=findAll">显示所有类别</a>
    <%--点击添加员工跳转到一个servlet帮助我们查询所有的员工领导以及所有部门信息显示到jsp界面
    用于客户进行选择--%>
    <a href="<%=application.getContextPath()%>emp?op=addFind">添加员工信息</a>
    <a href="<%=application.getContextPath()%>emp?op=findAll">显示所有员工信息 </a>
</div>
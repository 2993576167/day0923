package com.csi.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*   <servlet>
        <servlet-name>ajaxDemoServlet</servlet-name>
        <servlet-class>com.csi.servlet.AjaxDemoSerlet</servlet-class>
    </servlet>

    <servlet-mapping>
        <servlet-name>ajaxDemoServlet</servlet-name>
        <url-pattern>/ajax</url-pattern>
    </servlet-mapping>*/


@WebServlet(name = "ajaxDemoServlet",urlPatterns = "com.csi.servlet.AjaxDemoSerlet")
public class AjaxDemoSerlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("您使用的是get请求");
        //处理编码方式
        String encoding = this.getServletContext().getInitParameter("encoding");
        req.setCharacterEncoding(encoding);
        req.setCharacterEncoding(encoding);
        //接收用户信息
        String info = req.getParameter("info");
        System.out.println("接收的info是:"+info);
        //返回响应信息给客户端
        PrintWriter out=resp.getWriter();
        //输出响应
        out.write("你个损塞er");
        out.flush();


    }
}

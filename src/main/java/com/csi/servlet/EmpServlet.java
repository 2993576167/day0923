package com.csi.servlet;

import com.csi.DBUtil.DateFormat;
import com.csi.domin.Dept;
import com.csi.domin.Emp;
import com.csi.service.DeptService;
import com.csi.service.EmpService;
import com.csi.service.Impl.DeptServiceImpl;
import com.csi.service.Impl.EmpServiceImpl;
import com.sun.net.httpserver.HttpServer;
import jdk.nashorn.internal.ir.CallNode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
@WebServlet(name = "empServlet",urlPatterns = "com.csi.servlet.EmpServlet")
public class EmpServlet extends HttpServlet {
    //创建业务层对象
    private DeptService deptService;
    private EmpService empService;
    private Emp emp;

    public EmpServlet(){
        this.deptService = new DeptServiceImpl();
        this.empService = new EmpServiceImpl();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        doGet(req,resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //设置编码方式
        String encoding = this.getServletContext().getInitParameter("encoding");
        req.setCharacterEncoding(encoding);
        resp.setCharacterEncoding(encoding);
        //接收op参数值
        String op = req.getParameter("op");
        //判断op数值内容
        if ("addFind".equals(op)){
            try {
                this.addFind(req,resp);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else if ("addEmp".equals(op)){
            try {
                this.addEmp(req,resp);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else if ("findAll".equals(op)){
            try {
                this.findAll(req,resp);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    protected void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        List<Emp> all = this.empService.findAll();
        //将信息存储到请求属性中

        //将集合存储到请求属性中
        req.setAttribute("all",all);
        //请求转发跳转界面
        req.getRequestDispatcher("showAllEmp.jsp").forward(req,resp);
    }
    protected void addEmp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
    //接收用户传递过来的用户信息
        String empno = req.getParameter("empno");
        String ename = req.getParameter("ename");
        String job = req.getParameter("job");
        String mgr = req.getParameter("mgr");
        String hiredate = req.getParameter("hiredate");
        String sal = req.getParameter("sal");
        String comm = req.getParameter("comm");
        String deptno = req.getParameter("deptno");
        Dept d = new Dept();
        d.setDeptno(Integer.valueOf(deptno));
        //调用添加员工信息的方法
        String info = this.empService.addEmp(new Emp(
                Integer.valueOf(empno),
                ename,
                job,
                Integer.valueOf(mgr),
                DateFormat.stringToDate(hiredate),
                Double.valueOf(sal),
                Double.valueOf(comm),
                d
        ));
        req.setAttribute("info",info);
        //利用请求转发跳转界面
        req.getRequestDispatcher("message.jsp").forward(req,resp);
    }
    protected void addFind(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
      //查询所有部门
        List<Dept> deptAll = this.deptService.findAll();
        //查询所有领导
        List<Emp> managerAll = this.empService.findAllManager();
        //将信息存储到请求属性中
        req.setAttribute("deptAll",deptAll);
        req.setAttribute("managerAll",managerAll);
        //将对象存储到请求属性中


        //请求转发跳转页面
        req.getRequestDispatcher("addEmp.jsp").forward(req,resp);
       // req.getRequestDispatcher("dept.jsp").forward(req,resp);
    }
}

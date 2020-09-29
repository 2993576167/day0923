package com.csi.servlet;

import com.csi.service.DeptService;
import com.csi.service.Impl.DeptServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
@WebServlet(name = "deptServlet",urlPatterns = "com.csi.servlet.DeptServlet")
public class DeptServlet extends HttpServlet {
    //创建业务层
    private DeptService service;
    public DeptServlet(){
        this.service = new DeptServiceImpl();
    }

}

package com.csi.dao;

import com.csi.DBUtil.Page;
import com.csi.domin.Emp;

import java.sql.SQLException;
import java.util.List;

public interface EmpDao {
    //增加员工的方法
    int insert(Emp emp) throws SQLException;
    //删除员工的方法

    //修改员工的方法

    //查询所有员工信息
    List<Emp> selectAll() throws SQLException;
    //改一个 将id当成身份证号 查询数据
    Emp selectByIdAndName(int empno,String ename) throws SQLException;
    //查询所有部门经理
    List<Emp> selectManager() throws SQLException;
    //根据员工姓名查询

    //根据员工id查询

    //根据员工姓名模糊查询

    //根据入职日期范围查询

    //根据部门查询员工
    //分页查询所有员工信息
    Page<Emp>selectByPage(int pageNum,int pageSize);
}

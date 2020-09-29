package com.csi.service;

import com.csi.domin.Emp;

import java.sql.SQLException;
import java.util.List;

public interface EmpService {
    //新增员工
    String addEmp(Emp emp) throws SQLException;
    //查询所有员工
    List<Emp> findAll() throws SQLException;
    //查询所有领导
    List<Emp> findAllManager() throws SQLException;
}

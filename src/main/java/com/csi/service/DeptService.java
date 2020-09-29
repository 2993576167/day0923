package com.csi.service;

import com.csi.domin.Dept;


import java.sql.SQLException;
import java.util.List;

public interface DeptService {
    //新增部门
    String addDept(String id, String name,String loc) throws SQLException;
    //删除部门
    String removeDept(String id) throws SQLException;
    //修改部门
    String changeDept(String id,String name,String loc) throws SQLException;
    //查询所有部门
    List<Dept> findAll() throws SQLException;
    //根据id查询部门
    Dept findById(String id) throws SQLException;
}

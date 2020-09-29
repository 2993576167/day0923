package com.csi.dao;

import com.csi.domin.Dept;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public interface DeptDao {
    //插入部门的方法
    int insert(Dept dept) throws SQLException;
    //删除部门的方法 id
    int delete(int id) throws SQLException;
    //修改部门的方法
    int update(Dept dept) throws SQLException;
    //查询所有部门
    List<Dept> selectAll() throws SQLException;
    //根据id查询部门信息
    Dept selectById(int id) throws SQLException;
    //根据名称查询部门信息
    Dept selectByName(String name) throws SQLException;
    //模糊查询部门信息的方法
    List<Dept> selectByLikeName(String name) throws SQLException;
}

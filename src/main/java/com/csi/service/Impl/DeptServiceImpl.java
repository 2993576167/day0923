package com.csi.service.Impl;

import com.csi.dao.DeptDao;
import com.csi.dao.impl.DeptDapImpl;
import com.csi.domin.Dept;
import com.csi.service.DeptService;


import java.sql.SQLException;
import java.util.List;

public class DeptServiceImpl implements DeptService {
    //创建一个Dao实例化对选哪个
    private DeptDao dao;
    public DeptServiceImpl(){
        this.dao=new DeptDapImpl();
    }
    @Override
    public String addDept(String id, String name, String loc) throws SQLException {
        int deptno = Integer.valueOf(id);
        if (this.dao.selectById(deptno)!=null) return "对不起 此编号已存在 无法进行注册";
        if (this.dao.selectByName(name)!= null)return "对不起 此部门已存在 无法进行注册";
        return this.dao.insert(new Dept(deptno,name,loc))>0?"添加成功":"添加失败";
//        return "对不起 编号输入格式不正确";
    }

    @Override
    public String removeDept(String id) throws SQLException {

        return this.dao.delete(Integer.valueOf(id))>0?"删除成功":"删除失败";
    }

    @Override
    public String changeDept(String id, String name, String loc) throws SQLException {
        return this.dao.update(new Dept(Integer.valueOf(id),name,loc))>0?"更新成功":"更新是被";
    }

    @Override
    public List<Dept> findAll() throws SQLException {
        return this.dao.selectAll();
    }

    @Override
    public Dept findById(String id) throws SQLException {
        return this.dao.selectById(Integer.valueOf(id));  }
}

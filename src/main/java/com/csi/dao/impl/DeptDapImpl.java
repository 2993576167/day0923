package com.csi.dao.impl;

import com.csi.DBUtil.DBUtil;
import com.csi.dao.DeptDao;
import com.csi.domin.Dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeptDapImpl implements DeptDao {


    @Override
    public int insert(Dept dept) throws SQLException {
        //调用DBUtil获取连接对象
        Connection conn = DBUtil.getConnection();
        //获取预编译对象

        PreparedStatement pstmt = DBUtil.getPstmt(conn,"inster into dept(deptno,dname,loc) values(?,?,?)",
                dept.getDeptno(),dept.getDname(),dept.getLoc());
        //执行插入操作
        int i = DBUtil.update(pstmt);
        //关闭资源
        DBUtil.close(conn,pstmt,null);
        return i;
    }

    @Override
    public int delete(int id) throws SQLException {
        //调用DBUtil获取连接对象
        Connection conn = DBUtil.getConnection();
        //获取预编译对象
        PreparedStatement pstmt = DBUtil.getPstmt(conn,"delete from dept where deptno = ?",id);
        //执行删除操作
        int i = DBUtil.update(pstmt);
        //关闭资源
        DBUtil.close(conn,pstmt,null);
        return i;
    }

    @Override
    public int update(Dept dept) throws SQLException {
        //调用DBUtil获取连接对象
        Connection conn = DBUtil.getConnection();
        //获取预编译对象
        PreparedStatement pstmt = DBUtil.getPstmt(conn,"update dept set dname =?,loc=?where deptno=?",
        dept.getDname(),dept.getLoc(),dept.getDeptno());
        //执行更新操作
        int i = DBUtil.update(pstmt);
        //关闭资源
        DBUtil.close(conn,pstmt,null);
        return i;
    }

    @Override
    public List<Dept> selectAll() throws SQLException {
        //调用DBUtil获取连接对象
        Connection conn = DBUtil.getConnection();
        //获取预编译对象
        PreparedStatement pstmt = DBUtil.getPstmt(conn, "select * from dept");
        //执行查询语句
        ResultSet rs = DBUtil.query(pstmt);
        //准备集合存放数据
        List<Dept> list = new ArrayList<Dept>();

        while (rs.next()) {
            //向list中存放数据
            list.add(new Dept(rs.getInt("deptno"),
                    rs.getString("dname"),
                    rs.getString("loc")));
        }
        return list;
    }
    @Override
    public Dept selectById(int id) throws SQLException {
        //调用DBUtil获取连接对象
        Connection conn = DBUtil.getConnection();
        //获取预编译对象
        PreparedStatement pstmt = DBUtil.getPstmt(conn,"select * from dept where deptno =?",id);
        //执行查询语句
        ResultSet rs = DBUtil.query(pstmt);
        if (rs.next()){
            //向list中存放数据
            return new Dept(rs.getInt("deptno"),
                    rs.getString("dname"),
                    rs.getString("loc"));
        }
        return null;
    }

    @Override
    public Dept selectByName(String name) throws SQLException {
        //调用DBUtil获取连接对象
        Connection conn = DBUtil.getConnection();
        //获取预编译对象
        PreparedStatement pstmt=DBUtil.getPstmt(conn,"select* from dept where dname =?",name);
        //执行查询语句
        ResultSet rs = DBUtil.query(pstmt);
        if (rs.next()){
            //想list中存放数据
            return new Dept(rs.getInt("deptno"),
                    rs.getString("dname"),
                    rs.getString("loc"));
        }
        return null;
    }

    @Override
    public List<Dept> selectByLikeName(String name) throws SQLException {
        //调用DBUtil获取连接对象
        Connection conn = DBUtil.getConnection();
        //获取预编译对象
        PreparedStatement pstmt = DBUtil.getPstmt(conn,"select * from dept where dname like ?",
        "%"+name+"%");
        //执行查询语句
        ResultSet rs = DBUtil.query(pstmt);
        //准备集合存放数据
        List<Dept> list = new ArrayList<Dept>();
        while (rs.next()){
            //向list中存放数据
            List<Dept> list1 = new ArrayList<Dept>();
            while (rs.next()){
                //想list中存放数据
                list.add(new Dept(rs.getInt("deptno"),
                        rs.getString("dname"),
                        rs.getString("loc")));
            }
        }


        return list;
    }
}

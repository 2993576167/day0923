package com.csi.dao.impl;

import com.csi.DBUtil.DBUtil;
import com.csi.DBUtil.Page;
import com.csi.dao.EmpDao;
import com.csi.domin.Dept;
import com.csi.domin.Emp;
import com.sun.rowset.CachedRowSetImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDaoImpl implements EmpDao {
    @Override
    public int insert(Emp emp) {
        //获取连接对象
        Connection conn = DBUtil.getConnection();
        //获取连接数据库预编译对象
        PreparedStatement pstmt = DBUtil.getPstmt(conn,"insert into emp(empno,ename,job,mgr,hiredate,sal,comm,deptno)"+
                "values(?,?,?,?,?,?,?,?)",emp.getEmpno(),
                emp.getEname(),emp.getJob(),emp.getMgr(),emp.getHiredate(),
                emp.getSal(),emp.getComm(),emp.getDept().getDeptno());
        int i =DBUtil.update(pstmt);
        //关闭资源
        DBUtil.close(conn,pstmt,null);
        return i;
    }

    @Override
    public List<Emp> selectAll() throws SQLException {
        //获取连接对象
        Connection conn = DBUtil.getConnection();
        //获取数据库操作对象
        PreparedStatement pstmt = DBUtil.getPstmt(conn,"select * from emp e,dept d where e.deptno = d.deptno");
        //执行sql语句
        ResultSet rs = DBUtil.query(pstmt);
        //准备一个集合存储数据
        List<Emp> list=new ArrayList<Emp>();
        while (rs.next()){
            list.add(new Emp(rs.getInt("empno"),
                    rs.getString("ename"),
                    rs.getString("job"),
                    rs.getInt("mgr"),
                    rs.getDate("hiredate"),
                    rs.getDouble("sal"),
                    this.format(rs.getObject("comm")),
                    new Dept(rs.getInt("deptno"),
                            rs.getString("dname"),
                            rs.getString("loc"))));
        }

        return list;
    }
    //藏剑一个私有方法进行double转化
    private Double format(Object o){
        if (o!=null){
            return Double.valueOf(o.toString());
        }else{
            return null;
        }
    }

    @Override
    public Emp selectByIdAndName(int empno, String ename) throws SQLException {
        //获取连接对象
        Connection conn = DBUtil.getConnection();
        //获取数据库操作对象
        PreparedStatement pstmt = DBUtil.getPstmt(conn,"select * from emp e.dept d where empno=? and ename=?"+
                "and e.deptno = d.deptno",
                empno,ename);
        //执行sql语句
        ResultSet rs = DBUtil.query(pstmt);

        if (rs.next()){
            return new Emp(rs.getInt("empno"),
                    rs.getString("ename"),
                    rs.getString("job"),
                    rs.getInt("mgr"),
                    rs.getDate("hiredate"),
                    rs.getDouble("sal"),
                    this.format(rs.getObject("comm")),
                    new Dept(rs.getInt("deptno"),
                            rs.getString("dname"),
                            rs.getString("loc")));
        }
        return null;
    }

    @Override
    public List<Emp> selectManager() throws SQLException {
        //获取连接对象
        Connection conn = DBUtil.getConnection();
        //获取数据库操作对象
        PreparedStatement pstmt = DBUtil.getPstmt(conn,"select * from emp e,dept d where"+
                "empno in(select distinct mgr from emp where mgr is not null)"+
                "and e.deptno = d.deptno");
        //执行sql语句
        ResultSet rs = DBUtil.query(pstmt);
        //准备一个集合存储数据
        List<Emp> list=new ArrayList<Emp>();

        while (rs.next()){
            list.add(new Emp(rs.getInt("empno"),
                    rs.getString("ename"),
                    rs.getString("job"),
                    rs.getInt("mgr"),
                    rs.getDate("hiredate"),
                    rs.getDouble("sal"),
                    this.format(rs.getObject("comm")),
                    new Dept(rs.getInt("deptno"),
                            rs.getString("dname"),
                            rs.getString("loc"))));
        }

        return list;
    }
    @Override

    public Page<Emp> selectByPage(int pageNum, int pageSize) {
            //创建一个page对象
      //  Page<Object> objectPage = new Page< >(pageNum, pageSize);
        return null;

    }

}

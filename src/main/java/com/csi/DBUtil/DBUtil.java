package com.csi.DBUtil;


import java.sql.*;

public class DBUtil {
	private static final String url="jdbc:mysql://127.0.0.1:3306/0921?useUnicode=true&characterEncoding=utf-8&useSSL=true&serverTimezone=Asia/Shanghai";
	//主机名,端口号,数据库名
	private static final String user="root";
	private static final String password="root";
	private static final String driver="com.mysql.cj.jdbc.Driver";
	static {//静态代码块中加载驱动
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("jdbc驱动加载失败！！！！请查看");
		}
	}
	//创建一个方法
	public static Connection getConnection(){
		try {
			return DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("获取连接失败，请查看url或者user以及password");
			return null;
		}
	}
	//创建一个获取PreparedStatment方法
	public static PreparedStatement getPstmt(Connection conn,String sql,Object...params){
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			for (int i=0;i<params.length;i++){
				pstmt.setObject(i+1,params[i]);
			}
			return pstmt;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("获取预编译对象失败");
			return null;
		}
	}
	//创建一个方法执行增删改方法
	public static int update(PreparedStatement pstmt){
		try {
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	//创建一个方法执行查询方法返回结果集
	public static ResultSet query(PreparedStatement pstmt){
		try {
			return pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	//创建一个进行资源关闭的方法
	public static void close(Connection conn,PreparedStatement pstmt,ResultSet rs){
		try {
			if(rs!=null && !rs.isClosed())  rs.close();
			if(pstmt!=null && !pstmt.isClosed())  pstmt.close();
			if(conn!=null && !conn.isClosed())  conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("资源关闭失败");
		}
	}
}


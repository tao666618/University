package com.Exam.sql;

import java.security.*;
import java.sql.*;


/**
 * 连接MySQL数据库，并执行查询和更新    -tao
 */
public class GetConn {
	public Connection conn = null;
	public ResultSet rs = null;
	public Statement stmt = null;
	public GetConn() { // 构造方法
	}
	//

	/**
	 *
	 * @return 获取数据库连接方法 Connection  ——tao
	 */
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn = DriverManager
					.getConnection(
							"jdbc:mysql://localhost:3306/db_Exam?useUnicode=true&characterEncoding=UTF-8",
							"root", "123456");
		} catch (SQLException e) {
			e.printStackTrace();
		}// 异常处理
		return conn;// 按发法要求返回个Connection对象
	}
	/*
	 * 功能：执行查询语句
	 */

	/**
	 *
	 * @param sql 执行sql
	 * @return 查询结果 ResultSet     ——tao
	 */
	public ResultSet executeQuery(String sql) {
		try {
			conn = getConnection();
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(sql);
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
		return rs;
	}
	/*
	 * 功能:执行更新操作
	 */

	/**
	 *
	 * @param sql 要执行的更新语句
	 * @return 操作影响的行数  ——tao
	 */
	public int executeUpdate(String sql) {
		int result = 0;
		try {
			conn = getConnection();
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			result = stmt.executeUpdate(sql);
		} catch (SQLException ex) {
			result = 0;
		}
		try {
			stmt.close();
		} catch (SQLException ex1) {
		}
		return result;
	}
	/*
	 * 功能:关闭数据库的连接
	 */

	/**
	 * 关闭数据库的连接、语句和结果集对象，释放资源。 -tao
	 */
	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}
}

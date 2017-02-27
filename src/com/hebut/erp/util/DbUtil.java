package com.hebut.erp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUtil {
	
	public static Connection getConn() {		
		Connection conn = null;
		//���������ļ��������ݿ�����
		JdbcConfig jdbc=null;
		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			conn = DriverManager.getConnection(
//					"jdbc:mysql://localhost:3306/company", "root", "admin");
			jdbc=DbConfig.getInstance().getConfig();
			String driver=jdbc.getDriver();
			String url=jdbc.getUrl();
			String name=jdbc.getName();
			String pass=jdbc.getPass();
			Class.forName(driver);
			conn=DriverManager.getConnection(url,name,pass);
			
		} catch (ClassNotFoundException e) {
			System.out.println("class not found");
		} catch (SQLException e) {
			System.out.println("sql exception");
		}
//		
		//����������ӳ�����ȡ���ݿ�����
		//�����׶β�ʹ��,Ҫ��������ع���,��������ʹ�������ļ����й���
		
//		try {
//			Context ctx=new InitialContext();
//			DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/erp");
//			//�����ӳ��л�ȡConnection
//			conn=ds.getConnection();
//		} catch (NamingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return conn;
	}

	public static void close(ResultSet rs) {
		if (rs != null) {

			try {
				rs.close();
			} catch (SQLException e) {
				System.out.println("ResultSet close exception");
			}
		}

	}

	public static void close(Connection conn) {

		if (conn != null) {

			try {
				//�������·ŵ���Connection���ӳ���
				conn.close();
			} catch (SQLException e) {
				System.out.println("Connection close exception");
			}
		}
	}

	public static void close(Statement stmt) {
		if (stmt != null) {

			try {
				stmt.close();
			} catch (SQLException e) {
				System.out.println("Statement close exception");
			}
		}

	}

	public static void close(PreparedStatement pstmt) {
		if (pstmt != null) {

			try {
				pstmt.close();
			} catch (SQLException e) {
				System.out.println("preparedStatement close exception");
			}
		}

	}

}

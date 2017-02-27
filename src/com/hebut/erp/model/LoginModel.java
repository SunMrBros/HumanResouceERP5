package com.hebut.erp.model;
import com.hebut.erp.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginModel {
	public static int checkUser(String user,String pass){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int id=0;
		String sql="select id from admin where name=?and password=?";
		Connection conn=DbUtil.getConn();
		
		try {
			pstmt=conn.prepareStatement(sql);// 
			pstmt.setString(1, user);
			pstmt.setString(2, pass);
			rs=pstmt.executeQuery();
			if(rs.next()){
				id=rs.getInt("id");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}finally{
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			DbUtil.close(conn);	
			
			}	
		return id;
		}
}

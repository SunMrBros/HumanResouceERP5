package com.hebut.erp.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import com.hebut.erp.pojo.Admin;


public class ChangePass {

	public static boolean changePass(int id,String password) {
		Connection conn=DbUtil.getConn();
		Statement st=null;
		int i=0;
		try{
			st=conn.createStatement();
			String sql="update admin set password='"+password+"' where id="+id;
			 i=st.executeUpdate(sql);
			
		}catch(SQLException e){
			
			e.printStackTrace();
			return false;
		}finally{
			
			DbUtil.close(st);
			DbUtil.close(conn);
		}
		if(i==1){
			return true;
		}else{
			return false;
		}
		
	}

	public static boolean addMgr(Admin admin) {
		Connection conn=DbUtil.getConn();
		PreparedStatement st=null;
		int i=0;
		try{
			String sql="insert into admin (name,password,email)values(?,?,?)";
			st=conn.prepareStatement(sql);
			st.setString(1, admin.getName());
			st.setString(2, admin.getPassword());
			st.setString(3, admin.getEmail());
			 i=st.executeUpdate();
			System.out.println("admin succ");
		}catch(SQLException e){
			System.out.println("admin wrong");
			e.printStackTrace();
			return false;
		}finally{
			
			DbUtil.close(st);
			DbUtil.close(conn);
		}
		if(i==1){
			return true;
		}else{
			return false;
		}
		
	}

}

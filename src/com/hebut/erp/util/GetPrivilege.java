package com.hebut.erp.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetPrivilege {
	public int getPrivilege(int empno){
		
		int pri=0;
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
		try{
			conn=DbUtil.getConn();
			st=conn.createStatement();
			String sql="select privilege from employee where empno="+empno;
			rs=st.executeQuery(sql);
			if(rs.next()){
				pri=rs.getInt("privilege");
			}else{
				pri=-1;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DbUtil.close(rs);
			DbUtil.close(st);
			DbUtil.close(conn);
			
		}
		
		return pri;
	}
}

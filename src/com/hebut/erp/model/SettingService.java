package com.hebut.erp.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hebut.erp.pojo.SettingDTO;
import com.hebut.erp.util.DbUtil;

public class SettingService {

	public static SettingDTO getSetting() {
		SettingDTO set=new SettingDTO();
		Connection conn = DbUtil.getConn();
		Statement st = null;
		ResultSet rs=null;
		try {
			String sql = "select quanqin,other,fakuan from setting";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				set.setQuanqin(rs.getFloat(1));
				set.setOther(rs.getFloat(2));
				set.setFakuan(rs.getFloat(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;

		} finally {
			DbUtil.close(rs);
			DbUtil.close(st);
			DbUtil.close(conn);
		}
		return set;
	}

	
}

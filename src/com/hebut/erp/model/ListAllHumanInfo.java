package com.hebut.erp.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hebut.erp.pojo.HumanDTO;
import com.hebut.erp.util.DbUtil;

public class ListAllHumanInfo {

	public static int pageSize = 10;

	public static List listEmp(int pageNow) {
		int start = 0;
		if (pageNow == 1) {
			start = 0;
		} else {
			start = (pageNow - 1) * pageSize + 1;
		}

		Connection conn = DbUtil.getConn();
		Statement st = null;
		ResultSet rs = null;
		List<HumanDTO> list = new ArrayList<HumanDTO>();
		try {
			st = conn.createStatement();
			String sql = "select tmp.eno,tmp.na,tmp.se,tmp.ph,tmp.dna,tmp.addr,j.job from job j " +
					"right join(select empno eno,name na,sex se,phone ph,d.dname dna,address addr,jobid from human " +
					"left join dept d on d.deptno=human.deptno)tmp " +
					"on tmp.jobid=j.jobid limit "
					+ start + "," + pageSize;
			rs = st.executeQuery(sql);
			while (rs.next()) {
//				list.add(new HumanDTO(rs.getInt("eno"), rs.getString("na"), rs
//						.getString("se"), rs.getString("ph"), rs.getString("dna"), rs
//						.getString("addr"), rs.getString("job")));
				HumanDTO hum=new HumanDTO();
				hum.setName(rs.getString("na"));
				hum.setEmpno(rs.getInt("eno"));
				hum.setSex(rs.getString("se"));
				hum.setPhone(rs.getString("ph"));
				hum.setDname(rs.getString("dna"));
				hum.setAddress(rs.getString("addr"));
				hum.setJob(rs.getString("job"));
				list.add(hum);
				
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(st);
			DbUtil.close(conn);
		}
	}

}

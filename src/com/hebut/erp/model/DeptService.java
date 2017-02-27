package com.hebut.erp.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hebut.erp.pojo.Dept;
import com.hebut.erp.pojo.DeptAndJob;
import com.hebut.erp.pojo.DeptDTO;
import com.hebut.erp.util.DbUtil;

public class DeptService {
	public static boolean addDept(DeptDTO dept) {
		int count = 0;
		Connection conn = DbUtil.getConn();
		PreparedStatement pstml = null;
		try {
			String sql = "insert into dept(dname,location)values(?,?) ";
			pstml = conn.prepareStatement(sql);
			pstml.setString(1, dept.getDname());
			pstml.setString(2, dept.getLocation());
			count = pstml.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(pstml);
			DbUtil.close(conn);

		}

		if (count == 1) {
			return true;
		} else {
			return false;
		}

	}

	public static boolean delDept(String[] deptnos) {
		int count = 0;
		Connection conn = DbUtil.getConn();
		PreparedStatement pstmt = null;
		try {
			String sql = "delete from dept where deptno=?" ;
			pstmt = conn.prepareStatement(sql);
			for(String dno:deptnos){
				pstmt.setInt(1, Integer.parseInt(dno.trim()));
				count=pstmt.executeUpdate();			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}
		if (count == 1) {
			return true;
		} else {
			return false;
		}
	}
	public static List<Dept> listDept() {
		Connection conn = DbUtil.getConn();
		Statement st = null;
		ResultSet rs = null;
		List<Dept> list = new ArrayList<Dept>();
		try {
			String sql = "select * from dept";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				list.add(new Dept(rs.getInt("deptno"), rs.getString("dname"),
						rs.getString("location")));

			}

		} catch (SQLException e) {
		
			e.printStackTrace();
			return null;
		} finally {
			DbUtil.close(st);
			DbUtil.close(conn);

		}
		return list;
	}

	public static boolean isExists(DeptDTO dept) {
		Connection conn = DbUtil.getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean flag = false;
		String sql = "select deptno from dept where dname=? and location=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dept.getDname());
			pstmt.setString(2, dept.getLocation());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				flag = true;
				;
			} else {
				flag = false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			flag = false;
		} finally {

			DbUtil.close(rs);
			DbUtil.close(pstmt);
			DbUtil.close(conn);

		}
		return flag;
	}

	public static List<DeptAndJob> listDeptAndJob() {
		Connection conn = DbUtil.getConn();
		Statement st = null;
		ResultSet rs = null;
		List<DeptAndJob> list=new ArrayList<DeptAndJob>();
		String sql = "select d.deptno,d.dname,j.jobid,j.job from dept d left " +
				"join job j on d.deptno=j.deptno";
		try {
			st=conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				list.add(new DeptAndJob(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(st);
			DbUtil.close(conn);
		}
		return list;
	}

}

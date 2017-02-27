package com.hebut.erp.model.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hebut.erp.dao.HumanDao;
import com.hebut.erp.model.HumanService;
import com.hebut.erp.pojo.HumInfo;
import com.hebut.erp.pojo.HumanInsert;
import com.hebut.erp.pojo.HumanShow;
import com.hebut.erp.util.DbUtil;

public class HumanServiceImpl implements HumanService {
	
	private HumanDao humanDao;

	public void setHumanDao(HumanDao humanDao) {
		this.humanDao = humanDao;
	}

	public boolean delHuman(int empno) {
		boolean flag = false;
		flag=humanDao.delHuman(empno);
//		Connection conn = DbUtil.getConn();
//		Statement st = null;
//		int count = 0;
//		try {
//			st = conn.createStatement();
//			String sql = "delete from human where empno=" + empno;
//			count = st.executeUpdate(sql);
//			if (count == 1) {
//				flag = true;
//				System.out.println("delete succ!");
//			} else {
//				flag = false;
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//			flag = false;
//		} finally {
//
//			DbUtil.close(st);
//			DbUtil.close(conn);
//		}

		return flag;
	}

	public boolean addHuman(HumanInsert human) {
//
//		Connection conn = DbUtil.getConn();
//		PreparedStatement pstmt = null;
//		int count = 0;
//		boolean flag = false;
//		try {
//			String sql = "insert into human(name,sex,phone,email,nation,politic,degree,address,family,resume,mark,deptno,jobid,hiredate)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, human.getName());
//			pstmt.setString(2, human.getSex());
//			pstmt.setString(3, human.getPhone());
//			pstmt.setString(4, human.getEmail());
//			pstmt.setString(5, human.getNation());
//			pstmt.setString(6, human.getPolitic());
//			pstmt.setString(7, human.getDegree());
//			pstmt.setString(8, human.getAddress());
//			pstmt.setString(9, human.getFamily());
//			pstmt.setString(10, human.getResume());
//			pstmt.setString(11, human.getMark());
//			pstmt.setInt(12, human.getDeptno());
//			pstmt.setInt(13, human.getJobid());
//			pstmt.setDate(14, human.getHiredate());
//			count = pstmt.executeUpdate();
//			if (count == 1) {
//				flag = true;
//			} else {
//				flag = false;
//			}
//
//			System.out.println("regist succ!");
//		} catch (SQLException e) {
//			e.printStackTrace();
//			flag = false;
//		} finally {
//
//			DbUtil.close(pstmt);
//			DbUtil.close(conn);
//		}
		boolean flag=false;
		flag=humanDao.addHuman(human);
		return flag;

	}

	public HumanShow listDetail(int empno) {

		Connection conn = DbUtil.getConn();
		Statement st = null;
		ResultSet rs = null;
		HumanShow human = null;
		try {
			st = conn.createStatement();
			String sql = "select empno,name,sex,phone,email,nation,politic,degree,address,family,"
					+ " resume,mark,deptno,jobid,hiredate from human where empno="
					+ empno;

			rs = st.executeQuery(sql);
			if (rs.next()) {

				human = new HumanShow(rs.getInt("empno"), rs.getString("name"),
						rs.getString("sex"), rs.getString("phone"),
						rs.getString("email"), rs.getString("nation"),
						rs.getString("politic"), rs.getString("degree"),
						rs.getString("address"), rs.getString("family"),
						rs.getString("resume"), rs.getString("mark"),
						rs.getInt("deptno"), rs.getInt("jobid"),
						rs.getDate("hiredate"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {

			DbUtil.close(rs);
			DbUtil.close(st);
			DbUtil.close(conn);
		}
		return human;

	}

	public boolean upHuman(HumanShow human) {
		Connection conn = DbUtil.getConn();
		PreparedStatement pstmt = null;
		int count = 0;
		boolean flag = false;
		try {

			String sql = "update human set name=?,sex=?,phone=?,email=?,nation=?,politic=?,"
					+ " degree=?,address=?,family=?,resume=?,mark=?,deptno=?,jobid=?,hiredate=?"
					+ " where empno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, human.getName());
			pstmt.setString(2, human.getSex());
			pstmt.setString(3, human.getPhone());
			pstmt.setString(4, human.getEmail());
			pstmt.setString(5, human.getNation());
			pstmt.setString(6, human.getPolitic());
			pstmt.setString(7, human.getDegree());
			pstmt.setString(8, human.getAddress());
			pstmt.setString(9, human.getFamily());
			pstmt.setString(10, human.getResume());
			pstmt.setString(11, human.getMark());
			pstmt.setInt(12, human.getDeptno());
			pstmt.setInt(13, human.getJobid());
			pstmt.setDate(14, human.getHiredate());
			pstmt.setInt(15, human.getEmpno());
			count = pstmt.executeUpdate();
			if (count == 1) {
				flag = true;
			} else {
				flag = false;
			}

			System.out.println("update succ!");
		} catch (SQLException e) {
			e.printStackTrace();
			flag = false;
		} finally {

			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}

		return flag;

	}

	/**
	 * 根据用户名和密码判断用户是否存在
	 */
	public boolean isExists(String name, String pass) {
		boolean flag = false;
//		Connection conn = DbUtil.getConn();
//		Statement st = null;
//		ResultSet rs = null;
//		try {
//			st = conn.createStatement();
//			String sql = "select empno from human where name='" + name + "'";
//			rs = st.executeQuery(sql);
//			int intpass = 0;
//			try {
//				intpass = Integer.parseInt(pass);
//			} catch (NumberFormatException e) {
//				return false;
//			}
//
//			if (rs.next() && rs.getInt(1) == intpass) {
//				flag = true;
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//			flag = false;
//		} finally {
//			DbUtil.close(rs);
//			DbUtil.close(st);
//			DbUtil.close(conn);
//		}
		flag=humanDao.isEmpExists(name,pass);
		return flag;
	}

	
	/**
	 * 根据用户id获取用户姓名
	 */
	public List<HumInfo> getHumInfo(int[] empnos) {
		List<HumInfo> humList = new ArrayList<HumInfo>();
		humList=humanDao.getHumanInfo(empnos);
		return humList;
	}

	public List<HumInfo> getHumInfo() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	

	
}
package com.hebut.erp.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hebut.erp.pojo.JobDTO;
import com.hebut.erp.util.DbUtil;

public class JobService {
	/**
	 * 根据部门号 返回岗位名称
	 */
	public static List getJobs(int deptno) {

		List<JobDTO> jobs = new ArrayList<JobDTO>();
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {

			conn = DbUtil.getConn();
			st = conn.createStatement();
			String sql = "select jobid, job from job where deptno=" + deptno;
			rs = st.executeQuery(sql);
			while (rs.next()) {
				jobs.add(new JobDTO(rs.getInt("jobid"), rs.getString("job")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(st);
			DbUtil.close(conn);

		}
		return jobs;

	}

	public static int addJob(int deptno, String jobname) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			conn = DbUtil.getConn();
			String sql = "insert into job(deptno,job)values(?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			pstmt.setString(2, jobname);
			count = pstmt.executeUpdate();
			System.out.println("Add Job Succ!");
		} catch (SQLException e) {
			count = 0;
			e.printStackTrace();
		} finally {
			DbUtil.close(pstmt);
			DbUtil.close(conn);

		}
		return count;

	}

	public static boolean isJobExists(int deptno, String jobname) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DbUtil.getConn();
			String sql = "select jobid from job where deptno=? and job=?	";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			pstmt.setString(2, jobname);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				flag = true;
			}
		} catch (SQLException e) {
			flag = true;
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			DbUtil.close(conn);

		}
		return flag;
	}

	public static boolean delJob(int jobid) {
		Connection conn = null;
		Statement st = null;
		int count = 0;
		try {

			conn = DbUtil.getConn();
			st = conn.createStatement();
			String sql = "delete from job where jobid=" + jobid;
			count = st.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(st);
			DbUtil.close(conn);

		}
		if (count == 1)
			return true;
		return false;

	}

	public static boolean dnoInJob(int deptno) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		boolean flag = false;
		try {

			conn = DbUtil.getConn();
			st = conn.createStatement();
			String sql = "select jobid from job where deptno=" + deptno;
			rs = st.executeQuery(sql);
			if (rs.next()) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(st);
			DbUtil.close(conn);

		}

		return flag;
	}

	public static List getJobIds() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		List<JobDTO> jobs = new ArrayList<JobDTO>();
		try {
			conn = DbUtil.getConn();
			st = conn.createStatement();
			String sql = "select jobid,job from job";
			rs = st.executeQuery(sql);
			while (rs.next()) {
				jobs.add(new JobDTO(rs.getInt("jobid"), rs.getString("job")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(st);
			DbUtil.close(conn);
		}
		return jobs;
	}

	public static List getJobIds(int deptno) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		List<JobDTO> jobs = new ArrayList<JobDTO>();
		try {
			conn = DbUtil.getConn();
			st = conn.createStatement();
			String sql = "select jobid,job from job where deptno=" + deptno;
			rs = st.executeQuery(sql);
			while (rs.next()) {
				jobs.add(new JobDTO(rs.getInt("jobid"), rs.getString("job")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(st);
			DbUtil.close(conn);
		}
		return jobs;
	}

	// 获取刚刚插入的岗位编号
	/**
	 * 返回最新插入的岗位编号
	 * @return
	 */
	public static int getJobId() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		int jobid = 0;
		try {
			conn = DbUtil.getConn();
			st = conn.createStatement();
			String sql = "select jobid from job order by jobid desc limit 0,1";
			rs = st.executeQuery(sql);
			if (rs.next()) {
				jobid=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(st);
			DbUtil.close(conn);
		}
		return jobid;

	}
}

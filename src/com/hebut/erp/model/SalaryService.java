package com.hebut.erp.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hebut.erp.model.impl.HumanServiceImpl;
import com.hebut.erp.pojo.HumInfo;
import com.hebut.erp.pojo.Salary;
import com.hebut.erp.pojo.SalaryDTO;
import com.hebut.erp.pojo.SalaryInfo;
import com.hebut.erp.pojo.SalarySet;
import com.hebut.erp.pojo.Setting;
import com.hebut.erp.pojo.SettingDTO;
import com.hebut.erp.util.DbUtil;
import com.hebut.erp.util.TimeUtil;

import java.sql.Statement;

public class SalaryService {
	public static List<Salary> querySal(int empno, Date start, Date end) {
		Connection conn = DbUtil.getConn();
		List<Salary> listsal = new ArrayList<Salary>();
		Statement st = null;
		ResultSet rs = null;
		try {

			st = conn.createStatement();
			String sql = "select * from salary where empno=" + empno
					+ " and sal_date between '" + start + "' and '" + end + "'";
			rs = st.executeQuery(sql);
			while (rs.next()) {
				listsal.add(new Salary(rs.getInt("empno"), rs
						.getFloat("salary"), rs.getFloat("other"), rs
						.getFloat("finalsalary"), rs.getDate("sal_date")));
			}
		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		} finally {

			DbUtil.close(rs);
			DbUtil.close(st);
			DbUtil.close(conn);
		}
		return listsal;
	}

	public static List<Salary> querySal(int empno) {
		Connection conn = DbUtil.getConn();
		List<Salary> listsal = new ArrayList<Salary>();
		Statement st = null;
		ResultSet rs = null;
		try {

			st = conn.createStatement();
			String sql = "select * from salary where empno=" + empno;
			rs = st.executeQuery(sql);
			while (rs.next()) {
				listsal.add(new Salary(rs.getInt("empno"), rs
						.getFloat("salary"), rs.getFloat("other"), rs
						.getFloat("finalsalary"), rs.getDate("sal_date")));
			}
		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(st);
			DbUtil.close(conn);
		}
		return listsal;
	}

	public static Setting initSal() {
		Setting set = new Setting();
		Connection conn = DbUtil.getConn();
		Statement st = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		float[] tmp = new float[5];
		try {

			st = conn.createStatement();
			String sql = "select other,quanqin,fakuan from setting where id=1";
			rs = st.executeQuery(sql);
			if (rs.next()) {
				set.setOther(rs.getFloat(1));
				set.setQuanqin(rs.getFloat(2));
				set.setFakuan(rs.getFloat(3));
			}

			String sql2 = "select money from salaryconfig";
			rs2 = st.executeQuery(sql2);
			int i = 0;
			while (rs2.next()) {
				tmp[i] = rs2.getFloat(1);
				i++;
			}
			set.setBase1(tmp[0]);
			set.setBase2(tmp[1]);
			set.setBase3(tmp[2]);
			set.setBase4(tmp[3]);
		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(rs2);
			DbUtil.close(st);
			DbUtil.close(conn);
		}
		return set;
	}

	// ��������������
	public static boolean updateSet(Setting set) {
		Connection conn = DbUtil.getConn();
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		int count = 0;
		int[] arr = null;
		try {
			conn.setAutoCommit(false);
			String sql = "update setting set other=?,quanqin=?,fakuan=?  where id=1";
			pstmt = conn.prepareStatement(sql);

			// pstmt.setFloat(1, set.getBase1());
			// pstmt.setFloat(2, set.getBase2());
			// pstmt.setFloat(3, set.getBase3());
			// pstmt.setFloat(4, set.getBase4());
			pstmt.setFloat(1, set.getOther());
			pstmt.setFloat(2, set.getQuanqin());
			pstmt.setFloat(3, set.getFakuan());
			count = pstmt.executeUpdate();

			String sql2 = "update salaryconfig set money=? where leval=?";
			pstmt2 = conn.prepareStatement(sql2);
			pstmt2.setFloat(1, set.getBase1());
			pstmt2.setInt(2, 1);// ���ｫ���ʵȼ�д����
			pstmt2.addBatch();

			pstmt2.setFloat(1, set.getBase2());
			pstmt2.setInt(2, 2);// ���ｫ���ʵȼ�д����
			pstmt2.addBatch();

			pstmt2.setFloat(1, set.getBase3());
			pstmt2.setInt(2, 3);// ���ｫ���ʵȼ�д����
			pstmt2.addBatch();

			pstmt2.setFloat(1, set.getBase4());
			pstmt2.setInt(2, 4);// ���ｫ���ʵȼ�д����
			pstmt2.addBatch();
			arr = pstmt2.executeBatch();
			conn.commit();
			if (count == 1 && arr.length == 4) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
				return false;
			}
			e.printStackTrace();
			return false;
		} finally {
			DbUtil.close(pstmt);
			DbUtil.close(pstmt2);
			DbUtil.close(conn);
		}

	}

	public static List<SalaryInfo> getSalInfo() {
		List<SalaryInfo> salinfo = new ArrayList<SalaryInfo>();
		Connection conn = DbUtil.getConn();
		Statement st = null;
		ResultSet rs = null;
		try {
			String sql = "select conf.id,tmp.jobid,tmp.job,conf.leval,conf.money from salaryconfig conf right join "
					+ "(select j.jobid,job,se.leval from job j right join salaryset se on j.jobid=se.jobid) tmp "
					+ "on conf.leval=tmp.leval ";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				salinfo.add(new SalaryInfo(rs.getInt(1), rs.getInt(2), rs
						.getString(3), rs.getInt(4), rs.getFloat(5)));
			}
		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(st);
			DbUtil.close(conn);
		}
		return salinfo;
	}

	public static String salInitJson() {
		Connection conn = DbUtil.getConn();
		StringBuffer sb = new StringBuffer();
		Statement st = null;
		ResultSet rs = null;
		try {

			st = conn.createStatement();
			String sql = "select leval,money from salaryconfig ";
			rs = st.executeQuery(sql);
			System.out.println("saljson init!");
			sb.append("[");
			while (rs.next()) {
				sb.append("{");
				sb.append("leval");
				sb.append(":");
				sb.append("\"");
				sb.append(rs.getInt(1));
				sb.append("\"");
				sb.append(",");
				sb.append("money");
				sb.append(":");
				sb.append("\"");
				sb.append(rs.getFloat(2));
				sb.append("\"");
				sb.append("}");
				sb.append(",");
			}
			sb = sb.replace(sb.length() - 1, sb.length(), "");
			sb.append("]");

		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(st);
			DbUtil.close(conn);
		}

		return new String(sb);

	}

	public static SalarySet getLevel(int jobid) {
		Connection conn = DbUtil.getConn();
		Statement st = null;
		ResultSet rs = null;
		SalarySet salset = null;
		try {
			String sql = "select s.jobid,job,leval from salaryset s left join job on job.jobid=s.jobid where s.jobid="
					+ jobid;
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				salset = new SalarySet(rs.getInt(1), rs.getString(2),
						rs.getInt(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;

		} finally {
			DbUtil.close(rs);
			DbUtil.close(st);
			DbUtil.close(conn);
		}
		return salset;
	}

	public static boolean saveLevel(SalarySet salset) {
		Connection conn = DbUtil.getConn();
		Statement st = null;
		int count = 0;
		try {
			String sql = "update salaryset set leval=" + salset.getLevel()
					+ " where jobid=" + salset.getJobid();
			st = conn.createStatement();
			count = st.executeUpdate(sql);
			if (count == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;

		} finally {
			DbUtil.close(st);
			DbUtil.close(conn);
		}
		return false;
	}

	public static boolean saveLevel(int jobid, int level) {
		Connection conn = DbUtil.getConn();
		Statement st = null;
		int count = 0;
		try {
			String sql = "insert into salaryset(jobid,leval)values(" + jobid
					+ "," + level + ")";
			st = conn.createStatement();
			count = st.executeUpdate(sql);
			if (count == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;

		} finally {
			DbUtil.close(st);
			DbUtil.close(conn);
		}
		return false;
	}

	/**
	 * ��ѯ�����µ�empno Ա�����ֳٵ����
	 * 
	 * @param lastSal
	 */
	public static List<SalaryDTO> getSalCheckInfo(Date lastSalDate) {
		// ��ȡ����Ա�����,����
		List<HumInfo> humlist = HumanServiceImpl.getHumInfo();
		List<SalaryDTO> salchkinfo = new ArrayList<SalaryDTO>();
		int empno = 0;
		float quanqin = 0;
		float fakuan = 0;
		float other = 0;
		int lateTimes = 0;
		SettingDTO set = SettingService.getSetting();
		if (set == null) {
			System.out.println("��ѯsetting����");
			return null;
		}

		for (HumInfo hum : humlist) {
			empno = hum.getEmpno();
			// ��ȡԱ���ٵ�����
			lateTimes = TimeUtil.getLateTimes(empno, lastSalDate);
			other = set.getOther();
			if (lateTimes == 0) {
				quanqin = set.getQuanqin();
			} else {
				fakuan = set.getFakuan();
			}
			// ��ȡ�����������
			float money = SalaryService.getMoney(empno);
			if (money == -1) {
				return null;
			}
			// ȫ�ڽ�

			SalaryDTO salinfo = new SalaryDTO();
			salinfo.setEmpno(empno);
			salinfo.setName(hum.getName());
			salinfo.setMoney(money);
			salinfo.setFakuan(fakuan);
			salinfo.setLatetimes(lateTimes);
			salinfo.setQuanqin(quanqin);
			salinfo.setOther(other);
			salchkinfo.add(salinfo);

		}
		return salchkinfo;
	}
	
	/**
	 * ����ָ����Ա����Ϣ
	 * @param lastSalDate
	 * @param empnos
	 * @return
	 */
	public static List<SalaryDTO> getSalCheckInfo(Date lastSalDate,int[] empnos) {
		// ��ȡ����Ա�����,����
		List<HumInfo> humlist = HumanServiceImpl.getHumInfo(empnos);
		List<SalaryDTO> salchkinfo = new ArrayList<SalaryDTO>();
		int empno = 0;
		float quanqin = 0;
		float fakuan = 0;
		float other = 0;
		int lateTimes = 0;
		SettingDTO set = SettingService.getSetting();
		if (set == null) {
			System.out.println("��ѯsetting����");
			return null;
		}

		for (HumInfo hum : humlist) {
			empno = hum.getEmpno();
			// ��ȡԱ���ٵ�����
			lateTimes = TimeUtil.getLateTimes(empno, lastSalDate);
			other = set.getOther();
			if (lateTimes == 0) {
				quanqin = set.getQuanqin();
			} else {
				fakuan = set.getFakuan();
			}
			// ��ȡ�����������
			float money = SalaryService.getMoney(empno);
			if (money == -1) {
				return null;
			}
			// ȫ�ڽ�

			SalaryDTO salinfo = new SalaryDTO();
			salinfo.setEmpno(empno);
			salinfo.setName(hum.getName());
			salinfo.setMoney(money);
			salinfo.setFakuan(fakuan);
			salinfo.setLatetimes(lateTimes);
			salinfo.setQuanqin(quanqin);
			salinfo.setOther(other);
			salchkinfo.add(salinfo);

		}
		return salchkinfo;
	}

	/**
	 * ����Ա����Ų�ѯӦ������
	 * 
	 * @param empno
	 * @return
	 */
	private static float getMoney(int empno) {
		Connection conn = DbUtil.getConn();
		Statement st = null;
		ResultSet rs = null;
		float money = 0;
		try {
			String sql = "select money from salaryconfig sc right join "
					+ "(select empno,ss.leval from human h left join salaryset ss "
					+ "on h.jobid=ss.jobid where empno=" + empno
					+ ")tmp on sc.leval=tmp.leval";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				money = rs.getFloat(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;

		} finally {
			DbUtil.close(rs);
			DbUtil.close(st);
			DbUtil.close(conn);
		}
		return money;
	}

	public static boolean insertSalary(Salary salary) {
		// TODO Auto-generated method stub
		Connection conn = DbUtil.getConn();
		PreparedStatement pstmt = null;
		float money = 0;
		try {
			String sql = "insert into salary (empno,salary,other,finalsalary,sal_date)values(?,?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1, salary.getEmpno());
			pstmt.setFloat(2, salary.getSalary());
			pstmt.setFloat(3, salary.getOther());
			pstmt.setFloat(4, salary.getFinalsalary());
			pstmt.setDate(5, salary.getSal_date());
			int i=pstmt.executeUpdate();
			if(i==1){
				return true;
			}else{
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}
		
	}
}

package com.hebut.erp.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hebut.erp.pojo.DayCheckColl;
import com.hebut.erp.pojo.DayCheckDTO;
import com.hebut.erp.pojo.TodayCheck;
import com.hebut.erp.util.DbUtil;
import com.hebut.erp.util.TimeUtil;

public class CheckService {
/**
 * Ա���ϰ�� ��Ϣ���µ����ݿ�
 * @param check
 * @return
 */
	public static boolean check(DayCheckDTO check) {
		Connection conn = DbUtil.getConn();
		PreparedStatement pstmt = null;
		int count = 0;
		Timestamp tist = new Timestamp(new Date().getTime());
		try {
			String sql = "insert into day_check (empno,check_time,islate,reason) values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, check.getEmpno());
			pstmt.setTimestamp(2, tist);
			pstmt.setString(3, check.getIslate());
			pstmt.setString(4, check.getReason());
			count = pstmt.executeUpdate();
			if (count == 1) {
				return true;
			} else {
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
/**
 * ��setting���ж�ȡ��ʱ��
 * @return
 */
	public static Time getTime() {
		Connection conn = DbUtil.getConn();
		Statement st = null;
		ResultSet rs = null;
		Time time = null;
		try {
			st = conn.createStatement();
			String sql = "select intime from setting";
			rs = st.executeQuery(sql);
			if (rs.next()) {
				time = rs.getTime("intime");
			} else {
				return null;
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
		return time;
	}

	public static boolean setTime(Time time) {
		Connection conn = DbUtil.getConn();
		Statement st = null;
		int count = 0;
		try {
			st = conn.createStatement();
			String sql = "update setting set intime='" + time + "' where id=1";
			count = st.executeUpdate(sql);
			if (count == 1) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;

		} finally {
			DbUtil.close(st);
			DbUtil.close(conn);
		}
	}

	/**
	 * 
	 * @param empno
	 * @return yes��ʾ�Ѿ������ no��ʾû�д����
	 */
	public static String isChecked(int empno) {
		Connection conn = DbUtil.getConn();
		Statement st = null;
		ResultSet rs = null;
		Timestamp timestamp = null;
		try {
			st = conn.createStatement();
			String sql = "select check_time from day_check where empno="
					+ empno + " order by check_time desc limit 0,1";
			rs = st.executeQuery(sql);
			// ����ֵ���Һ�����ʱ��Ƚ�
			if (rs.next()) {
				timestamp = rs.getTimestamp("check_time");
				System.out.println(timestamp);
				if (TimeUtil.isToday(timestamp)) {
					return "yes";
				} else {
					return "no";
				}
			} else {
				return "no";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return "no";
		} finally {
			DbUtil.close(rs);
			DbUtil.close(st);
			DbUtil.close(conn);
		}
	}
/**
 * ͳ�ƴ���һ�η����ʿ�ʼ����,����һ��
 * @return
 */
	public static List<DayCheckColl> getCollection() {
		Connection conn = DbUtil.getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Date sal_date=TimeUtil.getSalDate();
		if(sal_date==null){
			System.out.println("CheckService Wrong!");
			return null;
		}
		List<DayCheckColl> list = new ArrayList<DayCheckColl>();
		try {
			String sql = "select fina.eno,fina.na,d.dname,fina.latetimes "
					+ "from dept d "
					+ "right join(select h.empno eno,name na,latetimes,deptno from human h "
					+ "right join(select empno,count(islate) latetimes from day_check where islate='Y' and check_time>'"+sal_date+"' group by empno)tong "
					+ "on h.empno=tong.empno)fina "
					+ "on d.deptno=fina.deptno;";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			// ����ֵ���Һ�����ʱ��Ƚ�
			while (rs.next()) {
				list.add(new DayCheckColl(rs.getInt(1), rs.getString(2), rs
						.getString(3), rs.getInt(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}
		return list;
	}
/**
 * ���ؽ���Ĵ����
 * @param today
 * @return
 */
	public static List<TodayCheck> getTodays(Date today) {
		Connection conn = DbUtil.getConn();
		Statement st = null;
		ResultSet rs = null;
		List<TodayCheck> list=new ArrayList<TodayCheck>();
		try {
			st = conn.createStatement();
			String sql = "select h.empno,name,d.check_time,d.islate,d.reason from human h"
					+ " left join day_check d"
					+ " on h.empno=d.empno and d.check_time> '"+today+"'";
			rs = st.executeQuery(sql);
			while(rs.next()) {
				list.add(new TodayCheck(rs.getInt("empno"),rs.getString("name"),rs.getTimestamp("check_time"),rs.getString("islate"),rs.getString("reason")));
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

package com.hebut.erp.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

public class TimeUtil {
	/**
	 * �ж��Ƿ�ٵ�
	 * @param ti
	 * @return
	 */
	public static boolean isLate(Time ti) {
		boolean flag = false;
		Date date = new Date();
		int hour = date.getHours();
		int min = date.getMinutes();
		int bhour = ti.getHours();
		int bmin = ti.getMinutes();
		if (hour > bhour) {
			// �ٵ�
			flag = true;
		} else if (hour < bhour) {
			// û�гٵ�
			flag = false;
		} else {
			// Сʱ�� ��ͬʱ �ȽϷ���
			if (min > bmin) {
				// �ٵ�
				flag = true;
			} else {
				// û�гٵ�
				flag = false;
			}
		}
		return flag;

	}

	public static boolean isToday(Timestamp st) {
		boolean flag = false;
		Date today = new Date();
		if (today.getDay() == st.getDay() && today.getMonth() == st.getMonth()
				&& today.getYear() == st.getYear()) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;

	}

	/**
	 * ��ȡ���һ�η����ʵ�����
	 * 
	 * @return
	 */
	public static java.sql.Date getSalDate() {
		Connection conn = DbUtil.getConn();
		java.sql.Date sqldate=null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "select sal_date from salary limit 0,1";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				sqldate = rs.getDate(1);
				System.out.println(sqldate);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(st);
			DbUtil.close(conn);
		}

		return sqldate;
	}
	/**
	 * ��ȡĳԱ�� ����(�ϴη�����������ʱ��)�ٵ�����
	 * 
	 */
	public static int getLateTimes(int empno,Date lastSalDate){
		Connection conn = DbUtil.getConn();
		int lateTimes=-1;
		Statement st = null;
		ResultSet rs = null;
		String sql = "select count(islate) latetimes " +
				"from day_check where " +
				" check_time>'"+lastSalDate+"' group by empno" +
						" having(empno="+empno+");";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				lateTimes = rs.getInt(1);
				System.out.println(empno+"�ٵ�����---->"+lateTimes);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return lateTimes;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(st);
			DbUtil.close(conn); 
		}
		return lateTimes;
	}
}

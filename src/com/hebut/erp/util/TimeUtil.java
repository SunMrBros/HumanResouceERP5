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
	 * 判断是否迟到
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
			// 迟到
			flag = true;
		} else if (hour < bhour) {
			// 没有迟到
			flag = false;
		} else {
			// 小时数 相同时 比较分钟
			if (min > bmin) {
				// 迟到
				flag = true;
			} else {
				// 没有迟到
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
	 * 获取最近一次发工资的日期
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
	 * 获取某员工 本月(上次发工资以来的时间)迟到次数
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
				System.out.println(empno+"迟到次数---->"+lateTimes);
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

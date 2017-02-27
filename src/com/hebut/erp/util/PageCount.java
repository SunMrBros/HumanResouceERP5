package com.hebut.erp.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PageCount {
	/**
	 * 返回指定表的总行数
	 * @param table
	 * @return
	 */
	public static int coutRow(String table) {
		Connection conn = DbUtil.getConn();
		Statement st = null;
		ResultSet rs = null;
		int count = 0;
		try {
			st = conn.createStatement();
			String sql = "select count(*) from " + table;
			rs = st.executeQuery(sql);
			if (rs.next()) {
				count = rs.getInt(1);
			}
			return count;
		} catch (SQLException e) {

			e.printStackTrace();
			return 0;
		} finally {
			DbUtil.close(rs);
			DbUtil.close(st);
			DbUtil.close(conn);

		}

	}

	/**
	 * 
	 * @return返回制定表的页码总数
	 * pageSize 默认为10;
	 */
	public static int getPage(String table) {

		// 表中总行数
		int totalRow = coutRow(table);
		// 每页显示的行数
		int pageSize =12;
		// 总共多少页
		int totalPage = 0;
		if (totalRow % pageSize == 0) {
			totalPage = totalRow / pageSize;
		} else {
			totalPage = totalRow / pageSize + 1;
		}
		return totalPage;
	}
}

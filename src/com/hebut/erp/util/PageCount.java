package com.hebut.erp.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PageCount {
	/**
	 * ����ָ�����������
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
	 * @return�����ƶ����ҳ������
	 * pageSize Ĭ��Ϊ10;
	 */
	public static int getPage(String table) {

		// ����������
		int totalRow = coutRow(table);
		// ÿҳ��ʾ������
		int pageSize =12;
		// �ܹ�����ҳ
		int totalPage = 0;
		if (totalRow % pageSize == 0) {
			totalPage = totalRow / pageSize;
		} else {
			totalPage = totalRow / pageSize + 1;
		}
		return totalPage;
	}
}

package com.hebut.erp.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hebut.erp.pojo.Dept;
import com.hebut.erp.pojo.Human;
import com.hebut.erp.pojo.HumanDTO;
import com.hebut.erp.util.DbUtil;

public class QueryService {
	public static List queryById(int empno) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		List<HumanDTO> list = new ArrayList<HumanDTO>();
		try {
			String sql = "select tmp.eno,tmp.na,tmp.se,tmp.ph,tmp.dna,tmp.addr,j.job from job j "
					+ "right join(select empno eno,name na,sex se,phone ph,d.dname dna,address addr,jobid from human h "
					+ "right join dept d on (d.deptno=h.deptno ) where  h.empno="
					+ empno + ")tmp " + "on tmp.jobid=j.jobid";
			conn = DbUtil.getConn();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
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

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(st);
			DbUtil.close(conn);
		}
		return list;

	}

	/**
	 * ����Ա��������ѯ,�����ط���Ҫ���Ա���б�
	 * 
	 * @param ename
	 * @return
	 */
	public static List queryByName(String ename) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		List<HumanDTO> list = new ArrayList<HumanDTO>();
		try {
			String sql = "select tmp.eno,tmp.na,tmp.se,tmp.ph,tmp.dna,tmp.addr,j.job " +
					"from job j " +
					"right join(select empno eno,name na,sex se,phone ph,d.dname dna,address addr,jobid from human h " +
					"right join dept d on (d.deptno=h.deptno ) " +
					"where  h.name like '%"+ename+"%')tmp " +
					"on tmp.jobid=j.jobid";

			conn = DbUtil.getConn();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
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

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(st);
			DbUtil.close(conn);
		}
		return list;
	}
	/**
	 * ���߸�λ��ŷ���Ա����Ϣ
	 * @param jobid
	 * @return
	 */
	public static List<HumanDTO> queryByJobId(int jobid) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		List<HumanDTO> list = new ArrayList<HumanDTO>();
		try {
			String sql = "select tmp.eno,tmp.na,tmp.se,tmp.ph,tmp.dna,tmp.addr,j.job " +
					"from job j " +
					"right join(select empno eno,name na,sex se,phone ph,d.dname dna,address addr,jobid from human h " +
					"right join dept d on (d.deptno=h.deptno ))tmp " +
					"on tmp.jobid=j.jobid where j.jobid="+jobid;

			conn = DbUtil.getConn();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
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

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(st);
			DbUtil.close(conn);
		}
		return list;
	}


	// ����Ա������������ű�

	public List salManager() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		List<Human> list = new ArrayList<Human>();
		try {
			// Ա�����,����,���ڲ���,ְλ,����,����,���ʺ���,ʵ������,����ʱ��
			String sql = "select e.empno,e.ename,job,mgr,sal,comm,hiredate,deptno from employee e,salary s";
			conn = DbUtil.getConn();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				list.add(new Human());
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(rs);
			DbUtil.close(st);
			DbUtil.close(conn);
		}
		return list;
	}

	// ���ز�����Ϣ
	public static List deptInfo() {

		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		List<Dept> list = new ArrayList<Dept>();
		try {
			conn = DbUtil.getConn();
			st = conn.createStatement();
			String sql = "select deptno,deptname,location from dept";
			rs = st.executeQuery(sql);
			while (rs.next()) {

				list.add(new Dept(rs.getInt("deptno"),
						rs.getString("deptname"), rs.getString("location")));
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

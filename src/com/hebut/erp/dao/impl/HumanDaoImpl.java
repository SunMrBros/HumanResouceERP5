package com.hebut.erp.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.hebut.erp.dao.HumanDao;
import com.hebut.erp.pojo.HumInfo;
import com.hebut.erp.pojo.HumanInsert;

public class HumanDaoImpl implements HumanDao {
	
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<HumInfo> getHumanInfo(int[] empnos) {
		List<HumInfo> list=new ArrayList<HumInfo>();
		StringBuffer sb=new StringBuffer();
		
		for(int i=0;i<empnos.length;i++){
			if(i==empnos.length-1){
				sb.append(empnos[i]);
				break;
			}
			sb.append(empnos[i]+",");
			
		}
		String sql="select empno,name from human where empno in("+sb.toString()+")";
		
		List humans =jdbcTemplate.queryForList(sql);
		System.out.println(humans);
		Iterator it=humans.iterator();
		while(it.hasNext()){
			Map humMap = (Map) it.next(); 
			HumInfo hum=new HumInfo();
			hum.setEmpno((Integer)humMap.get("empno"));
			hum.setName((String)humMap.get("name"));
			list.add(hum);
		}
		return list;
	}

	public boolean isEmpExists(String name, String pass) {
		String sql="";
		this.jdbcTemplate.queryForList(sql);
		return false;
	}

	/**
	 * 根据用户编号删除员工信息
	 */
	public boolean delHuman(int empno) {
		String sql = "delete from human where empno=" + empno;
		int i = jdbcTemplate.update(sql);
		if (i == 1) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 添加用户信息
	 */
	public boolean addHuman(HumanInsert human) {
		String sql = "insert into human(name,sex,phone,email,nation,politic,degree,address,family,resume,mark,deptno,jobid,hiredate)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int i=jdbcTemplate.update(sql, new Object[]{
				human.getName(),
				human.getSex(),
				human.getPhone(),
				human.getEmail(),
				human.getNation(),
				human.getPolitic(),
				human.getDegree(),
				human.getAddress(),
				human.getFamily(),
				human.getResume(),
				human.getMark(),
				human.getDeptno(),
				human.getJobid(),
				human.getHiredate()});
		if (i == 1) {
			return true;
		} else {
			return false;
		}
	}

}

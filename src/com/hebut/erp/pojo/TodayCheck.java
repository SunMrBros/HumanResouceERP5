package com.hebut.erp.pojo;

import java.sql.Timestamp;

public class TodayCheck{
	private int empno;
	private String name;
	private Timestamp check_time;
	private String islate;
	private String reason;
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Timestamp getCheck_time() {
		return check_time;
	}
	public void setCheck_time(Timestamp check_time) {
		this.check_time = check_time;
	}
	public String getIslate() {
		return islate;
	}
	public void setIslate(String islate) {
		this.islate = islate;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public TodayCheck(int empno, String name, Timestamp check_time,
			String islate, String reason) {
		super();
		this.empno = empno;
		this.name = name;
		this.check_time = check_time;
		this.islate = islate;
		this.reason = reason;
	}
	public TodayCheck() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "TodayCheck [empno=" + empno + ", name=" + name
				+ ", check_time=" + check_time + ", islate=" + islate
				+ ", reason=" + reason + "]";
	}
	
	
}

package com.hebut.erp.pojo;

import java.util.Date;

public class DayCheck {
	private int id;
	private int empno;
	private Date checktime;
	private String islate;
	private String reason;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public Date getChecktime() {
		return checktime;
	}
	public void setChecktime(Date checktime) {
		this.checktime = checktime;
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
	
}

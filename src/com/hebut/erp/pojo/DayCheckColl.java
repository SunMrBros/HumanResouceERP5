package com.hebut.erp.pojo;

public class DayCheckColl {
	private int empno;
	private String name;
	private String dname;
	private int count;
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
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public DayCheckColl(int empno, String name, String dname, int count) {
		this.empno = empno;
		this.name = name;
		this.dname = dname;
		this.count = count;
	}
	public DayCheckColl() {
		super();
	}
	
}

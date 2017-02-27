package com.hebut.erp.pojo;

import java.sql.Date;

public class Salary {
	private int empno;
	private float salary;
	private float other;
	private float finalsalary;
	private Date sal_date;
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	
	public float getOther() {
		return other;
	}
	public void setOther(float other) {
		this.other = other;
	}
	public float getFinalsalary() {
		return finalsalary;
	}
	public void setFinalsalary(float finalsalary) {
		this.finalsalary = finalsalary;
	}
	public Date getSal_date() {
		return sal_date;
	}
	public void setSal_date(Date sal_date) {
		this.sal_date = sal_date;
	}
	public Salary( int empno, float salary, float other,
			float finalsalary, Date sal_date) {
		super();
		this.empno = empno;
		this.salary = salary;
		this.other = other;
		this.finalsalary = finalsalary;
		this.sal_date = sal_date;
	}
	@Override
	public String toString() {
		return "Salary [ empno=" + empno + ", salary=" + salary
				+ ", other=" + other + ", finalsalary=" + finalsalary
				+ ", sal_date=" + sal_date + "]";
	}
	public Salary() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

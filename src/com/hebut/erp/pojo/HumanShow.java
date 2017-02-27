package com.hebut.erp.pojo;
import java.sql.Date;
public class HumanShow {
	private int empno;
	private String name;
	private String sex;
	private String phone;
	private String email;
	private String nation;
	private String politic;
	private String degree;
	private String address;
	private String family;
	private String resume;
	private String mark;
	private int deptno;
	private int jobid;
	private Date hiredate;
	
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getPolitic() {
		return politic;
	}
	public void setPolitic(String politic) {
		this.politic = politic;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getFamily() {
		return family;
	}
	public void setFamily(String family) {
		this.family = family;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public int getJobid() {
		return jobid;
	}
	public void setJobid(int jobid) {
		this.jobid = jobid;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public HumanShow(int empno, String name, String sex, String phone,
			String email, String nation, String politic, String degree,
			String address, String family, String resume, String mark,
			int deptno, int jobid, Date hiredate) {
		super();
		this.empno = empno;
		this.name = name;
		this.sex = sex;
		this.phone = phone;
		this.email = email;
		this.nation = nation;
		this.politic = politic;
		this.degree = degree;
		this.address = address;
		this.family = family;
		this.resume = resume;
		this.mark = mark;
		this.deptno = deptno;
		this.jobid = jobid;
		this.hiredate = hiredate;
	}
	public HumanShow() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "HumanShow [empno=" + empno + ", name=" + name + ", sex=" + sex
				+ ", phone=" + phone + ", email=" + email + ", nation="
				+ nation + ", politic=" + politic + ", degree=" + degree
				+ ", address=" + address + ", family=" + family + ", resume="
				+ resume + ", mark=" + mark + ", deptno=" + deptno + ", jobid="
				+ jobid + ", hiredate=" + hiredate + "]";
	}
	
	
}

package com.hebut.erp.pojo;

public class HumanDTO {
	//要显示的员工信息 传送给前台
	private int empno;
	private String name;
	private String sex;
	private String phone;
	private String address;
	private String dname;
	private String job;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public HumanDTO(){}
	public HumanDTO(int empno,String name,String sex,String phone,String address,String job,String dname){
		this.name=name;
		this.empno=empno;
		this.sex=sex;
		this.phone=phone;
		this.address=address;
		this.dname=dname;
		this.job=job;
	}
	public String toString(){
		return "name="+name+" dname="+dname+" job="+job;
	}
}

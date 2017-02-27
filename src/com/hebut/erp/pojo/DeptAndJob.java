package com.hebut.erp.pojo;

public class DeptAndJob {
	private int deptno;
	private String dname;
	private int jobid;
	private String job;
	
	public int getJobid() {
		return jobid;
	}
	public void setJobid(int jobid) {
		this.jobid = jobid;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
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
	public DeptAndJob(int deptno, String dname,int jobid, String job) {
		this.deptno = deptno;
		this.dname = dname;
		this.jobid=jobid;
		this.job = job;
	}
	public DeptAndJob() {
	}
	@Override
	public String toString() {
		return "DeptAndJob [deptno=" + deptno + ", dname=" + dname + ", job="
				+ job + "]";
	}
	
}

package com.hebut.erp.pojo;

public class SalarySet {
	private int jobid;
	private String job;
	private int level;
	public int getJobid() {
		return jobid;
	}
	public void setJobid(int jobid) {
		this.jobid = jobid;
	}
	
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public SalarySet(int jobid,String job, int level) {
		super();
		this.jobid = jobid;
		this.job=job;
		this.level = level;
	}
	public SalarySet() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "SalarySet [jobid=" + jobid + ", level=" + level + "]";
	}
	
	
}

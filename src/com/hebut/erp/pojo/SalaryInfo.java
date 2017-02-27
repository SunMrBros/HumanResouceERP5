package com.hebut.erp.pojo;

public class SalaryInfo {
	//id   | jobid | job          | leval | money
	private int id;
	private int jobid;
	private String job;
	private int leval;
	private float money;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public int getLeval() {
		return leval;
	}
	public void setLeval(int leval) {
		this.leval = leval;
	}
	public float getMoney() {
		return money;
	}
	public void setMoney(float money) {
		this.money = money;
	}
	public SalaryInfo(int id, int jobid, String job, int leval, float money) {
		super();
		this.id = id;
		this.jobid = jobid;
		this.job = job;
		this.leval = leval;
		this.money = money;
	}
	public SalaryInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "SalaryInfo [id=" + id + ", jobid=" + jobid + ", job=" + job
				+ ", leval=" + leval + ", money=" + money + "]";
	}
	
}

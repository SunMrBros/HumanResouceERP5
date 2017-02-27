package com.hebut.erp.pojo;
/**
 * 初始化设置工资等级
 * @author Administrator
 *
 */
public class SalaryInit {
	private int jobid;
	private int leval;
	private float money;
	public int getJobid() {
		return jobid;
	}
	public void setJobid(int jobid) {
		this.jobid = jobid;
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
	public SalaryInit(int jobid, int leval, float money) {
		super();
		this.jobid = jobid;
		this.leval = leval;
		this.money = money;
	}
	public SalaryInit() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "SalaryInit [jobid=" + jobid + ", leval=" + leval + ", money="
				+ money + "]";
	}
	
	
}

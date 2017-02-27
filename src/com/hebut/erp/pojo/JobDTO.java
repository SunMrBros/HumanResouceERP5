package com.hebut.erp.pojo;

public class JobDTO {
	private int jobid;
	private String job;
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
	@Override
	public String toString() {
		return "JobDTO [jobid=" + jobid + ", job=" + job + "]";
	}
	public JobDTO(int jobid, String job) {
		this.jobid = jobid;
		this.job = job;
	}
	
}

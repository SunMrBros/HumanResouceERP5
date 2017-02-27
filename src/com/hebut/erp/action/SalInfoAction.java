package com.hebut.erp.action;

import java.util.List;


import com.hebut.erp.model.SalaryService;
import com.hebut.erp.pojo.SalaryInfo;
import com.hebut.erp.pojo.SalarySet;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class SalInfoAction implements Action {
	private int jobid;
	private SalarySet salset;

	public SalarySet getSalset() {
		return salset;
	}
	public void setSalset(SalarySet salset) {
		this.salset = salset;
	}
	public int getJobid() {
		return jobid;
	}
	public void setJobid(int jobid) {
		this.jobid = jobid;
	}
	public String execute() throws Exception {
		
		List<SalaryInfo> salinfo=SalaryService.getSalInfo();
		if(salinfo!=null){
			ActionContext.getContext().put("salinfo", salinfo);
			return SUCCESS;
		}else{
			ActionContext.getContext().put("msg", "查询工资信息失败!");
			return ERROR;
		}
		
	}
	public String modSal(){
		salset=SalaryService.getLevel(jobid);
		if(salset!=null){
			ActionContext.getContext().put("msg", "修改信息工资等级成功!<a herf=\"salaryinfo.action\">返回查看</a>");
			return SUCCESS;
		}else{
			ActionContext.getContext().put("msg", "初始化信息错误!");
			return ERROR;
		}
		
	}
	public String upmodSal(){
		boolean flag=SalaryService.saveLevel(salset);
		if(flag){
			
			return SUCCESS;
		}else{
			ActionContext.getContext().put("msg", "初始化信息错误!");
			return ERROR;
		}
		
	}

}

package com.hebut.erp.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.hebut.erp.model.DeptService;
import com.hebut.erp.model.JobService;
import com.hebut.erp.model.SalaryService;
import com.hebut.erp.pojo.Dept;
import com.hebut.erp.pojo.JobDTO;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class JobAction implements Action {
	private int deptno;
	private int jobid;
	private String jobname;
	private int level;
	List<JobDTO> jobs;

	
	public List<JobDTO> getJobs() {
		return jobs;
	}

	public void setJobs(List<JobDTO> jobs) {
		this.jobs = jobs;
	}

	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getJobname() {
		return jobname;
	}

	public void setJobname(String jobname) {
		this.jobname = jobname;
	}

	
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

	public String execute() throws Exception {

		List<Dept> list = new ArrayList<Dept>();
		list = DeptService.listDept();
		ActionContext.getContext().put("list", list);
		return null;
	}

	public String addJob() throws IOException {
		if (!JobService.isJobExists(deptno, jobname)
				&& JobService.addJob(deptno, jobname) == 1) {
			//在共插入后的岗位表中取出新插入的jobid,根据jobid插入salaryset表
			int jobid=JobService.getJobId();
			if(jobid!=0){
				boolean b=SalaryService.saveLevel(jobid,level);
				if(b){
					System.out.println("update SalarySet succ");
					ActionContext.getContext().put("msg", "增加岗位成功! :) ");
					return SUCCESS;
				}else{
					ActionContext.getContext().put("msg", "更细工资等级失败! :(");
					//更新工资级别出错 ,要删除岗位
					if(JobService.delJob(jobid)){
						ActionContext.getContext().put("msg", "更细工资等级失败!,新增岗位没有成功删除... :(");
						return ERROR;
					};
					return ERROR;
				}
			}else{
				ActionContext.getContext().put("msg", "获取jobid失败 JobAction ");
				return ERROR;
			}
		} else {
			ActionContext.getContext().put("msg", "增加的岗位已存在或是添加出错没有成功! :( ");
			return ERROR;
		}
	}

	@SuppressWarnings("unchecked")
	public String showJob() {
		// 调用模块
		if (JobService.dnoInJob(deptno)) {
			jobs = JobService.getJobs(deptno);
			ActionContext.getContext().getSession().put("jobs", jobs);
			System.out.println(deptno);
			return SUCCESS;
		}else{
			ActionContext.getContext().put("msg", "部门没有岗位存在!<br><a href=\"deljob.action\">返回</a>");
			return ERROR;
		}
	}
	public String delJob() {
		System.out.println("deljob--->"+jobid);
		boolean flag = JobService.delJob(jobid);
		if (flag) {
			ActionContext.getContext().put("msg", "删除岗位成功!<a href=\'deljob.action\'>返回</a>");
			return SUCCESS;
		} else {
			ActionContext.getContext().put("msg", "删除岗位失败!");
			return ERROR;
		}
		
	}

}

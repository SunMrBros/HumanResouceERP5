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
			//�ڹ������ĸ�λ����ȡ���²����jobid,����jobid����salaryset��
			int jobid=JobService.getJobId();
			if(jobid!=0){
				boolean b=SalaryService.saveLevel(jobid,level);
				if(b){
					System.out.println("update SalarySet succ");
					ActionContext.getContext().put("msg", "���Ӹ�λ�ɹ�! :) ");
					return SUCCESS;
				}else{
					ActionContext.getContext().put("msg", "��ϸ���ʵȼ�ʧ��! :(");
					//���¹��ʼ������ ,Ҫɾ����λ
					if(JobService.delJob(jobid)){
						ActionContext.getContext().put("msg", "��ϸ���ʵȼ�ʧ��!,������λû�гɹ�ɾ��... :(");
						return ERROR;
					};
					return ERROR;
				}
			}else{
				ActionContext.getContext().put("msg", "��ȡjobidʧ�� JobAction ");
				return ERROR;
			}
		} else {
			ActionContext.getContext().put("msg", "���ӵĸ�λ�Ѵ��ڻ�����ӳ���û�гɹ�! :( ");
			return ERROR;
		}
	}

	@SuppressWarnings("unchecked")
	public String showJob() {
		// ����ģ��
		if (JobService.dnoInJob(deptno)) {
			jobs = JobService.getJobs(deptno);
			ActionContext.getContext().getSession().put("jobs", jobs);
			System.out.println(deptno);
			return SUCCESS;
		}else{
			ActionContext.getContext().put("msg", "����û�и�λ����!<br><a href=\"deljob.action\">����</a>");
			return ERROR;
		}
	}
	public String delJob() {
		System.out.println("deljob--->"+jobid);
		boolean flag = JobService.delJob(jobid);
		if (flag) {
			ActionContext.getContext().put("msg", "ɾ����λ�ɹ�!<a href=\'deljob.action\'>����</a>");
			return SUCCESS;
		} else {
			ActionContext.getContext().put("msg", "ɾ����λʧ��!");
			return ERROR;
		}
		
	}

}

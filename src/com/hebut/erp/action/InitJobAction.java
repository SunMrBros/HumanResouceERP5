package com.hebut.erp.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import com.hebut.erp.model.JobService;
import com.hebut.erp.pojo.JobDTO;
import com.opensymphony.xwork2.ActionSupport;

public class InitJobAction extends ActionSupport {
	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	private InputStream result;
	private String deptno;
	

	public InputStream getResult() {
		return result;
	}



	public String getDeptno() {
		return deptno;
	}



	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}



	public String execute() throws Exception {
		System.out.println("InitJob !");
		@SuppressWarnings("unchecked")
		List<JobDTO> jobs = JobService.getJobIds(Integer.parseInt(deptno));

		StringBuffer sb = new StringBuffer();
		if (jobs.isEmpty()) {
			sb.append("[{jobid:\"0\",job:\"Ã»ÓÐ¸ÚÎ»\"}]");
		} else {
			sb.append("[");
			for (JobDTO job : jobs) {
				sb.append("{");
				sb.append("jobid");
				sb.append(":");
				sb.append("\"");
				sb.append(job.getJobid());
				sb.append("\"");
				sb.append(",");
				sb.append("job");
				sb.append(":");
				sb.append("\"");
				sb.append(job.getJob());
				sb.append("\"");
				sb.append("}");
				sb.append(",");
			}
			sb = sb.replace(sb.length() - 1, sb.length(), "");
			sb.append("]");
		}

		String str = new String(sb);
		System.out.println(str);
		result = new ByteArrayInputStream(str.getBytes("utf-8"));
		return SUCCESS;
	}

}

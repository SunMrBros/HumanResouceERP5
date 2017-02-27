package com.hebut.erp.action;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import com.hebut.erp.model.QueryService;
import com.hebut.erp.pojo.HumanDTO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class QueryAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int empno;
	private String ename;
	private int jobid;
	private List<HumanDTO> list;
	
	public int getJobid() {
		return jobid;
	}

	public void setJobid(int jobid) {
		this.jobid = jobid;
	}

	public List<HumanDTO> getList() {
		return list;
	}

	public void setList(List<HumanDTO> list) {
		this.list = list;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	@SuppressWarnings("unchecked")
	public String queryById() {
		System.out.println("byId------->" + empno);

		list = QueryService.queryById(empno);

		if (list != null) {
			ActionContext.getContext().put("list", list);
			return SUCCESS;
		} else {

			ActionContext
					.getContext()
					.put("msg",
							"查询员工信息失败<center><a href=\'listAction?pageNow=1\'>返回</a></ceneter>");
			return ERROR;
		}

	}

	@SuppressWarnings("unchecked")
	public String queryByName() {
		String enametrans = null;
		try {
			enametrans = URLDecoder.decode(ename, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("byName-------->" + enametrans);
		list = QueryService.queryByName(enametrans);
		if (list != null) {
			ActionContext.getContext().put("list", list);
			return SUCCESS;
		} else {

			ActionContext
					.getContext()
					.put("msg",
							"查询员工信息失败<center><a href=\'listAction?pageNow=1\'>返回</a></ceneter>");
			return ERROR;
		}
	}

	public String queryByJobId() {
		System.out.println("byJobId-------->" + jobid);
		list = QueryService.queryByJobId(jobid);
		if (list != null) {
			ActionContext.getContext().put("list", list);
			return SUCCESS;
		} else {

			ActionContext
					.getContext()
					.put("msg",
							"查询员工信息失败<center><a href=\'listAction?pageNow=1\'>返回</a></ceneter>");
			return ERROR;
		}

	}
}

package com.hebut.erp.action;

import java.sql.Date;
import java.util.List;

import com.hebut.erp.model.SalaryService;
import com.hebut.erp.util.CountMoney;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SalaryAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date start;
	private Date end;
	private int empno;
	private String empnos;

	public String getEmpnos() {
		return empnos;
	}

	public void setEmpnos(String empnos) {
		this.empnos = empnos;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public String execute() throws Exception {
		List<?> sallist = null;
		System.out.println(empno);
		if ((sallist = SalaryService.querySal(empno)) != null) {
			System.out.println("QuerySal succ!");
			ActionContext.getContext().put("sallist", sallist);
			return SUCCESS;

		} else {
			ActionContext.getContext().put("msg", "查询工资失败!):");
			return ERROR;
		}
	}

	public String salwithDate() throws Exception {
		List<?> sallist = null;
		if ((sallist = SalaryService.querySal(empno, start, end)) != null) {
			System.out.println("QuerySalWithDate succ!");
			ActionContext.getContext().put("sallist", sallist);
			return SUCCESS;

		} else {
			ActionContext.getContext().put("msg", "查询工资失败!):");
			return ERROR;
		}
	}

	public String faGongzi() {
		if(empnos==null){
			ActionContext.getContext().put("msg", "发放工资没有成功,没有合适的员工么??!! :(");
			return ERROR;
			}
		String[] arrempno = empnos.split(",");
		int[] empnos = new int[arrempno.length];
		for (int i = 0; i < arrempno.length; i++) {
			try {
				empnos[i] = Integer.parseInt(arrempno[i].trim());
			} catch (NumberFormatException e) {
				e.printStackTrace();
				ActionContext.getContext().put("msg", "发放工资没有成功,传入数据非法!! :(");
				return ERROR;
			}

		}
		float count = 0;
		if ((count = CountMoney.faGongzi(empnos)) != -1) {
			ActionContext.getContext().put(
					"msg",
					"<p>发放工资成功!! :)</p> <p>累计为" + empnos.length + "位员工发放工资<p><p>共发放人民币:"
							+ count + "元  </p>");
			return SUCCESS;
		} else {
			ActionContext.getContext().put("msg", "发放工资没有成功,哪里出问题了!! :(");
			return ERROR;
		}

	}
}

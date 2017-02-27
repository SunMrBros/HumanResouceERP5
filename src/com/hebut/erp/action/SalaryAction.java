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
			ActionContext.getContext().put("msg", "��ѯ����ʧ��!):");
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
			ActionContext.getContext().put("msg", "��ѯ����ʧ��!):");
			return ERROR;
		}
	}

	public String faGongzi() {
		if(empnos==null){
			ActionContext.getContext().put("msg", "���Ź���û�гɹ�,û�к��ʵ�Ա��ô??!! :(");
			return ERROR;
			}
		String[] arrempno = empnos.split(",");
		int[] empnos = new int[arrempno.length];
		for (int i = 0; i < arrempno.length; i++) {
			try {
				empnos[i] = Integer.parseInt(arrempno[i].trim());
			} catch (NumberFormatException e) {
				e.printStackTrace();
				ActionContext.getContext().put("msg", "���Ź���û�гɹ�,�������ݷǷ�!! :(");
				return ERROR;
			}

		}
		float count = 0;
		if ((count = CountMoney.faGongzi(empnos)) != -1) {
			ActionContext.getContext().put(
					"msg",
					"<p>���Ź��ʳɹ�!! :)</p> <p>�ۼ�Ϊ" + empnos.length + "λԱ�����Ź���<p><p>�����������:"
							+ count + "Ԫ  </p>");
			return SUCCESS;
		} else {
			ActionContext.getContext().put("msg", "���Ź���û�гɹ�,�����������!! :(");
			return ERROR;
		}

	}
}

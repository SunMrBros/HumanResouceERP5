package com.hebut.erp.action;

import com.hebut.erp.model.impl.HumanServiceImpl;
import com.hebut.erp.pojo.HumanShow;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * ���ȸ��ݴ�����empno���������ݿ��в����ӦԱ��,Ȼ����ת��modify.jspҳ��
 * 
 * @author Administrator
 * 
 */
public class ModInitAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int empno;
	
	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}
	
	

	public String execute() throws Exception {
		HumanShow human = HumanServiceImpl.listDetail(empno);
		if (human != null) {
			ActionContext.getContext().put("human", human);
			return SUCCESS;
		} else {

			ActionContext
					.getContext()
					.put("msg",
							"��ѯԱ������,���ܽ����޸Ĳ���!<a href=\"modify.action?empno=\"+empno+\">�������</a>");
			return ERROR;
		}

	}
}

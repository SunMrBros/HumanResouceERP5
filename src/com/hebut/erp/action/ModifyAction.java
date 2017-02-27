package com.hebut.erp.action;

import com.hebut.erp.model.impl.HumanServiceImpl;
import com.hebut.erp.pojo.HumanShow;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

public class ModifyAction implements Action,ModelDriven<HumanShow> {
	private int empno;
	
	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	private HumanShow human=new HumanShow();
	
	
	public HumanShow getHuman() {
		return human;
	}

	public void setHuman(HumanShow human) {
		this.human = human;
	}


	public String execute() throws Exception {
		int empno=human.getEmpno();
		if(HumanServiceImpl.upHuman(human)){
			ActionContext.getContext().put("msg","����Ա����Ϣ�ɹ�!(:<a href=\"huminfo.action?empno="+empno+"\">���ز鿴�޸�</a>");
			return SUCCESS;
		}else{
			ActionContext.getContext().put("msg","����Ա����Ϣʧ��!):<a href=\"modify.action?empno="+empno+"\">�������</a>");
			return ERROR;
		}
	}
	public HumanShow getModel() {
		return human;
	}
	
	
}

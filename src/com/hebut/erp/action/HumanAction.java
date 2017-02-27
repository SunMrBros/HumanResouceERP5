package com.hebut.erp.action;

import com.hebut.erp.model.impl.HumanServiceImpl;
import com.hebut.erp.pojo.HumanShow;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class HumanAction implements Action{
	private int empno;
	private HumanShow human;
	
	
	public HumanShow getHuman() {
		return human;
	}

	public void setHuman(HumanShow human) {
		this.human = human;
	}

	public int getEmpno() {
		return empno;
		
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String execute() throws Exception {
		human=HumanServiceImpl.listDetail(empno);
		if(human!=null){
			return SUCCESS;
		}else{
			ActionContext.getContext().put("msg", "��ѯԱ����ϸ��Ϣʧ��<a href=\"listAction?pageNow=1\">����</a>");
			return ERROR;
		}
	}
	public String delHum(){
		System.out.println("DelHuman---->"+empno);
		if(HumanServiceImpl.delHuman(empno)){
			ActionContext.getContext().put("msg","ɾ��Ա����Ϣ�ɹ�!(:<a href=\"listAction?pageNow=1\">����</a>");
			return SUCCESS;
		}else{
			ActionContext.getContext().put("msg","ɾ��Ա����Ϣʧ��!):<a href=\"listAction?pageNow=1\">����</a>");
			return ERROR;
		}
		
	}

}

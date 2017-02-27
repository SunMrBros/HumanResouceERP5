package com.hebut.erp.action;

import com.hebut.erp.pojo.Admin;
import com.hebut.erp.util.ChangePass;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class PassChagAction implements Action{

	private String password;
	private int id;
	private Admin admin;
	
	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String execute() throws Exception {
		if(ChangePass.changePass(id, password)){
			ActionContext.getContext().put("msg","�޸�����ɹ�");
			return SUCCESS;
		}else{
			ActionContext.getContext().put("msg","�޸�����ʧ��");
			return ERROR;
		}
	}
	public String addMgr(){
		if(ChangePass.addMgr(admin)){
			ActionContext.getContext().put("msg","���ӹ���Ա�ɹ�!  :)");
			return SUCCESS;
		}
		ActionContext.getContext().put("msg","���ӹ���Աû�гɹ�!  :(");
		return ERROR;
	}
	
}

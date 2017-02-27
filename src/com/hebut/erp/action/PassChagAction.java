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
			ActionContext.getContext().put("msg","修改密码成功");
			return SUCCESS;
		}else{
			ActionContext.getContext().put("msg","修改密码失败");
			return ERROR;
		}
	}
	public String addMgr(){
		if(ChangePass.addMgr(admin)){
			ActionContext.getContext().put("msg","增加管理员成功!  :)");
			return SUCCESS;
		}
		ActionContext.getContext().put("msg","增加管理员没有成功!  :(");
		return ERROR;
	}
	
}

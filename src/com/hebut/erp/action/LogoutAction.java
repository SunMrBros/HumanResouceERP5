package com.hebut.erp.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class LogoutAction implements Action {

	public String execute() throws Exception {
		ActionContext.getContext().getApplication().remove("ename");
		
		return SUCCESS;
	}

}

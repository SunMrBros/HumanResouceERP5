package com.hebut.erp.action;

import com.hebut.erp.model.SalaryService;
import com.hebut.erp.pojo.Setting;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class SettingAction implements Action {

	private Setting set;

	public Setting getSet() {
		return set;
	}

	public void setSet(Setting set) {
		this.set = set;
	}

	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public String initSal() {
		set = SalaryService.initSal();
		if (set == null) {
			ActionContext.getContext().put("msg", "初始化工资信息失败!");
			return ERROR;
		} else {
			return SUCCESS;
		}
	}

}

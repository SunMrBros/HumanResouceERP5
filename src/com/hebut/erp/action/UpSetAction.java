package com.hebut.erp.action;

import com.hebut.erp.model.SalaryService;
import com.hebut.erp.pojo.Setting;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class UpSetAction implements Action {

	private Setting setting;

	public Setting getSetting() {
		return setting;
	}

	public void setSetting(Setting setting) {
		this.setting = setting;
	}

	public String execute() throws Exception {

		if (SalaryService.updateSet(setting)) {

			ActionContext.getContext().put("msg", "更新工资信息成功!");
			return SUCCESS;
		} else {

			ActionContext.getContext().put("msg",
					"更新工资信息失败!<a href=\"salinit.action\">返回重试</a>");
			return ERROR;
		}
	}
}

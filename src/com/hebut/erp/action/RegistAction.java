package com.hebut.erp.action;

import com.hebut.erp.model.impl.HumanServiceImpl;
import com.hebut.erp.pojo.HumanInsert;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

public class RegistAction implements Action, ModelDriven<Object> {

	/**
	 * ģ��������ʽ,�ѱ��е����ݸ�ֵ��Human����
	 */
	private HumanInsert human = new HumanInsert();

	public String execute() throws Exception {

		if (HumanServiceImpl.addHuman(human)) {

			ActionContext.getContext().put("msg", "Regist successfully<a href=\"addhuman.jsp\"> ���ؼ������</a>");
			return SUCCESS;
		} else {
			ActionContext.getContext().put("msg", "Regist Error");
			return ERROR;
		}

	}

	public Object getModel() {

		return human;
	}

}

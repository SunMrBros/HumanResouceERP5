package com.hebut.erp.action;

import java.util.ArrayList;
import java.util.List;

import com.hebut.erp.model.CheckService;
import com.hebut.erp.pojo.DayCheckColl;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class DayCheckTongJiAction implements Action {
	List<DayCheckColl> list=new ArrayList<DayCheckColl>();
	
	public List<DayCheckColl> getList() {
		return list;
	}

	public void setList(List<DayCheckColl> list) {
		this.list = list;
	}

	public String execute() throws Exception {
		list=CheckService.getCollection();
		if(list!=null){
			return SUCCESS;
		}else{
			ActionContext.getContext().put("msg","读取数据库出错!");
			return ERROR;
		}
		
	}
	
}

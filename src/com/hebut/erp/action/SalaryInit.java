package com.hebut.erp.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Date;
import java.util.List;

import com.hebut.erp.model.SalaryService;
import com.hebut.erp.pojo.SalaryDTO;
import com.hebut.erp.util.TimeUtil;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
/**
 * 初始化用于生成下拉列表下拉列表
 * @author Administrator
 *
 */
public class SalaryInit implements Action {
	private InputStream result;
	public InputStream getResult() {
		return result;
	}
	public String execute() throws Exception {
		String saljson=SalaryService.salInitJson();
		if(saljson!=null){
			System.out.println(saljson);
			result = new ByteArrayInputStream(saljson.getBytes("utf-8"));
			return SUCCESS;
		}
		ActionContext.getContext().put("msg", "初始化工资等级情况失败!");
		return ERROR;
	}
	public String salCheckInit(){
		Date lastSal=TimeUtil.getSalDate();
		List<SalaryDTO> list=SalaryService.getSalCheckInfo(lastSal);
		if(list!=null){
			ActionContext.getContext().put("listSal", list);
			return SUCCESS;
		}else{
			ActionContext.getContext().put("msg", "查询信息失败");
			return ERROR;
		}
		
	}
}

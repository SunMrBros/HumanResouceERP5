package com.hebut.erp.action;

import java.sql.Time;

import com.hebut.erp.model.CheckService;
import com.hebut.erp.util.TimeUtil;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class InitCheckAction implements Action {
	private int empno;
	
	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String execute() throws Exception {
		
			String emp=(String) ActionContext.getContext().getSession().get("normalempno");
			if(emp==null){
				ActionContext.getContext().getSession().put("msg", "请重新打开登录页重新登录! (:");
				return INPUT;
			}
			System.out.println(empno);
			Time ti = CheckService.getTime();
			
			String ischk=CheckService.isChecked(empno);
			System.out.println("ischeck?-->"+ischk);
			if (ti != null) {
				ActionContext.getContext().getSession().put("ti", ti);
				ActionContext.getContext().put("check", ischk);
				if(TimeUtil.isLate(ti)){
					System.out.println("late");
					ActionContext.getContext().put("latevalue", "Y");
				}else{
					ActionContext.getContext().put("latevalue", "N");
				}
				return SUCCESS;
			}else{
				ActionContext.getContext().getSession().put("msg", "查询时间错误!):");
				return ERROR;
			}
		}

}

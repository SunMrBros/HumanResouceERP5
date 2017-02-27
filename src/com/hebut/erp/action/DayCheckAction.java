package com.hebut.erp.action;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import com.hebut.erp.model.CheckService;
import com.hebut.erp.pojo.DayCheckDTO;
import com.hebut.erp.pojo.TodayCheck;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class DayCheckAction implements Action {
	private Time time;
	private int empno;
	private String islate;
	private String reason;
	
	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public String getIslate() {
		return islate;
	}

	public void setIslate(String islate) {
		this.islate = islate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}


	public String execute() throws Exception {
		
		DayCheckDTO check = new DayCheckDTO();
		check.setEmpno(empno);
		check.setIslate(islate);
		check.setReason(reason);
		boolean isOk = CheckService.check(check);
		if (isOk) {
			ActionContext.getContext().put("msg", "打卡成功!不要重复打卡哦  (:<a href=\"../admin/mid.html\"> 返回</a>");
			return SUCCESS;
		} else {
			ActionContext.getContext().put("msg", "打卡没有成功! ):<a href=\"daycheckinit.action\"> 重试</a>");
			return ERROR;
		}
	}
	public String setTime(){
		System.out.println(time);
		if(time==null){
			ActionContext.getContext().put("msg", "设置考勤时间不对.): <a href=\"setdaycheck.jsp\"></a>" );
			return ERROR;}
		if(CheckService.setTime(time)){
			ActionContext.getContext().put("msg", "设置考勤时间成功.(:" );
			return SUCCESS;
		}else{
			ActionContext.getContext().put("msg", "设置考勤失败.): <a href=\"setdaycheck.jsp\"></a>" );
			return ERROR;
		}
		
	}
	public String todayCheck(){
		Date today=new Date(System.currentTimeMillis());
		List<TodayCheck> list=CheckService.getTodays(today);
		if(list!=null){
			ActionContext.getContext().put("checklist",list);
			return SUCCESS;
		}else{
			ActionContext.getContext().put("msg","查询考勤失败");
			return ERROR;
		}
		
	}
}

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
			ActionContext.getContext().put("msg", "�򿨳ɹ�!��Ҫ�ظ���Ŷ  (:<a href=\"../admin/mid.html\"> ����</a>");
			return SUCCESS;
		} else {
			ActionContext.getContext().put("msg", "��û�гɹ�! ):<a href=\"daycheckinit.action\"> ����</a>");
			return ERROR;
		}
	}
	public String setTime(){
		System.out.println(time);
		if(time==null){
			ActionContext.getContext().put("msg", "���ÿ���ʱ�䲻��.): <a href=\"setdaycheck.jsp\"></a>" );
			return ERROR;}
		if(CheckService.setTime(time)){
			ActionContext.getContext().put("msg", "���ÿ���ʱ��ɹ�.(:" );
			return SUCCESS;
		}else{
			ActionContext.getContext().put("msg", "���ÿ���ʧ��.): <a href=\"setdaycheck.jsp\"></a>" );
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
			ActionContext.getContext().put("msg","��ѯ����ʧ��");
			return ERROR;
		}
		
	}
}

package com.hebut.erp.pojo;
/**
 * 用来向数据库写入的pojo
 * @author Administrator
 *
 */
public class DayCheckDTO {
	private int empno;
	private String islate;
	private String reason;
	
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
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
	
}

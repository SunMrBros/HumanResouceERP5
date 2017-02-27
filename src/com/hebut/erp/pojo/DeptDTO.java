package com.hebut.erp.pojo;

public class DeptDTO {
	private String dname;
	private String location;
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public DeptDTO(String dname,String location){
		this.dname=dname;
		this.location=location;
	}
	public DeptDTO(){}
}

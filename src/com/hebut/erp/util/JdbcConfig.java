package com.hebut.erp.util;

public class JdbcConfig {
	private String driver;
	private String url;
	private String name;
	private String pass;
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public JdbcConfig(){}
	
	public String toString(){
		return "driver="+driver+",url="+url+",name="+name+",pass="+pass;
	}
	
}

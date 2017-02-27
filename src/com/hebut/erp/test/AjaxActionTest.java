package com.hebut.erp.test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import com.opensymphony.xwork2.Action;

public class AjaxActionTest implements Action{
	private InputStream inputStream;
	
	public InputStream getResult() {
		return inputStream;
	}
	

	public String execute() throws Exception {
		
		inputStream=new ByteArrayInputStream("from struts2".getBytes());
		return SUCCESS;
	}

}

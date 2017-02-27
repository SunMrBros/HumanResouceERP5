package com.hebut.erp.action;


import java.util.List;

import com.hebut.erp.model.ListAllHumanInfo;
import com.hebut.erp.util.PageCount;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class PageAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 获取当前页的页码数
	int pageNow;

	public int getPageNow() {
		return pageNow;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}

	public String pageUp() throws Exception {
		int listPage=0;
		if(pageNow<=1){
			listPage=1;
		}else{
			listPage=pageNow-1;
			pageNow=listPage;
		}
		List<?> list=ListAllHumanInfo.listEmp(listPage);
		if (list != null) {
			
			ActionContext.getContext().put("list", list);
			
			return SUCCESS;
		} else {
			ActionContext.getContext().put("msg", "读取数据库错误");
			return ERROR;
		}
		
	}

	public String pageDown() throws Exception {
		int totalPage=PageCount.getPage("human");
		
		if(pageNow>=totalPage){
			pageNow=totalPage;
		}else{
			pageNow+=1;
		}
		
		List<?> list=ListAllHumanInfo.listEmp(pageNow);
		if (list != null) {
			
			ActionContext.getContext().put("list", list);
			
			return SUCCESS;
		} else {
			ActionContext.getContext().put("msg2", "读取数据库错误");
			ActionContext.getContext().put("msg", "读取数据库错误");
			return ERROR;
		}
		
	}

}

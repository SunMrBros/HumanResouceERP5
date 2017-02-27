package com.hebut.erp.action;

import java.util.List;

import com.hebut.erp.model.ListAllHumanInfo;
import com.hebut.erp.pojo.Human;
import com.hebut.erp.pojo.HumanDTO;
import com.hebut.erp.util.PageCount;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListAction extends ActionSupport {

	/**
	 * 根据当前页数查询数据库,并返回到前台 员工信息
	 */
	private static final long serialVersionUID = 1L;
	List<Human> list;
	HumanDTO humandto;

	public HumanDTO getHumandto() {
		return humandto;
	}

	public void setHumandto(HumanDTO humandto) {
		this.humandto = humandto;
	}

	int pageNow;

	public List<Human> getList() {
		return list;
	}

	public void setList(List<Human> list) {
		this.list = list;
	}

	public int getPageNow() {
		return pageNow;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}

	@SuppressWarnings("unchecked")
	public String execute() throws Exception {

		int pageCount = PageCount.getPage("human");
		ActionContext.getContext().getApplication().put("pageCount", pageCount);
		list = ListAllHumanInfo.listEmp(pageNow);
		if (list != null) {
			return SUCCESS;
		} else {
			ActionContext.getContext().put("msg", "读取数据库错误");
			return ERROR;
		}

	}

}

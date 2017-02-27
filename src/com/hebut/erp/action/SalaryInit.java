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
 * ��ʼ���������������б������б�
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
		ActionContext.getContext().put("msg", "��ʼ�����ʵȼ����ʧ��!");
		return ERROR;
	}
	public String salCheckInit(){
		Date lastSal=TimeUtil.getSalDate();
		List<SalaryDTO> list=SalaryService.getSalCheckInfo(lastSal);
		if(list!=null){
			ActionContext.getContext().put("listSal", list);
			return SUCCESS;
		}else{
			ActionContext.getContext().put("msg", "��ѯ��Ϣʧ��");
			return ERROR;
		}
		
	}
}

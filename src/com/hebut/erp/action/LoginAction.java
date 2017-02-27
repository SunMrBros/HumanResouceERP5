package com.hebut.erp.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.hebut.erp.model.LoginModel;
import com.hebut.erp.model.impl.HumanServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class LoginAction extends ActionSupport {

	private String name;
	private String pass;
	private String checkCode;

	public String getCheckCode() {
		return checkCode;
	}

	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
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

	@Override
	public String execute() throws Exception {
//		String n=(String) ActionContext.getContext().getSession().get("name");
//		System.out.println(n+"llll");
		//�������Ϊ��,������Ա������д�������ͨԱ����¼
		if(HumanServiceImpl.isExists(name,pass)){
			ActionContext.getContext().getSession().put("name",name);
			ActionContext.getContext().getSession().put("normalempno",pass);
			return "normal";
			
		}else{
			
			int id = 0;
		HttpSession session = ServletActionContext.getRequest().getSession();
		String checkCode2 = (String) session.getAttribute("checkCode");
		if (checkCode.equals(checkCode2)) {

			if (((id = LoginModel.checkUser(name, pass)) != 0)) {
				ActionContext.getContext().getSession().put("name", name);
				ActionContext.getContext().getSession().put("id", id);
				
				return SUCCESS;
			} else {
				ActionContext.getContext().put("msg2", "<center style=\"margin-top:200px;\">����Ա�û������ڻ����벻��ȷ<a href=\"login.jsp\"/>" +
						"���µ�¼</a></center>");
				return ERROR;
			}
		}else{
			ActionContext.getContext().getApplication().put("yanzm", "��������֤��");
			return INPUT;
		}
		}
		
	}
}

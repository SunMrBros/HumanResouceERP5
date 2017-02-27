package com.hebut.erp.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import com.hebut.erp.model.DeptService;
import com.hebut.erp.pojo.Dept;
import com.opensymphony.xwork2.ActionSupport;

public class InitDeptAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private InputStream result;
	

	public InputStream getResult() {
		return result;
	}


	public String execute() throws Exception {

		// 会查询出部门的所有信息
		List<Dept> deptlist = DeptService.listDept();
	
			
			StringBuffer sb = new StringBuffer();

			sb.append("[");
			for (Dept dept : deptlist) {
				sb.append("{");
				sb.append("deptno");
				sb.append(":");
				sb.append("\"");
				sb.append(dept.getDeptno());
				sb.append("\"");
				sb.append(",");
				sb.append("dname");
				sb.append(":");
				sb.append("\"");
				sb.append(dept.getDname());
				sb.append("\"");
				sb.append("}");
				sb.append(",");
			}
			sb = sb.replace(sb.length() - 1, sb.length(), "");
			sb.append("]");
		
		String str = new String(sb);
		System.out.println(str = new String(sb));
		result = new ByteArrayInputStream(str.getBytes("utf-8"));
		return SUCCESS;

	}

}

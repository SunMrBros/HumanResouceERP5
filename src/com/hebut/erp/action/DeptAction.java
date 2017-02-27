package com.hebut.erp.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
//import java.io.StringBufferInputStream;
import java.util.List;

import com.hebut.erp.model.DeptService;
import com.hebut.erp.pojo.Dept;
import com.hebut.erp.pojo.DeptAndJob;
import com.hebut.erp.pojo.DeptDTO;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class DeptAction implements Action {
	private int deptno;
	private String dname;
	private String location;
	private String deptchk;
	private List<?> deptlist;
	public String getDeptchk() {
		return deptchk;
	}

	public void setDeptchk(String deptchk) {
		this.deptchk = deptchk;
	}

	private float t;

	public float getT() {
		return t;
	}

	public void setT(float t) {
		this.t = t;
	}

	private InputStream inputStream;

	public InputStream getResult() {
		return inputStream;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDname() {
		return dname;
	}

	public DeptDTO getDept() {
		return dept;
	}

	public void setDept(DeptDTO dept) {
		this.dept = dept;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	

	public List<?> getDeptlist() {
		return deptlist;
	}

	public void setDeptlist(List<?> deptlist) {
		this.deptlist = deptlist;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	DeptDTO dept = new DeptDTO();

	public String execute() throws Exception {

		deptlist = DeptService.listDept();
		if(deptlist==null){
			ActionContext.getContext().put("msg", "初始化部门信息失败");
			return ERROR;
		}else{}
		ActionContext.getContext().put("deptlist", deptlist);
		return SUCCESS;
	}

	public String delDept() {
		System.out.println(deptchk);
		String[] deptnos=deptchk.split(",");
		if (DeptService.delDept(deptnos)) {
			ActionContext.getContext().put("msg", "删除部门成功");
			return SUCCESS;
		} else {
			ActionContext.getContext().put("msg", "删除部门失败");
			return ERROR;
		}
	}

	public String addDept() {
		DeptDTO dept = new DeptDTO();
		System.out.println(t);
		dept.setDname(dname);
		dept.setLocation(location);
		if (!DeptService.isExists(dept)) {
			if (DeptService.addDept(dept)) {
				inputStream = new ByteArrayInputStream("1".getBytes());

				return SUCCESS;
			} else {
				inputStream = new ByteArrayInputStream("0".getBytes());
				return SUCCESS;
			}
		} else {
			inputStream = new ByteArrayInputStream("2".getBytes());
			return SUCCESS;
		}

	}

//	public String listDept() {
//		// 返回xml流
//		List<Dept> listDept = DeptService.listDept();
//		StringBuffer sb = new StringBuffer();
//		//sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
//		sb.append("\r\n");
//		sb.append("<depts>");
//		sb.append("\r\n");
//		for (Dept d : listDept) {
//			sb.append("<dept>");
//			sb.append("\r\n");
//			sb.append("<deptno>");
//			sb.append(d.getDeptno());
//			sb.append("<deptno>");
//			sb.append("\r\n");
//			sb.append("<dname>");
//			sb.append(d.getDname());
//			sb.append("</dname>");
//			sb.append("\r\n");
//			sb.append("</dept>");
//			sb.append("\r\n");
//
//		}
//		sb.append("</depts>");
//		String res = new String(sb);
//		inputStream = new StringBufferInputStream(TransCode.transCoding(res));
//		return SUCCESS;
//	}
	public String showDept(){
		List<Dept> list=DeptService.listDept();
		if(list!=null){
			ActionContext.getContext().put("showDept", list);
		
			return SUCCESS;
		}else{
			ActionContext.getContext().put("msg","查询部门信息失败");
			return ERROR;
		}
		
	}
	public String listInfo(){
		List<DeptAndJob> list=DeptService.listDeptAndJob();
		
		if(list!=null){
			ActionContext.getContext().put("deptinfo", list);
			return SUCCESS;
		}else{
			ActionContext.getContext().put("msg","没有查询到任何查询部门信息.");
			return ERROR;
		}
		
	}

}

package com.hebut.erp.pojo;
/**
 * ������ʽ���ʺ������
 * @author Administrator
 *
 */
public class HumInfo {
	private int empno;
	private String name;
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "HumInfo [empno=" + empno + ", name=" + name + "]";
	}
	
}

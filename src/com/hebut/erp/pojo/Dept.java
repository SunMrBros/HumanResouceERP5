package com.hebut.erp.pojo;

public class Dept {
	private int deptno;
	private String dname;
	private String location;

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

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

	public Dept(int deptno, String dname, String location) {
		this.deptno = deptno;
		this.dname = dname;
		this.location = location;
	}

	// ÷ÿ–¥equals∑Ω∑®

	public Dept() {
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		if (obj == this) {
			return true;
		}
		if (!(obj instanceof Dept)) {
			return false;
		} else {
			Dept dept = (Dept) obj;
			if (dept.getDname().equals(this.getDname())
					&& dept.getLocation().equals(this.getLocation())) {
				return true;
			} else {
				return false;
			}
		}

	}

	public String toString() {
		return "Dept [id=" + deptno + ", deptname=" + dname + ", location="
				+ location + "]";
	}

}

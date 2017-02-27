package com.hebut.erp.pojo;

public class Setting {
	
	//base1 | base2 | base3 | base4 | other | quanqin | fakuan
	private float base1;
	private float base2;
	private float base3;
	private float base4;
	private float other;
	private float quanqin;
	private float fakuan;
	public float getBase1() {
		return base1;
	}
	public void setBase1(float base1) {
		this.base1 = base1;
	}
	public float getBase2() {
		return base2;
	}
	public void setBase2(float base2) {
		this.base2 = base2;
	}
	public float getBase3() {
		return base3;
	}
	public void setBase3(float base3) {
		this.base3 = base3;
	}
	public float getBase4() {
		return base4;
	}
	public void setBase4(float base4) {
		this.base4 = base4;
	}
	public float getOther() {
		return other;
	}
	public void setOther(float other) {
		this.other = other;
	}
	public float getQuanqin() {
		return quanqin;
	}
	public void setQuanqin(float quanqin) {
		this.quanqin = quanqin;
	}
	public float getFakuan() {
		return fakuan;
	}
	public void setFakuan(float fakuan) {
		this.fakuan = fakuan;
	}
	public Setting(float base1, float base2, float base3, float base4,
			float other, float quanqin, float fakuan) {
		super();
		this.base1 = base1;
		this.base2 = base2;
		this.base3 = base3;
		this.base4 = base4;
		this.other = other;
		this.quanqin = quanqin;
		this.fakuan = fakuan;
	}
	public Setting() {
		super();
	}
	@Override
	public String toString() {
		return "Setting [base1=" + base1 + ", base2=" + base2 + ", base3="
				+ base3 + ", base4=" + base4 + ", other=" + other
				+ ", quanqin=" + quanqin + ", fakuan=" + fakuan + "]";
	}
	
	
}

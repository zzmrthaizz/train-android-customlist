package com.example.train_android_customlist1;

public class Employee {

	private String hoten;
	private String maso;
	private boolean gioitinh;
	
	public Employee() {
		
	}

	public Employee(String hoten, String maso, boolean gioitinh) {
		this.hoten = hoten;
		this.maso = maso;
		this.gioitinh = gioitinh;
	}
	
	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public String getMaso() {
		return maso;
	}

	public void setMaso(String maso) {
		this.maso = maso;
	}

	public boolean isGioitinh() {
		return gioitinh;
	}

	public void setGioitinh(boolean gioitinh) {
		this.gioitinh = gioitinh;
	}

}

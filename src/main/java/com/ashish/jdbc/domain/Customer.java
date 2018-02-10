package com.ashish.jdbc.domain;

import java.util.Date;

public class Customer {
	
	private Integer custid;
	private String custname;
	private String mobile;
	private Double deposit;
	private Date reg_date;
	
	public Integer getCustid() {
	return custid;
	}
	public void setCustid(Integer custid) {
	this.custid = custid;
	}
	public String getCustname() {
	return custname;
	}
	public void setCustname(String custname) {
	this.custname = custname;
	}
	public String getMobile() {
	return mobile;
	}
	public void setMobile(String mobile) {
	this.mobile = mobile;
	}
	public Double getDeposit() {
	return deposit;
	}
	public void setDeposit(Double deposit) {
	this.deposit = deposit;
	}
	public Date getReg_date() {
	return reg_date;
	}
	public void setReg_date(Date reg_date) {
	this.reg_date = reg_date;
	}
	
	@Override
	public String toString() {
		return "Customer [custid=" + custid + ", custname=" + custname + ", mobile=" + mobile + ", deposit=" + deposit
				+ ", reg_date=" + reg_date + "]";
	}
	
	


}

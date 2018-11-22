package com.DugmaHadash.com.service.dbentity;

import java.util.Collection;

public class Company {
	private long companyId;
	private String companyName ;
	private String companyPassword;
	private String companyEmail;
	private Collection <Coupon> coupons;
	
	public long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(long company_id) {
		this.companyId = company_id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String company_name) {
		this.companyName = company_name;
	}
	public String getCompanyPassword() {
		return companyPassword;
	}
	public void setCompanyPassword(String company_password) {
		this.companyPassword = company_password;
	}
	public String getCompanyEmail() {
		return companyEmail;
	}
	public void setCompanyEmail(String company_email) {
		this.companyEmail = company_email;
	}
	@Override
	public String toString() {
		return "Company [company_id=" + companyId + ", company_name=" + companyName + ", company_password="
				+ companyPassword + ", company_email=" + companyEmail + ", coupons=" + coupons + "]";
	}
	
	
	
	
	
	

}

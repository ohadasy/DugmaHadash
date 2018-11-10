package com.DugmaHadash.com.service;

import java.util.Date;
public class Coupon {
	
	private long id;
	private String couponTitle ;
	private Date couponStartDate = new Date();
	private Date couponEndDate = new Date();
	private int couponAmount ; 
	private CouponType couponType;
	private String message;
	private double couponPrice;
	private String couponImage;
	
	public long getId() {
		return id;
	}
	public void setId(long coupon_id) {
		this.id = coupon_id;
	}
	public String getCouponTitle() {
		return couponTitle;
	}
	public void setCouponTitle(String coupon_title) {
		this.couponTitle = coupon_title;
	}
	public Date getCouponStartDate() {
		return couponStartDate;
	}
	public void setCouponStartDate(Date coupon_start_date) {
		this.couponStartDate = coupon_start_date;
	}
	public Date getCouponEndDate() {
		return couponEndDate;
	}
	public void setCouponEndDate(Date coupon_end_date) {
		this.couponEndDate = coupon_end_date;
	}
	public int getCouponAmount() {
		return couponAmount;
	}
	public void setCouponAmount(int coupon_amount) {
		this.couponAmount = coupon_amount;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public double getCouponPrice() {
		return couponPrice;
	}
	public void setCouponPrice(double coupon_price) {
		this.couponPrice = coupon_price;
	}
	public String getCouponImage() {
		return couponImage;
	}
	public void setCouponImage(String coupon_image) {
		this.couponImage = coupon_image;
	}
	public CouponType getCouponType() {
		return couponType;
	}
	public void setCouponType(CouponType couponType) {
		this.couponType = couponType;
	}
	@Override
	public String toString() {
		return "Coupon [id=" + id + ", couponTitle=" + couponTitle + ", couponStartDate=" + couponStartDate
				+ ", couponEndDate=" + couponEndDate + ", couponAmount=" + couponAmount + ", couponType=" + couponType
				+ ", message=" + message + ", couponPrice=" + couponPrice + ", couponImage=" + couponImage + "]";
	}
	
	


}



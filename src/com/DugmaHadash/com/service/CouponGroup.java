package com.DugmaHadash.com.service;

public class CouponGroup implements DBobject {
	private int groupnum;
	private String groupName;
	
	public CouponGroup() {

	}

	public CouponGroup(int groupnum, String groupName) {
		super();
		this.groupnum = groupnum;
		this.groupName = groupName;
	}

	public int getGroupnum() {
		return groupnum;
	}

	public void setGroupnum(int groupnum) {
		this.groupnum = groupnum;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@Override
	public String toString() {
		return "CouponGroup [groupnum=" + groupnum + ", groupName=" + groupName + "]";
	}

	@Override
	public void save() {
//		String query = "INSERT INTO"
		
	}

	@Override
	public void getByID() {
		// TODO Auto-generated method stub
		
	}
	
	


}
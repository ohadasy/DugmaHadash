package com.DugmaHadash.com.service.dao;

public class CompanyFacade implements CouponClientFacade {

	@Override
	public boolean login(String name, String password, ClientType clientType) {
		// TODO Auto-generated method stub
		if ("admin".equals(name) && "1234".equals(password)) {
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}

}

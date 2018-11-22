package com.DugmaHadash.com.service.dao;

public class AdminFacade implements CouponClientFacade {

	@Override
	public boolean login(String name, String password, ClientType clientType) {

		if ("admin".equals(name) && "1234".equals(password)) {
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}

}

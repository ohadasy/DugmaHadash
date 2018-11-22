package com.DugmaHadash.com.service.dao;

import com.DugmaHadash.com.service.CouponException;

public class CouponSystem {

	public CouponClientFacade login(String name, String password, ClientType clientType) {
		//
		switch (clientType) {
			case ADMIN: {
				AdminFacade adminFacade = new AdminFacade();
				boolean isAuthenticated = adminFacade.login(name, password, clientType);
				if (isAuthenticated) {
				return adminFacade;
				}
			}
			break;
			// case COMPANY:
			//// // go to DB
			//// if ("company".equals(name) && "1234".equals(password)) {
			//// return new CompanyFacade();
			//// }
			// break;
			case CUSTOMER: {
				CustomerFacade customerFacade = new CustomerFacade();
				boolean isAuthenticated = customerFacade.login(name, password, clientType);
				if (isAuthenticated) {
					return customerFacade;
				}
			}
			break;
		}
		throw new CouponException("didn't found user in the login");
	}

}

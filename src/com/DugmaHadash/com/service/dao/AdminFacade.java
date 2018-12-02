package com.DugmaHadash.com.service.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.DugmaHadash.com.service.ConnectionPool;
import com.DugmaHadash.com.service.dbentity.Coupon;

public class AdminFacade implements CouponClientFacade {

	@Override
	public boolean login(String name, String password, ClientType clientType) {

		if ("admin".equals(name) && "1234".equals(password)) {
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}

	public void addNewCoupon(Coupon coupon) {	
		Connection connection = ConnectionPool.getInstance().getConnection();
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(
					"INSERT INTO `coupon` (`ID`, `TITLE`, `START_DATE`, `END_DATE`, `AMOUNT`, `TYPE`, `MESSAGE`, `PRICE`, `IMAGE`) "
					+ "VALUES ('32', 'xdx', '2018-11-01', '2018-11-29', '280', 'electric', 'fgffggjhfg', '200', NULL) ");
			prepareStatement.setLong(1, coupon.getId());
			prepareStatement.setString(2, coupon.getCouponTitle());
			prepareStatement.setDate(3, (Date) coupon.getCouponStartDate());
			prepareStatement.setDate(4, (Date) coupon.getCouponEndDate());
			prepareStatement.setInt(5, coupon.getCouponAmount());
			prepareStatement.setString(6, coupon.getCouponType() != null ? coupon.getCouponType().name() : null);
			prepareStatement.setString(7, coupon.getMessage());
			prepareStatement.setDouble(8, coupon.getCouponPrice());
			prepareStatement.setString(9, coupon.getCouponImage());
			prepareStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().returnconnection(connection);
		}
	}
	
	
}

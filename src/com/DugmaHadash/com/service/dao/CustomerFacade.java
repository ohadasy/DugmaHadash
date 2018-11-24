package com.DugmaHadash.com.service.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.DugmaHadash.com.service.ConnectionPool;
import com.DugmaHadash.com.service.MySqlHandler;
import com.DugmaHadash.com.service.dbentity.Coupon;
import com.DugmaHadash.com.service.dbentity.CouponType;

public class CustomerFacade implements CouponClientFacade {

	private String customerID;
	private String customerName;
	

	@Override
	public boolean login(String name, String password, ClientType clientType) {
		Connection connection = ConnectionPool.getInstance().getConnection();
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(
					"select cust_name , id , password from `customers` where cust_name = ? and password = ? ;");
			prepareStatement.setString(1, name);
			prepareStatement.setString(2, password);
			ResultSet result = prepareStatement.executeQuery();
			if (result.next()) {
				customerName = result.getString("cust_name");
				customerID = result.getString("id");
				String customerPassword = result.getString("password");
				return true;
			}
			return false;
			//
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().returnconnection(connection);
		}

		return false;
	}
	
	public List<Coupon> getCustomeCoupons(String customerID) 
	{
		Connection connection = ConnectionPool.getInstance().getConnection();
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(
					"select cust.coupon_id , cust.cust_id , cpn.Title , cpn.amount  from `customer_coupon` cust , `coupon` cpn "
					+ "where cust.cust_id = ? and cust.coupon_id = cpn.id ;");
			prepareStatement.setLong(1, Long.valueOf(customerID));
			ResultSet result = prepareStatement.executeQuery();
			List<Coupon> coupons = new ArrayList<>(); 
			while (result.next()) {
				Coupon coupon = new Coupon();
				coupon.setId(result.getLong("cust.coupon_id"));
				coupon.setCouponAmount(result.getInt("cpn.amount"));
				coupon.setCouponTitle(result.getString("cpn.Title"));
				coupons.add(coupon);
			}
			return coupons;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().returnconnection(connection);
		}
		return new ArrayList<>();
	}
	
	public List<Coupon> getAddCoupons4Customer(String customerID) 
	{
		Connection connection = ConnectionPool.getInstance().getConnection();
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(
					"select distinct cpn.id ,  cpn.Title , cpn.start_date , cpn.end_date , cpn.amount,"
					+ "cpn.type , cpn.message , cpn.price , cpn.image "
					+ "from `customer_coupon` cust , `coupon` cpn "
					+ "where cust.cust_id = ? "
					+ "AND cpn.id NOT IN (SELECT coupon_id FROM `customer_coupon`);");
	
			
			
			
			prepareStatement.setLong(1, Long.valueOf(customerID));
			ResultSet result = prepareStatement.executeQuery();
			List<Coupon> coupons = new ArrayList<>(); 
			while (result.next()) {
				Coupon coupon = new Coupon();
				coupon.setId(result.getLong("cpn.id"));
				coupon.setCouponTitle(result.getString("cpn.Title"));
				coupon.setCouponStartDate(result.getDate("cpn.start_date"));
				coupon.setCouponEndDate(result.getDate("cpn.end_date"));
				coupon.setCouponAmount(result.getInt("cpn.amount"));
//				coupon.setCouponType(result.getString(change));
				coupon.setMessage(result.getString("cpn.message"));
				coupon.setCouponPrice(result.getDouble("cpn.price"));
				coupon.setCouponImage(result.getString("cpn.image"));
				
				coupons.add(coupon);
			}
			return coupons;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().returnconnection(connection);
		}
		return new ArrayList<>();
	}

	public String getCustomerID() {
		return customerID;
	}
	public String getCustomerName() {
		return customerName;
	}

}

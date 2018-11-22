<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<%@ page import="com.DugmaHadash.com.service.dao.*"%>
<%@ page import="com.DugmaHadash.com.service.dbentity.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
<title>Insert title here</title>
</head>
<body>
	<div class="customerCoupons">
		<%
			CustomerFacade customerFacade = (CustomerFacade) session.getAttribute("customerFacade");
			String customerId = customerFacade.getCustomerID();
			List<Coupon> coupons = customerFacade.getCustomeCoupons(customerId);
		%>
		<table>
		 		 <tr>
 		  <th>ID</th>
		  <th>couponTitle</th>
		  <th>couponStartDate</th>
		  <th>couponEndDate</th>
		  <th>couponAmount</th>
		  <th>couponType</th>
		  <th>message</th>
		  <th>couponPrice</th>
		  <th>couponImage</th>		  
 		 </tr>
		<%
		for (Coupon coupon : coupons) {
			%>
			
	 		 <tr>
	 		  <td><%=coupon.getId() %></td>
			  <td><%=coupon.getCouponTitle() %></td>
			  <td><%=coupon.getCouponStartDate() %></td>
			  <td><%=coupon.getCouponEndDate() %></td>
			  <td><%=coupon.getCouponAmount() %></td>
			  <td><%=coupon.getCouponType() %></td>
			  <td><%=coupon.getMessage() %></td>
			  <td><%=coupon.getCouponPrice() %></td>
			  <td><%=coupon.getCouponImage() %></td>		  
	 		 </tr>
	<%
		}
		%>
		
		</table>

		<label for="uname"><b>Username</b></label> <input type="text"
			placeholder="Enter Username" name="uname" required> </label>
	</div>
</body>
</html>
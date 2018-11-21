<%@ page language="java" contentType="text/html; charset=windows-1255"
	pageEncoding="windows-1255"%>
<%@ page import="com.DugmaHadash.com.service.dao.*"%>
<%@ page import="com.DugmaHadash.com.service.dbentity.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1255">
<title>Insert title here</title>
</head>
<body>
	<%
		try {
			CouponSystem couponSystem = new CouponSystem();
			String name1 = request.getParameter("uname");
			String password1 = request.getParameter("psw");
			ClientType clientType = ClientType.valueOf(request.getParameter("clientType"));
			CouponClientFacade couponClientFacade = couponSystem.login(name1, password1, clientType);

			switch (clientType) {
				case ADMIN: {
					AdminFacade adminFacade = (AdminFacade) couponClientFacade;

				}
				break;

				case CUSTOMER: {
					CustomerFacade customerFacade = (CustomerFacade) couponClientFacade;
	%>
	<h1>
		Hello
		<%=customerFacade.getCustomerName()%>
		from
		<%=request.getParameter("clientType")%>
		with ID
		<%=customerFacade.getCustomerID()%>
	</h1>

	<div class="customerCoupons">
		<%
			
			String customerId = customerFacade.getCustomerID();
			List<Coupon> coupons = customerFacade.getCustomeCoupons(customerId);
		%>
<%=coupons%>

		<label for="uname"><b>Username</b></label> <input type="text"
			placeholder="Enter Username" name="uname" required> </label>
	</div>
	<%
	
		}
				break;
			}

		} catch (Throwable t) {

		}
	%>
</body>
</html>
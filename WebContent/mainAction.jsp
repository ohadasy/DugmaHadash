<%@ page language="java" contentType="text/html; charset=windows-1255"
	pageEncoding="windows-1255"%>
<%@ page import="com.DugmaHadash.com.service.dao.*"%>
<%@ page import="com.DugmaHadash.com.service.dbentity.*"%>
<%@ page import="com.DugmaHadash.com.service.CouponException" %>
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
					session.setAttribute("adminFacade", adminFacade);
					
		%>
		<h1>
			Hello admin !
		<form action="adminAddCoupon.jsp" method="post">
		<button type="submit" class="adminrcpn">add coupons into the system</button>
	
	</form>
		</h1>
		<%
				}
				break;

				case CUSTOMER: {
					CustomerFacade customerFacade = (CustomerFacade) couponClientFacade;
					session.setAttribute("customerFacade", customerFacade);
	%>
	<h1>
		Hello
		<%=customerFacade.getCustomerName()%>
		from
		<%=request.getParameter("clientType")%>
		with ID
		<%=customerFacade.getCustomerID()%>
	</h1>
	
	<form action="customerCoupons.jsp" method="post">
		<button type="submit" class="customercpn">extract coupons for customer</button>
	
	</form>
	
	<br>
	
	<form action="addCoupons4Customer.jsp" method="post">
		<button type="submit" class="addcoupons">add coupons for customer</button>
	
	</form>
	

	<%
	
				}
				break;
			}

		} catch (CouponException e) {
	%>
	<h1>
		Hello
		<%=e.getMessage()%>

	</h1>
				
	<%

		} catch (Throwable t) {
	%>
	<h1>
			General error: 
			<%=t.getMessage()%>

	</h1>
						
	<%
		}
	%>
</body>
</html>
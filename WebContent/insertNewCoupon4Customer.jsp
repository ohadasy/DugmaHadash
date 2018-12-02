<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<%@ page import="com.DugmaHadash.com.service.dao.*"%>
<%@ page import="com.DugmaHadash.com.service.dbentity.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
<title>Insert title here</title>
</head>
<body>
  i bought your new coupon

	<div class="insertNewCoupon">
		<%
			CustomerFacade customerFacade = (CustomerFacade) session.getAttribute("customerFacade");
			String customerId = customerFacade.getCustomerID();
			long coupon_id = Long.parseLong(request.getParameter("id"));
			customerFacade.addNewCoupon4Customer(coupon_id, Long.parseLong(customerId));
		%>	
		<h1>
		<%=customerFacade.getCustomerName()%>
		with id  
		<%=customerFacade.getCustomerID()%>
		bought coupon
		<%=request.getParameter("id")%>
	</h1>
	
	</div>
	
	
	
	
</body>
</html>
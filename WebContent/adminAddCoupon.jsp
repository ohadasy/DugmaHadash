<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<%@ page import="com.DugmaHadash.com.service.dao.*"%>
<%@ page import="com.DugmaHadash.com.service.dbentity.*"%>
<%@ page import="com.DugmaHadash.com.service.CouponException" %>
<%@ page import="java.util.*"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
<title>Insert title here</title>
</head>
<body>
<%
if (request.getParameter("id") != null &&
    request.getParameter("title") != null)
{
	//do the add
	AdminFacade adminFacade = (AdminFacade) session.getAttribute("adminFacade");
	Coupon coupon = new Coupon();
	coupon.setId(Long.parseLong(request.getParameter("id")));
	coupon.setCouponTitle(request.getParameter("title"));
	adminFacade.addNewCoupon(coupon); 
}
else
{
%>
	<div class="addNewCoupon">
	<form action="adminAddCoupon.jsp">
   id : <input type="text" name="id"><br>
   Title :<input type="text" name="title"><br>
   Start date: <input type="text" name="startdate"><br>
   End date: <input type="text" name="enddate"><br>
   Amount: <input type="text" name="amount"><br>
   Type: <input type="text" name="type"><br>
   Message: <input type="text" name="Message"><br>
   Price: <input type="text" name="Price"><br>
   Image: <input type="text" name="Image"><br>
   
   <input type="submit" value="Submit">
</form>
	</div>
<%
}
%>
</body>
</html>
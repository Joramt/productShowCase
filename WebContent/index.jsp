<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="assets.jsp" %>
<% if(request.getAttribute("pdts_homme") == null){
	request.getRequestDispatcher("getProduitIndex").forward(request, response);
	
} %>
<title>WELCOME TO CLOTHERS</title>
</head>
<body class="index">

<div class="index-cover">
	<img src="assets/img/index-bg.jpg" alt="tuxedo" />
	<div class="button">
		<a href="#wrapper" id="discover-men">Découvrez nos produits</a>
	</div>
</div>
	<%@ include file="menu.jsp" %>
<div id="wrapper" class="wrapper">

	<%@ include file="recent_products.jsp" %>
</div>
	<%@ include file="footer.jsp" %>
</body>
</html>	
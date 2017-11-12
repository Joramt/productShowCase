<%@page import="pkgUtils.Constantes"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<% String error_msg = (String) request.getAttribute(Constantes.ERROR_KEY); 
   boolean isThereAnError = ((error_msg != null ) ? true: false);
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="assets.jsp" %>
<title>Insert title here</title>
</head>
<body>
<%@ include file="menu.jsp" %>
<% if(isThereAnError){ %>
<%="<h2 class='form-error'>"+ error_msg + "</h2>" %>
<% } %>
<div id="form">
<%@ include file="form.jsp" %>
</div>
<div class="form">
<%@ include file="footer.jsp" %>
</div>
<script src="assets/js/script.js"></script>
</body>
</html>
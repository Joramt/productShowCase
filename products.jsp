<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CLOTHERS - PRODUCTS</title>
<%@ include file="assets.jsp" %>
<% if(request.getAttribute("pdts_homme") == null){
	request.setAttribute(Constantes.REDIRECT_KEY, "products.jsp");
	request.getRequestDispatcher("getProduitIndex").forward(request, response);
} %>

<% String category = request.getParameter("cat");



// Si on a une categorie mais que l'attribut RESULT_PRODUCT_BY_CATEGORY est vide
if((category != null) && (request.getAttribute(Constantes.RESULT_PRODUCT_BY_CATEGORY_KEY) == null)) {
	// On set l'attribut catégorie ( cette page n'est inclus que lorsque le param ?cat="" existe)
	request.setAttribute(Constantes.CATEGORY_PRODUCT_KEY, category);

	// On redirige vers la page qui va se charger d'obtenir des produits selon le setAttributes
	request.getRequestDispatcher("ProduitsByCategorie").forward(request, response);
}






%>
</head>
<body>
<%@ include file="menu.jsp" %>

<div id="wrapper" class="wrapper">

<% if(category == null){ %>
	<%@ include file="recent_products.jsp" %>
<%}else  { %>
	<%@ include file="products_category.jsp" %>
<% } %>

</div>
<%@ include file="footer.jsp" %>
</body>
</html>
<%@page import="pkgAction.ProduitAction"%>
<%@page import="com.sun.corba.se.impl.encoding.OSFCodeSetRegistry.Entry"%>
<%@page import="pkgUtils.Constantes"%>
<%@page import="mesBeans.LigneCommande"%>
<%@page import="java.util.HashMap"%>
<%@page import="pkgUtils.GestionSession"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="java.io.IOException"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Map"%>
<%@page import="java.text.DecimalFormat"%>

<%@page import="javax.servlet.ServletException"%>
<%@page import="javax.servlet.annotation.WebServlet"%>
<%@page import="javax.servlet.http.HttpServlet"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="javax.servlet.http.HttpServletResponse"%>
<%@page import="javax.servlet.http.HttpSession"%>

<%@page import="mesBeans.LigneCommande"%>
<%@page import="mesBeans.User"%>
<%@page import="pkgAction.CommandeAction"%>
<%@page import="pkgUtils.GestionSession"%>
<%@page import="mesBeans.Produit"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link
	href="http://fonts.googleapis.com/css?family=Lato&subset=latin,latin-ext"
	rel="stylesheet" type="text/css">
<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link rel="stylesheet" href="assets/css/panier.css" type="text/css">
<%@ include file="assets.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<title>Panier</title>
</head>
<body>


	<%@ include file="menu.jsp" %>
	
	
	<div class="ContenuWrapper">
		<div class="headerContenu">
			<h2>Shopping Cart</h2>
		</div>
		<form>
			<%
		
				if (GestionSession.getSession(request).getAttribute("panier")!= null) {
					HashMap<Integer, LigneCommande> panier = GestionSession.GetPanier(request);
					for (int mapKey : panier.keySet()) {
						LigneCommande lcp = panier.get(mapKey);
						Produit p = ProduitAction.recupererProduitPanier(lcp.getId_produit());
			%>


			<div class="contenuCart" id =<%=p.getId_produit()%>>
				<div class="cont1">
					<div class="select" >
						<select name=<%=p.getId_produit()%> onchange="calculFacture(),modifierLigneCommande(this);">
							<%for( int i=1 ; i<=p.getStock() ;i++){ %>
							<option value=<%=i%>  <%if(i==lcp.getQte()){ %>selected="selected"<%} %>><%=i%></option>
						<%} %>
						</select>

						<div class="iconDown">
							<i class="fa fa-chevron-down"></i>
						</div>
					</div>
					<img src="<%= Constantes.PATH_IMG_PRODUIT + p.getUrl_image_vitrine() %>">

					<div class="info">
						<span class="title"><%=p.getNom_produit() %></span>
						<span class="subTitle">$<%DecimalFormat df = new DecimalFormat("0.00");out.print((df.format(p.getPrix()))); %> - <a id="supprimer"  onclick="supprimer(this),supprimerLignePanier(this);">Remove</a>
						</span>
					</div>
					<div class="price">
						<span>$<%DecimalFormat da = new DecimalFormat("0.00");out.print((da.format(p.getPrix()* lcp.getQte()))); %></span>
					</div>
				</div>
			</div>
<%
				}
				}
			%>
			<div class="footerContenuCart">
				<div class="left">
					<a href="/TP_FINAL_P33/products.jsp">Add more Products</a>
				</div>
				<div class="right">
					<span id="labeltotale">Sub-Total</span> <span id="totale">$
<% 
					if (GestionSession.getSession(request).getAttribute("panier")!= null) {
						double subTotal= 0;
						HashMap<Integer, LigneCommande> panier = GestionSession.GetPanier(request);
						for (int mapKey : panier.keySet()) {
							LigneCommande lcp = panier.get(mapKey);
							Produit p = ProduitAction.recupererProduitPanier(lcp.getId_produit());
							subTotal = subTotal + p.getPrix() * lcp.getQte();
						
							
						}
						DecimalFormat da = new DecimalFormat("0.00");
						out.print((da.format(subTotal)));
					}
							%>
					
					
					</span>

				</div>

			</div>
			<div class="comment">
				<span id="labelcomment">Special instructions for seller:</span>
				<textarea id="textarea"></textarea>
			</div>
			<div class="checkout">
				<a id="chek" href="/TP_FINAL_P33/Checkout">CHECK OUT</a>
			</div>
			
		</form>
	</div>

<footer style="position: inherit;">
	<ul class="about">
		<li>A PROPOS DE NOUS</li>
		<li>Notre histoire</li>
		<li>Technologie & innovation</li>
		<li>News</li>
		<li>Carriere</li>
	</ul>
	<ul class="shop">
		<li>ACHATS</li>
		<li>Homme</li>
		<li>Femme</li>
		<li>Chaussures</li>
		<li>Sport</li>
		<li>Meilleur vendeurs</li>
		<li></li>
		<li></li>
		<li></li>
	</ul>
	<ul class="soutien">
		<li>SOUTIEN</li>
		<li>FAQ</li>
		<li>Tableau de tailles</li>
		<li>Politique de garantie</li>
		<li>Politique de retour</li>
		<li>Nous contacter</li>
	</ul>
	<ul class="social">
		<li><a href="#">MEDIAS SOCIAUX</a></li>
		<li><a href="#" class="fb fa fa-3x fa-facebook-square"></a><a href="#" class="twitter fa-3x fa fa-twitter-square"></a></li>
		<li><a href="#" class="instagram fa-3x fa fa-instagram"></a><a href="#" class="google fa-3x fa fa-google-plus-square"></a></li>
	</ul>
</footer>

</body>
<script src="assets/js/cart.js"></script>
</html>
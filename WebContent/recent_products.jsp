<!-- TODO : Faire une requête SQL pour recuperer une liste dont l'id category = 10 ( pour les produit populaires ) -->
<%@page import="pkgUtils.Constantes"%>
<%@page import="mesBeans.Produit"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.lang.System"%>
<% ArrayList<Produit> pdt_hommes =  (ArrayList<Produit>) request.getAttribute("pdts_homme"); 
ArrayList<Produit> pdt_femmes =  (ArrayList<Produit>) request.getAttribute("pdts_femme"); 
%>

<ul class="homme_pdt produits">
	<h3><a href="products.jsp?cat=Homme">Homme</a></h3>
	<% for(Produit unProduit : pdt_hommes ) {%>
	<li>
		<div class="imgPdt"><div class="hoverPdt"><a href="" i class="fa fa-plus"></a></div><img src="<%= Constantes.PATH_IMG_PRODUIT + unProduit.getUrl_image_vitrine() %>" alt="Photo vetement homme" /></div>
		<div class="nomPdt"><%= unProduit.getNom_produit() %></div>
		<div class="prixPdt">$<%= unProduit.getPrix() %></div>
	</li>
	<% } %>
</ul>

<ul class="femme_pdt produits">
	<h3><a href="products.jsp?cat=Femme">Femme</a></h3>
	<% for(Produit unProduit : pdt_femmes ) {%>
	<li>
		<div class="imgPdt"><div class="hoverPdt"><a href="" class="fa fa-plus"></a></div><img src="<%= Constantes.PATH_IMG_PRODUIT + unProduit.getUrl_image_vitrine() %>" alt="Photo vetement homme" /></div>
		<div class="nomPdt"><%= unProduit.getNom_produit() %></div>
		<div class="prixPdt">$<%= unProduit.getPrix() %></div>
		
	</li>
	<% } %>
</ul>
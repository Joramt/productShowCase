<%@page import="mesBeans.Produit"%>
<%@page import="java.util.ArrayList"%>
<%@page import="pkgUtils.Constantes"%>
<!-- Les variables sont marquées comme inconnues car elles sont déclaré dans la page products.jsp
qui va include cette page. Elle seront donc connue au moment de l'execution mais non 
au moment de la compilation  -->

<% 
// On recuperer les produits que l'on nous a envoyé auparavant
ArrayList<Produit> prodByCat = (ArrayList<Produit>) request.getAttribute(Constantes.RESULT_PRODUCT_BY_CATEGORY_KEY);
ArrayList<String> sousCat = (ArrayList<String>) request.getAttribute(Constantes.TAB_SOUS_CAT_KEY);

ArrayList<Produit> firstCat = new ArrayList<Produit>();
ArrayList<Produit> secondCat = new ArrayList<Produit>();
ArrayList<Produit> thirdCat = new ArrayList<Produit>();
ArrayList<Produit> fourthCat = new ArrayList<Produit>();
ArrayList<Produit> fifthCat = new ArrayList<Produit>();

for(Produit unProduit : prodByCat ) {
	if(unProduit.getType_vetement().equals(sousCat.get(0))) {
		firstCat.add(unProduit);
	}
	else if(unProduit.getType_vetement().equals(sousCat.get(1))) {
		secondCat.add(unProduit);
	}
	else if(unProduit.getType_vetement().equals(sousCat.get(2))) {
		thirdCat.add(unProduit);
	}
	else if(unProduit.getType_vetement().equals(sousCat.get(3))) {
		fourthCat.add(unProduit);
	}
	else if(unProduit.getType_vetement().equals(sousCat.get(4))) {
		fifthCat.add(unProduit);
	}
}
%>

<ul class="<%=  category.substring(0, 1).toUpperCase() + category.substring(1) %>_pdt produits">
	<h3><a href="products.jsp?cat=<%=  category.substring(0, 1).toUpperCase() + category.substring(1) %>"><%= category.substring(0, 1).toUpperCase() + category.substring(1) %></a></h3>
	<h2><%= sousCat.get(0) %></h2>
	<% for(Produit unProduit : firstCat ) {%>
	<li>
		<div class="imgPdt"><div class="hoverPdt"><a href="" i class="fa fa-plus"></a></div><img src="<%= Constantes.PATH_IMG_PRODUIT + unProduit.getUrl_image_vitrine() %>" alt="Photo vetement homme" /></div>
		<div class="nomPdt"><%= unProduit.getNom_produit() %></div>
		<div class="prixPdt">$<%= unProduit.getPrix() %></div>
	</li>
	<% } %>
	<h2><%= sousCat.get(1) %></h2>
	<% for(Produit unProduit : secondCat ) {%>
	<li>
		<div class="imgPdt"><div class="hoverPdt"><a href="" i class="fa fa-plus"></a></div><img src="<%= Constantes.PATH_IMG_PRODUIT + unProduit.getUrl_image_vitrine() %>" alt="Photo vetement homme" /></div>
		<div class="nomPdt"><%= unProduit.getNom_produit() %></div>
		<div class="prixPdt">$<%= unProduit.getPrix() %></div>
	</li>
	<% } %>
	<h2><%= sousCat.get(2) %></h2>
	<% for(Produit unProduit : thirdCat ) {%>
	<li>
		<div class="imgPdt"><div class="hoverPdt"><a href="" i class="fa fa-plus"></a></div><img src="<%= Constantes.PATH_IMG_PRODUIT + unProduit.getUrl_image_vitrine() %>" alt="Photo vetement homme" /></div>
		<div class="nomPdt"><%= unProduit.getNom_produit() %></div>
		<div class="prixPdt">$<%= unProduit.getPrix() %></div>
	</li>
	<% } %>
	<h2><%= sousCat.get(3) %></h2>
	<% for(Produit unProduit : fourthCat ) {%>
	<li>
		<div class="imgPdt"><div class="hoverPdt"><a href="" i class="fa fa-plus"></a></div><img src="<%= Constantes.PATH_IMG_PRODUIT + unProduit.getUrl_image_vitrine() %>" alt="Photo vetement homme" /></div>
		<div class="nomPdt"><%= unProduit.getNom_produit() %></div>
		<div class="prixPdt">$<%= unProduit.getPrix() %></div>
	</li>
	<% } %>
	
	<% if(!fifthCat.isEmpty()){ %>
		<h2 ><%= sousCat.get(4) %></h2>
		<% for(Produit unProduit : fifthCat ) {
		System.out.println(unProduit.getType_vetement()); %>
		<li>
			<div class="imgPdt"><div class="hoverPdt"><a href="" i class="fa fa-plus"></a></div><img src="<%= Constantes.PATH_IMG_PRODUIT + unProduit.getUrl_image_vitrine() %>" alt="Photo vetement homme" /></div>
			<div class="nomPdt"><%= unProduit.getNom_produit() %></div>
			<div class="prixPdt">$<%= unProduit.getPrix() %></div>
		</li>
		<% } %>
	<% } %>
</ul>
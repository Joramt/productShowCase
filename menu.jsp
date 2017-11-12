<navbar>
	<ul class="nav-option">
		<% String uri = request.getRequestURI(); 
		
		if(uri.equals("/TP_FINAL_P33/register.jsp")){
		%>
			<li class="nav-options"><a href="index.jsp">Acceuil</a></li>
			<li class="nav-options"><a href="products.jsp">Produits</a></li>
			<li class="nav-options"><a href="login.jsp">Login</a></li>
			<li class="nav-options navOpt-Selected"><a href="register.jsp">Inscription</a></li>
			<li class="nav-options"><a href="cart.jsp">Mon panier</a></li>
			
		<% } else if(uri.equals("/TP_FINAL_P33/products.jsp")) { %>
		
			<li class="nav-options"><a href="index.jsp">Acceuil</a></li>
			<li class="nav-options navOpt-Selected"><a href="products.jsp">Produits</a></li>
			<li class="nav-options"><a href="login.jsp">Login</a></li>
			<li class="nav-options"><a href="register.jsp">Inscription</a></li>
			<li class="nav-options"><a href="cart.jsp">Mon panier</a></li>
		
		<% } else if(uri.equals("/TP_FINAL_P33/login.jsp")) { %>
		
			<li class="nav-options"><a href="index.jsp">Acceuil</a></li>
			<li class="nav-options"><a href="products.jsp">Produits</a></li>
			<li class="nav-options navOpt-Selected"><a href="login.jsp">Login</a></li>
			<li class="nav-options"><a href="register.jsp">Inscription</a></li>
			<li class="nav-options"><a href="cart.jsp">Mon panier</a></li>
			
		<% } else if(uri.equals("/TP_FINAL_P33/cart.jsp")) { %>
		
		<li class="nav-options"><a href="index.jsp">Acceuil</a></li>
		<li class="nav-options"><a href="products.jsp">Produits</a></li>
		<li class="nav-options"><a href="login.jsp">Login</a></li>
		<li class="nav-options"><a href="register.jsp">Inscription</a></li>
		<li class="nav-options navOpt-Selected"><a href="cart.jsp">Mon panier</a></li>
		
		<% } else { %>
		
			
		<li class="nav-options navOpt-Selected"><a href="index.jsp">Acceuil</a></li>
		<li class="nav-options"><a href="products.jsp">Produits</a></li>
		<li class="nav-options"><a href="login.jsp">Login</a></li>
		<li class="nav-options"><a href="register.jsp">Inscription</a></li>
		<li class="nav-options"><a href="cart.jsp">Mon panier</a></li>
		
		<% } %>
	</ul>
</navbar>
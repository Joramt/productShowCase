<%@page import="mesBeans.User"%>
<%@page import="pkgUtils.Constantes"%>
<% User client = (User) request.getAttribute(Constantes.CLIENT_KEY); 
   boolean isThereAClient = ((client != null ) ? true: false);
   String email_value = "";
   String pwd_value = "";
   
   if(isThereAClient){
	   email_value = client.getEmail();
	   pwd_value = client.getPwd();
   }
%>

<form id="login-form" method="get" action="loginValidation">
<fieldset>
	<legend>Connexion</legend>
	<label for="email">Email :</label>
	<input type="email" name="email" id="email" required="required" value=<%=email_value %> >
	<label for="pwd">Mot de passe : </label>
	<input type="password" name="pwd" id="pwd" required="required" value=<%=pwd_value %> >
	<input type="submit" value="Connexion" />
</fieldset>
</form>
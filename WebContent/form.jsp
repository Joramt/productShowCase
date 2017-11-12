<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<form action="validation" method="get">
	<fieldset id="firstfieldset" class="info">
		<legend>Informations</legend>
			<label for="nom">Nom : </label>
			<input required="required" type="text" id="nom" name="nom" />
			<label for="prenom">Prenom : </label>
			<input required="required" type="text" id="prenom" name="prenom"/>
			<label >Genre : </label>
			<input required="required" type="radio" name="sexe" value="homme" id="rdio_homme" /> <label for="rdio_homme"> Homme </label>
			<input required="required" type="radio" name="sexe" value="femme" id ="rdio_femme"/> <label for="rdio_femme"> Femme </label>
			<label for="email">Email : </label>
			<input required="required" type="email" id="email" name="email" />
			<label for="pwd">Mot de passe : </label>
			<input type="password" name="pwd" id="pwd" required="required" />
			<label for="day">Naissance : </label>
				<select id="day" name="day">
					<option value="1" selected="selected">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
					<option value="7">7</option>
					<option value="8">8</option>
					<option value="9">9</option>
					<option value="10">10</option>
					<option value="11">11</option>
					<option value="12">12</option>
					<option value="13">13</option>
					<option value="14">14</option>
					<option value="15">15</option>
					<option value="16">16</option>
					<option value="17">17</option>
					<option value="18">18</option>
					<option value="19">19</option>
					<option value="20">20</option>
					<option value="21">21</option>
					<option value="22">22</option>
					<option value="23">23</option>
					<option value="24">24</option>
					<option value="25">25</option>
					<option value="26">26</option>
					<option value="27">27</option>
					<option value="28">28</option>
					<option value="29">29</option>
					<option value="30">30</option>
					<option value="31">31</option>
				</select>
				<select name="month" id="month">
					<option value="jan" selected="selected">Janvier</option>
					<option value="fev">Fevrier</option>
					<option value="mar">Mars</option>
					<option value="avr">Avril</option>
					<option value="mai">Mai</option>
					<option value="jun">Juin</option>
					<option value="jul">Juillet</option>
					<option value="aou">Aout</option>
					<option value="sep">Septembre</option>
					<option value="oct">Octobre</option>
					<option value="nov">Novembre</option>
					<option value="dec">Decembre</option>
				</select>
				<select name="year" id="year">
				<%
				int max = 2015;
				int majeur = 18;
				for(int i = 1900; i<=max;i++){
				%>
					<% if(i == (max-majeur)){ %>
					<option selected="selected" value="<%= i %>"><%= i %></option>
					<% } else { %>
					<option value="<%= i %>"><%= i %></option>
					<% } %>
					
				<% } %>
				</select>
				<button type="button"  id="firstfieldsetbutton">Suivant</button>
	</fieldset>
	<fieldset id="secondfieldset" class="bill">
		<legend>Facturation</legend>
		<label>Carte de credit : </label>
		<img src="assets/img/visa.png" id="visa" alt="visa" />
		<img src="assets/img/mc.png" id="mc" alt="mc" />
		<label>Numeros de carte : </label>
		<input type="number" name="premiernumeros" /> -
		<input type="number" name="deuxiemenumeros" /> -
		<input type="number" name="troisiemenumeros" /> -
		<input type="number" name="quatriemenumeros" />
		<label for="expiration">Date d'expiration :</label>
		<select name="credit-month" id="month">
			<option value="jan" selected="selected">Janvier</option>
			<option value="fev">Fevrier</option>
			<option value="mar">Mars</option>
			<option value="avr">Avril</option>
			<option value="mai">Mai</option>
			<option value="jun">Juin</option>
			<option value="jul">Juillet</option>
			<option value="aou">Aout</option>
			<option value="sep">Septembre</option>
			<option value="oct">Octobre</option>
			<option value="nov">Novembre</option>
			<option value="dec">Decembre</option>
		</select>
		<select name="credit-year" id="credit_year" class="credit-year">
			<option value="2015">2015</option>
			<option value="2016">2016</option>
			<option value="2017">2017</option>
			<option value="2018">2018</option>
			<option value="2019">2019</option>
		</select>
		<label for="CCV">CCV : </label>
		<input id="CCV" type="text" name="CCV" />
		<label for="adresse">Adresse : </label>
		<input type="text" name="adresse" id="adresse" />
		<button type="button" id="secondfieldsetbutton">Précédent</button>
		<button name="card" id="skipcard" value="set">Saisir mes infos plus tard</button>
		<input type="submit" id="submitform" value="Je m'inscris !"/>
	</fieldset>
</form>
/**
 * Created by omar on 02/06/2015.
 */
window.onload = function() {
	calculFacture();
};

function supprimer(element) {
	a = element.parentNode.parentNode.parentNode.parentNode;

	b = a.parentNode.removeChild(a);
	calculFacture()
}

function calculFacture() {
	a = document.getElementsByClassName('cont1');
	somme = 0;
	for (i = 0; i < a.length; i++) {
		b = a[i];

		prixunitaire = parseFloat(b.firstElementChild.nextElementSibling.nextElementSibling.lastElementChild.innerHTML
				.substr(1, 5));
		nombre = b.firstElementChild.firstElementChild.selectedIndex + 1;
		b.lastElementChild.children[0].innerHTML = "$"
				+ (prixunitaire * nombre) + ",00";

		somme = parseFloat(somme + (prixunitaire * nombre));

	}
	document.getElementById('totale').innerHTML = "$" + somme + ",00";
}

function getnombre(element) {

	url = "cart.php?nombre=" + (element.selectedIndex + 1) + "&nomarticle="
			+ element.name;
	console.log(url);
	// window.location.href=url;

}

function supprimerLignePanier(element) {
	var a = element.parentNode.parentNode.parentNode.parentNode.id;
	console.log(a)
	var xmlHttpR = new XMLHttpRequest();
	xmlHttpR.open("GET", "/TP_FINAL_P33/Panier?supprimer=" + a, true);
	xmlHttpR.send(null);

	var response;

	xmlHttpR.onreadystatechange = function() {
		if (xmlHttpR.readyState = 4 && xmlHttpR.status == 200) {
			console.log("salutttttttt");
		}

	}
}

function modifierLigneCommande(element) {

	var a = element.parentNode.parentNode.parentNode.id;
	var b = element.value;
	console.log(a);
	var xmlHttpR = new XMLHttpRequest();
	xmlHttpR.open("GET", "/TP_FINAL_P33/Panier?modifier=" + a + "&qte=" + b, true);
	xmlHttpR.send(null);
}

package pkgAction;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import mesBeans.Produit;
import pkgManager.ProduitManger;

public class ProduitAction {

	public static boolean afficherProduit(HttpServletRequest request) {

		ArrayList<Produit> listProduit = (ArrayList<Produit>) ProduitManger.getAll();

		request.setAttribute("listeProduit", listProduit);

		return (listProduit != null ? true : false);
	}

	public static ArrayList<Produit> getTop8byCategorie(String categorie) {
		ArrayList<Produit> pdts = ProduitManger.getTop8byCategorie(categorie);
		return pdts;
	}

	public static boolean recupererProduit(HttpServletRequest request, int idProduit) {

		Produit pro = (Produit) ProduitManger.getProduitByID(idProduit);

		request.setAttribute("produit", pro);

		return (pro != null ? true : false);
	}
	
	
	public static Produit recupererProduitPanier(int idProduit) {
		Produit pro = (Produit) ProduitManger.getProduitByID(idProduit);
		return pro;
	}
	
	

	public static boolean rechercherProduit(HttpServletRequest request, String name) {

		ArrayList<Produit> listProduit = (ArrayList<Produit>) ProduitManger.getByName(name);

		request.setAttribute("listeProduitsRecherchees", listProduit);

		return (listProduit != null ? true : false);
	}

	public static boolean ProduitByCategorie(HttpServletRequest request , String categorie) {

		ArrayList<Produit> listProduit = (ArrayList<Produit>) ProduitManger.getByCategrie(categorie);

		request.setAttribute("listeProduitByCategorie", listProduit);

		return (listProduit != null ? true : false);
	}
	
	
	public static Produit GetProduit(HttpServletRequest request, int idProduit){
		Produit pro = (Produit) ProduitManger.getProduitByID(idProduit);

		return pro;
	}
	
	
	public static void main(String arg[]){
		Produit p = ProduitAction.recupererProduitPanier(2);
		System.out.println(p);
	}

}

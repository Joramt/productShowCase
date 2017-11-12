package pkgUtils;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.testng.annotations.Test;

import com.sun.javafx.collections.MappingChange.Map;

import mesBeans.LigneCommande;
import mesBeans.Produit;
import mesBeans.User;
import pkgAction.ProduitAction;

public class GestionSession {

	// création de la session
	public static HttpSession getSession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		return session;

	}

	// detruire la session
	public static void destructSession(HttpServletRequest request) {
		HttpSession session = getSession(request);
		session.invalidate();
	}

	// ajouter un utilisatuer a la session
	public static void SessionAjouterUser(HttpServletRequest request, User utilisateur) {
		HttpSession session = getSession(request);
		session.setAttribute(Constantes.Clef_User, utilisateur);
	}

	// ajouter une ligne de produit a la session
	public static void SessionAjouterLigne(HttpServletRequest request, LigneCommande lc) {
		HttpSession session = getSession(request);

		if (session.getAttribute("panier") != null) {			
			HashMap<Integer, LigneCommande> panier = null;
			panier = (HashMap<Integer, LigneCommande>) session.getAttribute("panier");
			
		
			
			if (CheckLigneCommande(request, lc) == true) {
				System.out.println("/////////////////////////////////");
				System.out.println("avant ajout");
				GestionSession.afficherPanier(panier);
				System.out.println("***********************************");
				
				panier.put(lc.getId_produit(), lc);
				
				System.out.println("apres ajout");
				GestionSession.afficherPanier(panier);
				System.out.println("/////////////////////////////////");
			}

		} else {
			session.setAttribute("panier", new HashMap<Integer, LigneCommande>());
			HashMap<Integer, LigneCommande> panier = null;
			panier = (HashMap<Integer, LigneCommande>) session.getAttribute("panier");

			System.out.println("/////////////////////////////////");
			System.out.println("avant ajout");
			GestionSession.afficherPanier(panier);
			System.out.println("***********************************");

			panier.put(lc.getId_produit(), lc);

			System.out.println("apres ajout");
			GestionSession.afficherPanier(panier);
			System.out.println("/////////////////////////////////");

		}

	}

	// verifier si le produit est déja ajouté a la session ou non
	public static boolean CheckLigneCommande(HttpServletRequest request, LigneCommande lc) {
		boolean test = true;
		
		
		HttpSession session = getSession(request);
		HashMap<Integer, LigneCommande> panier = null;
		panier = (HashMap<Integer, LigneCommande>) session.getAttribute("panier");
	
		System.out.println("/////////////////////////////////");
		System.out.println("avant check");
		GestionSession.afficherPanier(panier);
		System.out.println("***********************************");
		Iterator iterator = panier.entrySet().iterator();
		while (iterator.hasNext() && test == true) {
			
			Entry<Integer, LigneCommande> ligneHashmap = (Entry<Integer, LigneCommande>) iterator.next();
			int key = ligneHashmap.getKey();
			LigneCommande lcp = ligneHashmap.getValue();
			                  
			if (lcp.getId_produit() == lc.getId_produit()) {
				test = false;
				panier.replace(key, lc);
			}
		}
		System.out.println("/////////////////////////////////");
		System.out.println("apres check");
		GestionSession.afficherPanier(panier);
		System.out.println("***********************************");

		return test;

	}

	// supprimer toute les lignes d'articles se trouvant dans le panier
	public static void videPanier(HttpServletRequest request) {
		HttpSession session = getSession(request);
		session.removeAttribute("panier");

	}

	public static void supprimerLignePanier(HttpServletRequest request, int id) {
		HttpSession session = getSession(request);
		boolean test = true;

		HashMap<Integer, LigneCommande> panier = (HashMap<Integer, LigneCommande>) session.getAttribute("panier");
		System.out.println("/////////////////////////////////");
		System.out.println("avant suupression");
		System.out.println("*********************************");
		GestionSession.afficherPanier(panier);
		Iterator<?> iterator = panier.entrySet().iterator();

		while (iterator.hasNext() && test == true) {
			Entry<Integer, LigneCommande> ligneCommande = (Entry<Integer, LigneCommande>) iterator.next();

			int clef = ligneCommande.getKey();
			if (clef == id) {
				test = false;
				panier.remove(clef);	
			}
		}
		System.out.println("apres suupression");
		System.out.println("/////////////////////////////////");
		GestionSession.afficherPanier(panier);
	}

	// valider le panier avant de l'envoyer a la base de données
	public static boolean ValiderPanier(HttpServletRequest request) {
		boolean retour = true;

		HttpSession session = getSession(request);
		HashMap<Integer, LigneCommande> panier = (HashMap<Integer, LigneCommande>) session.getAttribute("panier");
		Iterator iterator = panier.entrySet().iterator();

		while (iterator.hasNext() && retour == true) {

			Entry<Integer, LigneCommande> ligneCommande = (Entry<Integer, LigneCommande>) iterator.next();
			LigneCommande lcp = ligneCommande.getValue();

			Produit p = ProduitAction.GetProduit(request, lcp.getId_produit());
			if (!(p.getStock() >= lcp.getQte()))
				retour = false;
		}

		return retour;
	}

		


		

	public static HashMap<Integer, LigneCommande> GetPanier(HttpServletRequest request) {
		HttpSession session = request.getSession();
		HashMap<Integer, LigneCommande> panier = (HashMap<Integer, LigneCommande>) session.getAttribute("panier");
		return panier;

	}

	public static void afficherPanier(HashMap<Integer, LigneCommande> panier) {

		Iterator iterator = panier.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<Integer, LigneCommande> ligneCommande = (Entry<Integer, LigneCommande>) iterator.next();
			LigneCommande lcp = ligneCommande.getValue();
			int clef = ligneCommande.getKey();
			System.out.println("clé " +clef +"  lignecommande  " + lcp.toString());
		}
	}
	


}
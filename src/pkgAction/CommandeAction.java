package pkgAction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import javax.jws.soap.SOAPBinding.Use;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import mesBeans.LigneCommande;
import mesBeans.Produit;
import mesBeans.User;
import pkgManager.CommandeManger;
import pkgManager.LigneCommandeManager;
import pkgManager.ProduitManger;
import pkgUtils.Constantes;

public class CommandeAction {

	
	
	public static boolean ajouterCommande(HttpServletRequest request , HttpSession session) {

		int numCommande =0;
		User user= null;
		user = (User) session.getAttribute(Constantes.Clef_User);
		
		numCommande=CommandeManger.insert(user);
		if (numCommande>0){
			
			HashMap<Integer, LigneCommande> panier =  (HashMap<Integer, LigneCommande>) session.getAttribute("panier");
			
			Iterator iterator = panier.entrySet().iterator();
			while (iterator.hasNext()) {
				Entry<Integer, LigneCommande> ligneCommande = (Entry<Integer, LigneCommande>) iterator.next();
				LigneCommande lcp = ligneCommande.getValue();
				lcp.setId_commande(numCommande);
				LigneCommandeManager.insert(lcp);
				
				
			}
			
		}
		
		
		
		return (numCommande != 0 ? true : false);
	}
}

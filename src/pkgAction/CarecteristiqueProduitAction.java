package pkgAction;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import mesBeans.ImageProduit;
import mesBeans.Produit;
import pkgManager.ImageProduitManager;

public class CarecteristiqueProduitAction {

	
	public static boolean afficherCarecteristiqueProduit(HttpServletRequest request , int idProduit){
		
		
		ArrayList<ImageProduit> imgProduit =   ImageProduitManager.getImagesProduitById(idProduit);
		
		
		request.setAttribute("ImageProduit", imgProduit);

		return (imgProduit != null ? true : false);
	}
}

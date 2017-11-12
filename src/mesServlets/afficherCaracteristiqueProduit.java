package mesServlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mesBeans.ImageProduit;
import mesBeans.Produit;
import pkgAction.CarecteristiqueProduitAction;
import pkgAction.ProduitAction;


public class afficherCaracteristiqueProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public afficherCaracteristiqueProduit() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		if (ProduitAction.recupererProduit(request, 12) == true && CarecteristiqueProduitAction.afficherCarecteristiqueProduit(request, 12)==true) {
		
			Produit prod = (Produit) request.getAttribute("produit");
			ArrayList<ImageProduit>  imgProd =  (ArrayList<ImageProduit>)  request.getAttribute("ImageProduit");
			System.out.println(prod.toString());
			for(ImageProduit ip : imgProd){
				System.out.println(ip.toString());
			}
		}

		else
			System.out.println("baaaaad");
}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

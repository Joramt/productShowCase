package mesServlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mesBeans.Produit;
import pkgAction.ProduitAction;

/**
 * Servlet implementation class ProduitsByCategorie
 */
@WebServlet("/ProduitsByCategorie")
public class ProduitsByCategorie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProduitsByCategorie() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String categorie ="homme"; // homme || femme || enfant || bebe

		if(ProduitAction.ProduitByCategorie(request, categorie))
		{System.out.println("cooooool");
		ArrayList<Produit> array = (ArrayList<Produit>) request.getAttribute("listeProduitByCategorie");
			for(Produit a : array)
				System.out.println(a);
		}
	
	else System.out.println("baaaaad");
}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

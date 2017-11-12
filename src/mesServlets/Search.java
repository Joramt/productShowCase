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
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Search() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String  termeRecherche = "a";
		termeRecherche = "%"+termeRecherche+"%"; // n'oublie pas de rajouter ça sinon ca ne va pas marcher
		
		ArrayList<Produit> prod  = new ArrayList<>();
		if(ProduitAction.rechercherProduit(request, termeRecherche)){
			prod = (ArrayList<Produit>) request.getAttribute("listeProduitsRecherchees");
			for(Produit p : prod){
				System.out.println(p.toString());
			}
		}else{
			System.out.println("badddd");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}

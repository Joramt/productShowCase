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
 * Servlet implementation class GetProduitIndex
 */
@WebServlet(name = "getProduitIndex", urlPatterns = { "/getProduitIndex" })
public class GetProduitIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetProduitIndex() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Produit> pdts_homme = ProduitAction.getTop8byCategorie("homme");
		ArrayList<Produit> pdts_femme = ProduitAction.getTop8byCategorie("femme");
		//ArrayList<Produit> pdts_enfants = ProduitAction.getTop8byCategorie("enfant");
		///ArrayList<Produit> pdts_bebe = ProduitAction.getTop8byCategorie("bebe");
		request.setAttribute("pdts_femme", pdts_femme);
		request.setAttribute("pdts_homme", pdts_homme);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

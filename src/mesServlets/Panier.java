package mesServlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import mesBeans.LigneCommande;
import mesBeans.Produit;
import pkgAction.ProduitAction;
import pkgUtils.GestionSession;

/**
 * Servlet implementation class Panier
 */
@WebServlet("/Panier")
public class Panier extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Panier() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("supprimer") != null) {
			
			int id = Integer.parseInt(request.getParameter("supprimer"));
			GestionSession.supprimerLignePanier(request, id);

		}
	if (request.getParameter("id_article") != null && request.getParameter("qty") != null) {
			int id_article = Integer.parseInt(request.getParameter("id_article"));
			int qty = Integer.parseInt(request.getParameter("qty"));

			LigneCommande lc = new LigneCommande();
			lc.setId_produit(id_article);
			lc.setQte(qty);

			GestionSession.SessionAjouterLigne(request, lc);
			HashMap<Integer, LigneCommande> panier = GestionSession.GetPanier(request);
		
			request.getRequestDispatcher("cart.jsp").forward(request, response);
		}

		if (request.getParameter("modifier") != null && request.getParameter("qte") != null) {
			int id = Integer.parseInt(request.getParameter("modifier"));
			int qte = Integer.parseInt(request.getParameter("qte"));
			LigneCommande ligneCommande = new LigneCommande();
			ligneCommande.setId_produit(id);
			ligneCommande.setQte(qte);
			GestionSession.SessionAjouterLigne(request,ligneCommande);
	
		
		}


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}

package mesServlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mesBeans.LigneCommande;
import mesBeans.User;
import pkgAction.CommandeAction;
import pkgUtils.GestionSession;

/**
 * Servlet implementation class TesterSession
 */
@WebServlet("/TesterSession")
public class TesterSession extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TesterSession() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
						// tester l'ajout de l'utilisateur 
		if(GestionSession.getSession(request).getAttribute("panier")!=null){
			System.out.println("cc");
		HashMap<Integer, LigneCommande> panier = GestionSession.GetPanier(request);
		GestionSession.afficherPanier(panier);
		}
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}

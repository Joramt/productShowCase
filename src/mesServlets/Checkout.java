package mesServlets;

import java.io.IOException;
import java.util.Date;

import pkgUtils.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mesBeans.User;
import pkgAction.CommandeAction;

/**
 * Servlet implementation class Checkout
 */
@WebServlet("/Checkout")
public class Checkout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Checkout() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("sdsqdskl,lkxqpoe");
			User u = new User();
			u.setIdUser(28);
			u.setEmail("omar.boach@gmail.com");
			GestionSession.SessionAjouterUser(request, u);
			
			
		if (GestionSession.getSession(request).getAttribute(Constantes.Clef_User) != null){
			System.out.println(GestionSession.ValiderPanier(request));
				if (GestionSession.ValiderPanier(request)==true){
					
					CommandeAction.ajouterCommande(request, GestionSession.getSession(request));
					GestionSession.videPanier(request);
					User user = (User)(GestionSession.getSession(request).getAttribute(Constantes.Clef_User));
					String mailTo = user.getEmail();
					String message = "<p style=\"color:red;\">Votre Commande a été bien enregistrée dans nos base de données et elle vous sera livrée aussitôt que possible , Merci. </p>";
					String sujet = "Confirmation commande" + new Date();
					GestionMail.sendEmail(message, mailTo, sujet);
					response.sendRedirect("cart.jsp");
				}
				
		}else{
			response.sendRedirect("/TP_FINAL_P33/register.jsp");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

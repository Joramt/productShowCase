package mesServlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.bcel.internal.classfile.ConstantObject;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

import pkgAction.UserAction;
import mesBeans.InfosPaiement;
import mesBeans.User;
import pkgManager.UserManager;
import pkgUtils.Constantes;

/**
 * Servlet implementation class Validation
 */
@WebServlet(name = "validation", urlPatterns = { "/validation" })
public class Validation extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Validation() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Recuperation des attributs du client
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		
		// Recuperation des attributs du paiement
		String typeCarte = request.getParameter("typeCarte");
		String premierNumero = request.getParameter("premiernumero");
		String deuxiemeNumero = request.getParameter("deuxiemenumero");
		String troisiemeNumero = request.getParameter("troisiemenumero");
		String quatriemenumero = request.getParameter("quatriemenumero");
		String exp_month = request.getParameter("credit-month");
		String exp_year = request.getParameter("credit-year");
		String CCV =  request.getParameter("CCV");
		String adresse = request.getParameter("adresse");
		
		InfosPaiement clientPaiement = new InfosPaiement(typeCarte, premierNumero, deuxiemeNumero, troisiemeNumero, quatriemenumero,exp_month, exp_year, CCV, adresse);
		boolean isClientPaiementValide = UserAction.checkInfosPaiement(clientPaiement);
		
		//Manipulation de l'adresse e-mail afin d'en extraire le @mailer.com
		String[] email_parts = email.split("@");
		String email_DNS = email_parts[1];
		
		// On définit une page de retour
		String redirect_page = "login.jsp";
		
		//On verifie que le email est bien celui de la compagnie et que la personne est dans la db admin
		boolean isEmailFromCompany = email_DNS.equals(Constantes.EMAIL_DNS_ADMINS);
		boolean isUserAnAdmin = (UserAction.getAdminByName(nom) == null) ? true:false ;
		
		//On lui attribue un statut en fonction
		int status = ((isEmailFromCompany)&&(isUserAnAdmin)) ? Constantes.STATUT_ADMIN:Constantes.STATUT_USER;
		
		boolean isEmailAlreadyUsed = (UserAction.getUserByMail(email)!= null) ? true:false ;
		
		//On crée un objet User avec les info récupérées
		User client = new User(nom, prenom, email, pwd, status);
		
		// Si l'email est deja utilisé ...
		if(isEmailAlreadyUsed){
			// ... on le remplace par une chaine vide
			client.setEmail("");
			
			// On set un attribut avec un message d'erreur
			request.setAttribute(Constantes.ERROR_KEY, Constantes.MAIL_ERROR_MSG);
			
			// On modifie la page de redirection
			redirect_page = "register.jsp";
		}
		// Sinon on ajoute le mail du client a l'objet ClientPaiement
		// On ajoute le client a la BD
		// On ajoute les info de paiement du client a la BD
		else {
			clientPaiement.setemailUser(client.getEmail());
			UserAction.AddUser(client);
			if(isClientPaiementValide)
				UserAction.AddPaiement(clientPaiement);
		}
		
		System.out.println(client.getPwd());
		// On set un attribut avec un client ( afin de remplir les champs du formulaire login ou register)
		request.setAttribute(Constantes.CLIENT_KEY, client);
		
		// Puis on redirige le client en fonction de la valeur de redirect_page
		request.getRequestDispatcher(redirect_page).forward(request, response);
		
		
	}

}

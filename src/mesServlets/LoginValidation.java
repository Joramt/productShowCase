package mesServlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mesBeans.User;
import pkgAction.UserAction;
import pkgUtils.Constantes;

/**
 * Servlet implementation class LoginValidation
 */
@WebServlet(name = "loginValidation", urlPatterns = { "/loginValidation" })
public class LoginValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginValidation() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Recupération des parametre de la connexion
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		String redirect = "welcome.jsp";
		
		if(email==null){
			request.setAttribute(Constantes.ERROR_KEY, Constantes.NO_EMAIL_MSG);
			redirect = "login.jsp";
		}
		if(pwd==null){
			request.setAttribute(Constantes.ERROR_KEY, Constantes.NO_PWD_MSG);
			redirect = "login.jsp";
		}
		
		User client = UserAction.getUserByMail(email);
		
		if(client == null){
			request.setAttribute(Constantes.ERROR_KEY, Constantes.USER_NOT_IN_DB);
			redirect = "register.jsp";
			request.getRequestDispatcher(redirect).forward(request, response);
		}
		
		client = UserAction.getUserByEmailAndPwd(email, pwd);
		
		if(client == null){
			request.setAttribute(Constantes.ERROR_KEY, Constantes.PWD_INVALID);
			redirect = "login.jsp";
		}
		
		request.setAttribute(Constantes.CLIENT_KEY, client);
		request.getRequestDispatcher(redirect).forward(request, response);
		
		
	}

}

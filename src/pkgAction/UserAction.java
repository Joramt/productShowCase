package pkgAction;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.bcel.internal.classfile.ConstantObject;

import mesBeans.InfosPaiement;
import mesBeans.Produit;
import mesBeans.User;
import pkgManager.ProduitManger;
import pkgManager.UserManager;
import pkgUtils.Constantes;
import pkgUtils.HachageMD5;


public class UserAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserAction() {
        super();
        // TODO Auto-generated constructor stub
    }

    public static ArrayList<String> getAdminByName(String username) {
    	
		return UserManager.getAdminByName(username);
	}
	

	public static User getUserByMail(String email) {
		return UserManager.getUserByMail(email);
	}
	
	public static void AddUser(User client){
		// On encrypt le pwd du client
		String pwdIntact = client.getPwd();
		String pwdEncrypt = HachageMD5.encryptString(client.getPwd());
		
		// On modifie celui existant par celui encrypté
		client.setPwd(pwdEncrypt);
		
		// On l'ajoute a notre DB
		UserManager.AddUser(client);
		
		// On retablie le pwd du client
		
		client.setPwd(pwdIntact);
	}

	public static boolean checkInfosPaiement(InfosPaiement client) {
		
		boolean retour = true;
		
		if(
			(client.getCard() == "")||
			(client.getAdress() == "" )||
			(client.getCCV() == "" )||				
			(client.getPremierNum() == "" )||
			(client.getDeuxiemeNum() == "" )||
			(client.getTroisiemeNum() == "" )||
			(client.getDernierNum() == "" )||
			(client.getExp_month() == "" )||
			(client.getExp_year() == "" )
		)	
			retour = false;
			
		return retour;
	}

	public static void AddPaiement(InfosPaiement paiement) {
		//On encrypt toutes les info sensibles
		
		String premierNumEncrypt = HachageMD5.encryptString(paiement.getPremierNum());
		String deuxiemeNumEncrypt = HachageMD5.encryptString(paiement.getDeuxiemeNum());
		String troisiemeNumEncrypt = HachageMD5.encryptString(paiement.getTroisiemeNum());
		String quatriemeNumEncrypt = HachageMD5.encryptString(paiement.getDernierNum());
		String exp_monthEncrypt = HachageMD5.encryptString(paiement.getExp_month());
		String exp_yearEncrypt = HachageMD5.encryptString(paiement.getExp_year());
		String CCVEncrypt = HachageMD5.encryptString(paiement.getCCV());
		String adressEncrypt = HachageMD5.encryptString(paiement.getAdress());
		
		// Puis on remplace les info contenu par l'encryption
		
		paiement.setPremierNum(premierNumEncrypt);
		paiement.setDeuxiemeNum(deuxiemeNumEncrypt);
		paiement.setTroisiemeNum(troisiemeNumEncrypt);
		paiement.setDernierNum(quatriemeNumEncrypt);
		paiement.setExp_month(exp_monthEncrypt);
		paiement.setExp_year(exp_yearEncrypt);
		paiement.setCCV(CCVEncrypt);
		paiement.setAdress(adressEncrypt);
		
		UserManager.AddInfosPaiement(paiement);
		
	}

	public static User getUserByEmailAndPwd(String email, String pwd) {
		
		//On doit encrypter le pwd car celui de la BD sera encrypté
		String pwdEncrypt = HachageMD5.encryptString(pwd);
		User client = UserManager.getUserByEmailAndPwd(email, pwdEncrypt);
		System.out.println("le pwd recu : " + pwd);
		System.out.println("le pwd crypt : " + pwdEncrypt);
		//On doit decrypter le pwd pour le renvoyer a notre champ de login
		String pwdDecrypt = HachageMD5.decryptString(client.getPwd());
		client.setPwd(pwdDecrypt);
		
		System.out.println("le pwd retourné : " + client.getPwd());
		System.out.println("le pwd decypt : " + pwdDecrypt);
		
		return client;
	}

}

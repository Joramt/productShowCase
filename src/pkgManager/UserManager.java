package pkgManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mesBeans.InfosPaiement;
import mesBeans.Produit;
import mesBeans.User;
import pkgUtils.ConnexionBD;

public class UserManager {
	
	public static String queryGetAdminByName = "select * from admins where admin_nom = ?";
	public static String queryGetUsersByMail = "select * from user where email = ? ";
	public static String queryAddUser = "INSERT INTO user (nom, prenom, email, password, status) VALUES (?, ?, ?, ?, ?)";
	public static String queryAddInfosPaiement = "INSERT INTO infospaiement (typeCarte, premierNum, deuxiemeNum, troisiemeNum, dernierNum, exp_month, exp_year, CCV, adress, emailUser ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )"; 
	public static String queryGetUserByMailAndId = "select * from user where email = ? and password = ?";
	
	public static ArrayList<String> getAdminByName(String username) {
		ArrayList<String> retour = null;

		try {
			PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(queryGetAdminByName);
			ps.setString(1, username);
			ResultSet result = ps.executeQuery();

			while (result.next()) {
				retour = new ArrayList<String>();
				retour.add(result.getString("admin_nom"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ConnexionBD.closeConnection();
		
		return retour;
	}
	
	public static User getUserByMail(String email){
		User retour = null;
		
		try {
			PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(queryGetUsersByMail);
			ps.setString(1, email);
			ResultSet result = ps.executeQuery();
			System.out.println("jessaie de pécho un user");
			while (result.next()) {
				retour = new User();
				retour.setEmail(result.getString("email"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ConnexionBD.closeConnection();
		
		return retour;
	}
	
	public static void AddUser(User client){
		
		// On remplace chaque VALUES de la query par celles contenues dans notre objet client
		try {
			PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(queryAddUser);
			ps.setString(1, client.getNom());
			ps.setString(2, client.getPrenom());
			ps.setString(3, client.getEmail());
			ps.setString(4, client.getPwd());
			ps.setInt(5, client.getStatus());
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ConnexionBD.closeConnection();
		
	}

	public static void AddInfosPaiement(InfosPaiement paiement) {
		
		// On remplace chaque VALUES de la query par les attributs de notre objets InfosPaiement
		try {
			PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(queryAddInfosPaiement);
			ps.setString(1, paiement.getCard());
			ps.setString(2, paiement.getPremierNum());
			ps.setString(3, paiement.getDeuxiemeNum());
			ps.setString(4, paiement.getTroisiemeNum());
			ps.setString(5, paiement.getDernierNum());
			ps.setString(6, paiement.getExp_month());
			ps.setString(7, paiement.getExp_year());
			ps.setString(8, paiement.getCCV());
			ps.setString(9, paiement.getAdress());
			ps.setString(10, paiement.getemailUser());
			ps.executeUpdate();
			System.out.println("Paiement ajouté !");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ConnexionBD.closeConnection();
	}

	public static User getUserByEmailAndPwd(String email, String pwd) {
		
		User retour = null;
		
		try {
			PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(queryGetUserByMailAndId);
			ps.setString(1, email);
			
			
			ps.setString(2, pwd);
			ResultSet result = ps.executeQuery();

			while (result.next()) {
				retour = new User();
				retour.setNom(result.getString("nom"));
				retour.setPrenom(result.getString("prenom"));
				retour.setEmail(result.getString("email"));
				retour.setPwd(result.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ConnexionBD.closeConnection();
		
		return retour;
	}
}

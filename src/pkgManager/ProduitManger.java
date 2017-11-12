package pkgManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mesBeans.Produit;
import pkgUtils.ConnexionBD;

public class ProduitManger {

	private static String queryGetByAll = "select * from produit";
	private static String queryGetById = "select * from produit where id_produit = ?";
	//private static String queryInsert = "insert into produit(nomProduit,stock,dateCreation,categorie,typeVetement,prix,urlImageVitrine) value(?,?,?,?,?,?,?)";
	//private static String queryUpdate = "update produit set nom =?,prenom = ?,age = ?,metier = ?,langage =?,imgLink =? where id = ?";
	//private static String querydelete = "delete from produit where id = ?";
	private static String querytop8byCategorie = "select * from produit where categorie= ? limit 8";
	private static final String queryGetByName = "select * from produit where nomProduit like ?";
	private static final String queryGetByCategorie = "select * from produit where  categorie=?";
	
	

	public static ArrayList<Produit> getAll() {
		ArrayList<Produit> retour = null;

		try {
			PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(queryGetByAll);

			ResultSet result = ps.executeQuery();

			if (result.isBeforeFirst()) {

				retour = new ArrayList<>();

				while (result.next()) {
					
					Produit produit = recupererProduit(result);
					retour.add(produit);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ConnexionBD.closeConnection();

		return retour;
	}

	
public static ArrayList<Produit> getTop8byCategorie(String categorie) {
	ArrayList<Produit> retour = null;
		
	try {
		PreparedStatement ps;
		ps = ConnexionBD.getConnection().prepareStatement(querytop8byCategorie);
		ps.setString(1,  categorie);
		
		ResultSet result = ps.executeQuery();
			if (result.isBeforeFirst()) {
			
			retour = new ArrayList<>();
				while (result.next()) {
					Produit produit = recupererProduit(result);
					retour.add(produit);
			}
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	ConnexionBD.closeConnection();
	
	return retour;

}

	public static Produit getProduitByID(int  idProduit) {
		Produit prod = null;

		PreparedStatement ps;
		try {

			ps = ConnexionBD.getConnection().prepareStatement(queryGetById);
			ps.setInt(1,idProduit);

			ResultSet rs = ps.executeQuery();

			if (rs.isBeforeFirst()) {
				prod = new Produit();
				while (rs.next()) {
					
					 prod = recupererProduit(rs);

					
				}
			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ConnexionBD.closeConnection();

		return prod;
	}

		public static ArrayList<Produit> getByName(String name) {
		ArrayList<Produit> retour = null;

		try {
			PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(queryGetByName);
			ps.setString(1, name);
			ResultSet result = ps.executeQuery();

			if (result.isBeforeFirst()) {

				retour = new ArrayList<>();

				while (result.next()) {
					Produit produit = recupererProduit(result);
					retour.add(produit);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ConnexionBD.closeConnection();

		return retour;
	}
		
		
		public static ArrayList<Produit> getByCategrie(String nomCateg) {
			ArrayList<Produit> retour = null;

			try {
				PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(queryGetByCategorie);
				ps.setString(1, nomCateg);
				ResultSet result = ps.executeQuery();

				if (result.isBeforeFirst()) {

					retour = new ArrayList<>();

					while (result.next()) {
						Produit produit = recupererProduit(result);
						retour.add(produit);
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			ConnexionBD.closeConnection();

			return retour;
		}
		
			
		private final static Produit recupererProduit(ResultSet result) throws SQLException {
			Produit produit = new Produit();
			produit.setId_produit(result.getInt("id_produit"));
			produit.setNom_produit(result.getString("nomProduit"));
			produit.setStock(result.getInt("stock"));
			produit.setDate_creation(result.getDate("dateCreation"));
			produit.setCategorie(result.getString("categorie"));
			produit.setType_vetement(result.getString("typeVetement"));
			produit.setPrix(result.getDouble("prix"));
			produit.setUrl_image_vitrine(result.getString("urlImageVitrine"));
			return produit;
		}
		
		
		
		
		

}

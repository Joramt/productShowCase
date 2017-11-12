package pkgManager;
import javax.servlet.http.HttpServletRequest;

import mesBeans.ImageProduit;
import mesBeans.Produit;
import pkgUtils.ConnexionBD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class ImageProduitManager {



		private static String queryGetByIdProduit = "select * from imageproduit where idProduit = ?";

		
		public static ArrayList<ImageProduit>  getImagesProduitById(int idProduit) {
			ArrayList<ImageProduit> retour = null;

			try {
				PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(queryGetByIdProduit);
				ps.setInt(1, idProduit);
				ResultSet result = ps.executeQuery();

				if (result.isBeforeFirst()) {
					
					retour = new ArrayList<ImageProduit>();

					while (result.next()) {
						ImageProduit imgP = new ImageProduit();
						imgP.setId_image_produit(result.getInt("idImageProduit"));
						imgP.setUrl_image(result.getString("urlImage"));
						imgP.setId_produit(result.getInt("idProduit"));
						

						retour.add(imgP);
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			ConnexionBD.closeConnection();
			
			return retour;
		}
	}



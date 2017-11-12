package pkgManager;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import mesBeans.Commande;
import mesBeans.LigneCommande;
import mesBeans.User;
import pkgUtils.ConnexionBD;

public class LigneCommandeManager {
	private static final String queryInsertLigneCommande = "insert into lignecommande (id_commande , id_produit , quantité ) values (?,?,?); ";

	public static void insert(LigneCommande lc) {

		PreparedStatement ps;
		try {
			ps = ConnexionBD.getConnection().prepareStatement(queryInsertLigneCommande);

			ps.setInt(1, lc.getId_commande());
			ps.setInt(2, lc.getId_produit());
			ps.setInt(3, lc.getQte());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			ConnexionBD.closeConnection();
		}

	}

	public static void main(String argV[]) {

		LigneCommande lc = new LigneCommande();
		lc.setId_commande(10);
		lc.setId_produit(22);
		lc.setQte(12);
		LigneCommandeManager.insert(lc);

	}
}

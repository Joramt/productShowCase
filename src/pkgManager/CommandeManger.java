package pkgManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mesBeans.ImageProduit;
import mesBeans.LigneCommande;
import mesBeans.Produit;
import mesBeans.User;
import pkgUtils.ConnexionBD;

public class CommandeManger {

	private static final String queryInsererCommande = "insert into commande (id_user , date_commande ) values (?,now()); ";
	private static final String queryGetLastIdCommande = "select id_commande from commande order by id_commande desc limit 1";

	public static int insert(User user) {

		int numeroCommande = 0;

		PreparedStatement ps;
		Connection con = null;
		try {

			con = ConnexionBD.getConnection();

			//con.setAutoCommit(false);

			ps = con.prepareStatement(queryInsererCommande);
			ps.setInt(1, user.getIdUser());
			int result = ps.executeUpdate();

			if (result > 0) {
				numeroCommande = GetLastIdCommande();
			//	con.commit();

			}
		} catch (SQLException e) {
			e.printStackTrace();
			

		//		con.rollback();
			

		} finally {

			ConnexionBD.closeConnection();
		}

		return numeroCommande;

	}

	public static int GetLastIdCommande() {
		int numCommande = 0;

		PreparedStatement ps;
		try {
			ps = ConnexionBD.getConnection().prepareStatement(queryGetLastIdCommande);

			ResultSet result = ps.executeQuery();

			if (result.isBeforeFirst()) {
				while (result.next()) {

					numCommande = result.getInt("id_commande");

				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			ConnexionBD.closeConnection();
		}

		return numCommande;

	}

	public static void main(String argV[]) {

		int num = CommandeManger.GetLastIdCommande();
		System.out.println(num);

	}

}

package mesBeans;

import java.io.Serializable;

public class LigneCommande implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int ligne;
	private int id_commande; 
	private int id_produit;
	private int qte ; 
	
	
	public LigneCommande() {
		// TODO Auto-generated constructor stub
	}


	public int getLigne() {
		return ligne;
	}


	public void setLigne(int ligne) {
		this.ligne = ligne;
	}


	public int getId_commande() {
		return id_commande;
	}


	public void setId_commande(int id_commande) {
		this.id_commande = id_commande;
	}


	public int getId_produit() {
		return id_produit;
	}


	public void setId_produit(int id_produit) {
		this.id_produit = id_produit;
	}


	public int getQte() {
		return qte;
	}


	public void setQte(int qte) {
		this.qte = qte;
	}


	@Override
	public String toString() {
		return "LigneCommande [ligne=" + ligne + ", id_commande=" + id_commande + ", id_produit=" + id_produit
				+ ", qte=" + qte + "]";
	}


}

package mesBeans;

import java.io.Serializable;

import java.util.Date;

public class Commande implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id_commande ; 
	private int id_user ; 
	private Date date_commande;

	
	
	public Commande() {
	
	}



	public int getId_commande() {
		return id_commande;
	}



	public void setId_commande(int id_commande) {
		this.id_commande = id_commande;
	}



	public int getId_user() {
		return id_user;
	}



	public void setId_user(int id_user) {
		this.id_user = id_user;
	}



	public Date getDate_commande() {
		return date_commande;
	}



	public void setDate_commande(Date date_commande) {
		this.date_commande = date_commande;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}

package mesBeans;

import java.io.Serializable;
import java.util.Date;

/*enum Categorie {
	Homme, Femme, Bebe, Enfant
}

enum TypeVetement {
	Blousons, Chaussure, Chemises, Jeans, Jupes, Pulls, Robes, Sacs, Manteaux, Pantalons, Sports, Sweat_Shirts, Ballerines
}*/

public class Produit implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	private int id_produit;
	private String nom_produit;
	private int stock;
	private Date date_creation;
	private String categorie;
	private String type_vetement;
	private double prix;
	private String url_image_vitrine;

	public Produit() {
		// TODO Auto-generated constructor stub
	}

	public int getId_produit() {
		return id_produit;
	}

	public void setId_produit(int id_produit) {
		this.id_produit = id_produit;
	}

	public String getNom_produit() {
		return nom_produit;
	}

	public void setNom_produit(String nom_produit) {
		this.nom_produit = nom_produit;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Date getDate_creation() {
		return date_creation;
	}

	public void setDate_creation(Date date_creation) {
		this.date_creation = date_creation;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getType_vetement() {
		return type_vetement;
	}

	public void setType_vetement(String type_vetement) {
		this.type_vetement = type_vetement;
	}

	public double getPrix() {
		return prix;
	}

	@Override
	public String toString() {
		return "Produit [id_produit=" + id_produit + ", nom_produit=" + nom_produit + ", stock=" + stock
				+ ", date_creation=" + date_creation + ", categorie=" + categorie + ", type_vetement=" + type_vetement
				+ ", prix=" + prix + ", url_image_vitrine=" + url_image_vitrine + "]";
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getUrl_image_vitrine() {
		return url_image_vitrine;
	}

	public void setUrl_image_vitrine(String url_image_vitrine) {
		this.url_image_vitrine = url_image_vitrine;
	}

}

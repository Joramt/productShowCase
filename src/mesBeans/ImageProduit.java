package mesBeans;

import java.io.Serializable;

public class ImageProduit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id_image_produit;
	private String url_image;
	private int id_produit;
	
	@Override
	public String toString() {
		return "ImageProduit [id_image_produit=" + id_image_produit + ", url_image=" + url_image + ", id_produit="
				+ id_produit + "]";
	}

	public ImageProduit() {
		// TODO Auto-generated constructor stub
	}

	public int getId_image_produit() {
		return id_image_produit;
	}

	public void setId_image_produit(int id_image_produit) {
		this.id_image_produit = id_image_produit;
	}

	public String getUrl_image() {
		return url_image;
	}

	public void setUrl_image(String url_image) {
		this.url_image = url_image;
	}

	public int getId_produit() {
		return id_produit;
	}

	public void setId_produit(int id_produit) {
		this.id_produit = id_produit;
	}
	
	
}

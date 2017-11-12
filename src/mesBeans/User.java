package mesBeans;

import java.io.Serializable;


enum Statu{
	administrateur, utilisateur
}
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	private int idUser;
	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	private String nom ; 
	private String prenom ; 
	private String email;
	private String pwd;


	private int status;
	 
	 
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String nom, String prenom, String email, String pwd, int status){
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.pwd = pwd;
		this.status = status;
	}


	
	
	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "User [nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", pwd=" + pwd + ", status=" + status
				+ "]";
	}

}

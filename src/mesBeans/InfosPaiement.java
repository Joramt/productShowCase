package mesBeans;
public class InfosPaiement {
	
	private String card;
	private String premierNum;
	private String deuxiemeNum;
	private String troisiemeNum;
	private String dernierNum;
	private String exp_month;
	private String exp_year;
	private String CCV;
	private String adress;
	private String emailUser;
	
	public InfosPaiement(){};
	
	public InfosPaiement(String card, String premierNum, String deuxiemeNum, String troisiemeNum, String dernierNum,
			String exp_month, String exp_year, String CCV, String adress){
		this.card = card;
		this.premierNum = premierNum;
		this.deuxiemeNum = deuxiemeNum;
		this.troisiemeNum = troisiemeNum;
		this.dernierNum = dernierNum;
		this.exp_month = exp_month;
		this.exp_year = exp_year;
		this.CCV = CCV;
		this.adress = adress;
	}
	
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}
	public String getPremierNum() {
		return premierNum;
	}
	public void setPremierNum(String premierNum) {
		this.premierNum = premierNum;
	}
	public String getDeuxiemeNum() {
		return deuxiemeNum;
	}
	public void setDeuxiemeNum(String deuxiemeNum) {
		this.deuxiemeNum = deuxiemeNum;
	}
	public String getTroisiemeNum() {
		return troisiemeNum;
	}
	public void setTroisiemeNum(String troisiemeNum) {
		this.troisiemeNum = troisiemeNum;
	}
	public String getDernierNum() {
		return dernierNum;
	}
	public void setDernierNum(String dernierNum) {
		this.dernierNum = dernierNum;
	}
	public String getExp_month() {
		return exp_month;
	}
	public void setExp_month(String exp_month) {
		this.exp_month = exp_month;
	}
	public String getExp_year() {
		return exp_year;
	}
	public void setExp_year(String exp_year) {
		this.exp_year = exp_year;
	}
	public String getCCV() {
		return CCV;
	}
	public void setCCV(String cCV) {
		CCV = cCV;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getemailUser() {
		return emailUser;
	}

	public void setemailUser(String emailUser) {
		this.emailUser = emailUser;
	}
}

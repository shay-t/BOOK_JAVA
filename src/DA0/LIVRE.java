package DA0;

public class LIVRE {
	private String titre;
	private String auteur;
	private String ISBN;
	private int dispo;
	private double prix;
	//constructeur
	public LIVRE(String titre, String auteur, String iSBN, int dispo, double prix) {
		this.titre = titre;
		this.auteur = auteur;
		ISBN = iSBN;
		this.dispo = dispo;
		this.prix = prix;
	}
	//setters and getters
	public String getTitre() {
		return titre;
	}
	
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public int getDispo() {
		return dispo;
	}
	public void setDispo(int dispo) {
		this.dispo = dispo;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	@Override
	public String toString() {
		return "LIVRE [titre=" + titre + ", auteur=" + auteur + ", ISBN=" + ISBN + ", dispo=" + dispo + ", prix=" + prix
				+ "]";
	}
	//affiche
	public void affiche() {
		System.out.println(toString());
	}
}

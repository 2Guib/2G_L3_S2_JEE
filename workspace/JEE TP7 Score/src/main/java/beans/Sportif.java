package beans;

public class Sportif {
	private int id;
	private String nom;
	private String prenom;
	private String cio;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getCio() {
		return cio;
	}
	public void setCio(String cio) {
		this.cio = cio;
	}
	
	@Override
	public String toString() {
		return cio+ " ( "+prenom+" "+nom+" )";
	}
	
}

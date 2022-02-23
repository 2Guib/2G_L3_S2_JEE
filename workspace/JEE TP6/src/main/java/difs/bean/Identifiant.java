package difs.bean;

import java.util.Date;

public class Identifiant {
	private String nom;
	private String identifiant;
	
	public Identifiant() {
		super();
		this.nom = "Session";
		this.identifiant = "";
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}
	
	
}

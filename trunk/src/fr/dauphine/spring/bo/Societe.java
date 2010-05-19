package fr.dauphine.spring.bo;

public class Societe extends BO {
	
	private String nom;

	public Societe() {
		
	}
	
	public Societe(String id) {
		super(id);
	}

	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}
	
	

}

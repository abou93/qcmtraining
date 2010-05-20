package fr.dauphine.spring.bo;

public class Employe extends BO {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 2176971034998003151L;

	private String nom;
	
	private String prenom;
	
	private Societe societe = new Societe();
	
	public Employe() {
		
	}
	
	public Employe(Long id) {
		super(id);
	}

	public String getNom() {
		return nom;
	}

	
	
	public Employe(Long id, String nom, String prenom, Societe societe) {
		super(id);
		this.nom = nom;
		this.prenom = prenom;
		this.societe = societe;
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

	public Societe getSociete() {
		return societe;
	}

	public void setSociete(Societe societe) {
		this.societe = societe;
	}
	
	

}
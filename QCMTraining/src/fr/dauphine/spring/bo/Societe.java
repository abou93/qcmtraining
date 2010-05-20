package fr.dauphine.spring.bo;

public class Societe extends BO {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5197056563597010001L;
	private String nom;

	public Societe() {
		
	}
	
	public Societe(Long id) {
		super(id);
	}

	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}
	
	

}

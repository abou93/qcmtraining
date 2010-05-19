/**
 * 
 */
package fr.dauphine.spring.bo;

/**
 * @author Mathieu
 *
 */
public class Reponse extends BO {
	private boolean goodResponse;
	private String libelle;
	/**
	 * 
	 */
	public Reponse() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 */
	public Reponse(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * @return the goodResponse
	 */
	public boolean isGoodResponse() {
		return goodResponse;
	}

	/**
	 * @param goodResponse the goodResponse to set
	 */
	public void setGoodResponse(boolean goodResponse) {
		this.goodResponse = goodResponse;
	}

}

/**
 * 
 */
package fr.dauphine.spring.bo;

/**
 * @author Mathieu
 *
 */
public class Reponse extends BO {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3945370594167120554L;
	private boolean goodResponse;
	private String libelle;
	private Question question;
	/**
	 * 
	 */
	public Reponse() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 */
	public Reponse(Long id) {
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

	/**
	 * @return the question
	 */
	public Question getQuestion() {
		return question;
	}

	/**
	 * @param question the question to set
	 */
	public void setQuestion(Question question) {
		this.question = question;
	}

}

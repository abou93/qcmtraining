/**
 * 
 */
package fr.dauphine.spring.bo;

import java.util.Set;

/**
 * @author Mathieu
 *
 */
public class SujetRepondu extends BO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3999767834284009842L;
	private Sujet sujet;
	private Set<Reponse> reponsesChoisies;
	/**
	 * 
	 */
	public SujetRepondu() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 */
	public SujetRepondu(Long id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the sujet
	 */
	public Sujet getSujet() {
		return sujet;
	}

	/**
	 * @param sujet the sujet to set
	 */
	public void setSujet(Sujet sujet) {
		this.sujet = sujet;
	}

	/**
	 * @return the reponsesChoisies
	 */
	public Set<Reponse> getReponsesChoisies() {
		return reponsesChoisies;
	}

	/**
	 * @param reponsesChoisies the reponsesChoisies to set
	 */
	public void setReponsesChoisies(Set<Reponse> reponsesChoisies) {
		this.reponsesChoisies = reponsesChoisies;
	}

}

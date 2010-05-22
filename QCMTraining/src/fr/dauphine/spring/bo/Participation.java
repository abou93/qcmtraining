/**
 * 
 */
package fr.dauphine.spring.bo;

import java.util.List;

import org.apache.commons.beanutils.BeanPropertyValueEqualsPredicate;
import org.apache.commons.collections.CollectionUtils;

/**
 * @author Mathieu
 *
 */
public class Participation extends BO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3999767834284009842L;
	private SujetInfo sujet;
	private List<Reponse> reponsesChoisies;
	private Utilisateur user;
	/**
	 * 
	 */
	public Participation() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 */
	public Participation(Long id) {
		super(id);
		// TODO Auto-generated constructor stub
	}


	/**
	 * @return the sujet
	 */
	public SujetInfo getSujet() {
		return sujet;
	}

	/**
	 * @param sujet the sujet to set
	 */
	public void setSujet(SujetInfo sujet) {
		this.sujet = sujet;
	}

	/**
	 * @return the reponsesChoisies
	 */
	public List<Reponse> getReponsesChoisies() {
		return reponsesChoisies;
	}

	/**
	 * @param reponsesChoisies the reponsesChoisies to set
	 */
	public void setReponsesChoisies(List<Reponse> reponsesChoisies) {
		this.reponsesChoisies = reponsesChoisies;
	}

	/**
	 * @return the user
	 */
	public Utilisateur getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(Utilisateur user) {
		this.user = user;
	}
	
	@SuppressWarnings("unchecked")
	public List<Reponse> getGoodReponse() {
		return (List<Reponse>)CollectionUtils.select(getReponsesChoisies(),
                new BeanPropertyValueEqualsPredicate("goodResponse", true));
	}

}

/**
 * 
 */
package fr.dauphine.spring.bo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mathieu
 *
 */
public class Question extends BO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5325396570270425519L;
	private String libelle;
	private List<Reponse> listResponse;
	private Sujet sujet;
	private int indexResponse;
	
	/**
	 * 
	 */
	public Question() {
		// TODO Auto-generated constructor stub
	}
	
	public void addReponse(short number) {
		if(this.listResponse == null) {
			this.listResponse = new ArrayList<Reponse>(0);
		}
		while(number != 0) {
			Reponse rep = new Reponse();
			rep.setQuestion(this);
			this.listResponse.add(rep);
			number --;
		}
	}
	/**
	 * @param id
	 */
	public Question(Long id) {
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
	 * @return the listResponse
	 */
	public List<Reponse> getListResponse() {
		return listResponse;
	}

	/**
	 * @param listResponse the listResponse to set
	 */
	public void setListResponse(List<Reponse> listResponse) {
		this.listResponse = listResponse;
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
	 * @return the indexResponse
	 */
	public int getIndexResponse() {
		return indexResponse;
	}

	/**
	 * @param indexResponse the indexResponse to set
	 */
	public void setIndexResponse(int indexResponse) {
		this.indexResponse = indexResponse;
	}


}

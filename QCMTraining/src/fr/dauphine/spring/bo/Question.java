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
	private String libelle;
	private List<Reponse> listResponse;
	
	/**
	 * 
	 */
	public Question() {
		// TODO Auto-generated constructor stub
	}
	
	public Question(int numberOfReponse) {
		this.listResponse = new ArrayList<Reponse>(0);
		while(numberOfReponse != 0) {
			Reponse r = new Reponse();
			this.listResponse.add(r);
			numberOfReponse--;
		}
	}

	/**
	 * @param id
	 */
	public Question(String id) {
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

}

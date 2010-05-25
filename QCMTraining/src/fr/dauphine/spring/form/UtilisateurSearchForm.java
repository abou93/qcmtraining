/**
 * 
 */
package fr.dauphine.spring.form;

/**
 * @author Mathieu
 *
 */
public class UtilisateurSearchForm extends AbstractSearchForm {
	private String searchNameOrSurname;
	private String searchEmail;
	
	/**
	 * 
	 */
	public UtilisateurSearchForm() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the searchNameOrSurname
	 */
	public String getSearchNameOrSurname() {
		return searchNameOrSurname;
	}

	/**
	 * @param searchNameOrSurname the searchNameOrSurname to set
	 */
	public void setSearchNameOrSurname(String searchNameOrSurname) {
		this.searchNameOrSurname = searchNameOrSurname;
	}

	/**
	 * @return the searchEmail
	 */
	public String getSearchEmail() {
		return searchEmail;
	}

	/**
	 * @param searchEmail the searchEmail to set
	 */
	public void setSearchEmail(String searchEmail) {
		this.searchEmail = searchEmail;
	}

}

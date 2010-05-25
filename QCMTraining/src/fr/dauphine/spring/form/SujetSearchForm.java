/**
 * 
 */
package fr.dauphine.spring.form;


/**
 * @author Mathieu
 *
 */
public class SujetSearchForm extends AbstractSearchForm {
	private String searchTitre;
	private Long searchInIdCategory;
	private boolean searchActif;
	
	/**
	 * 
	 */
	public SujetSearchForm() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @return the searchActif
	 */
	public boolean isSearchActif() {
		return searchActif;
	}

	/**
	 * @param searchActif the searchActif to set
	 */
	public void setSearchActif(boolean searchActif) {
		this.searchActif = searchActif;
	}

	/**
	 * @return the searchTitre
	 */
	public String getSearchTitre() {
		return searchTitre;
	}

	/**
	 * @param searchTitre the searchTitre to set
	 */
	public void setSearchTitre(String searchTitre) {
		this.searchTitre = searchTitre;
	}

	/**
	 * @return the searchInIdCategory
	 */
	public Long getSearchInIdCategory() {
		return searchInIdCategory;
	}

	/**
	 * @param searchInIdCategory the searchInIdCategory to set
	 */
	public void setSearchInIdCategory(Long searchInIdCategory) {
		this.searchInIdCategory = searchInIdCategory;
	}
	
}

/**
 * 
 */
package fr.dauphine.spring.bo;

/**
 * @author Mathieu
 *
 */
abstract public class AbstractReferenceObject extends BO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String libelle;

	/**
	 * 
	 */
	public AbstractReferenceObject() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 */
	public AbstractReferenceObject(Long id) {
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
	
}

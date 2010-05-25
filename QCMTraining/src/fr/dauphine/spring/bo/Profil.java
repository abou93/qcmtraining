/**
 * 
 */
package fr.dauphine.spring.bo;


/**
 * @author Mathieu
 *
 */
public class Profil extends AbstractReferenceObject {
	
	public static final int ADMIN_CODE = 1;
	public static final int UTILISATEUR_CODE = 2;
	/**
	 * 
	 */
	private static final long serialVersionUID = -8871151908986707520L;
	int code;
	
	/**
	 * 
	 */
	public Profil() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}

}

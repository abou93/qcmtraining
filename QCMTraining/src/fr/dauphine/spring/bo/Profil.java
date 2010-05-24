/**
 * 
 */
package fr.dauphine.spring.bo;

import java.util.List;

/**
 * @author Mathieu
 *
 */
public class Profil extends BO {
	
	public static final int ADMIN_CODE = 1;
	public static final int UTILISATEUR_CODE = 2;
	/**
	 * 
	 */
	private static final long serialVersionUID = -8871151908986707520L;
	String libelle;
	int code;
	
	List<Habilitation> habilitations;
	/**
	 * 
	 */
	public Profil() {
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
	/**
	 * @return the habilitations
	 */
	public List<Habilitation> getHabilitations() {
		return habilitations;
	}
	/**
	 * @param habilitations the habilitations to set
	 */
	public void setHabilitations(List<Habilitation> habilitations) {
		this.habilitations = habilitations;
	}

}

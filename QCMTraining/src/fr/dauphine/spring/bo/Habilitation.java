package fr.dauphine.spring.bo;

public class Habilitation extends BO {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2196455803517145692L;
	String libelle;
	String code;
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
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

}

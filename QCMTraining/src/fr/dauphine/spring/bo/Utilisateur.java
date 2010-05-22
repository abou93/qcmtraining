/**
 * 
 */
package fr.dauphine.spring.bo;

import java.util.Set;

/**
 * @author Mathieu
 *
 */
public class Utilisateur extends BO {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3207586303169750748L;
	private Profil profil;
	private String nom;
	private String prenom;
	private String email;
	private byte[] photo;
	private String password;
	private Set<Participation> mesSujets;
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 
	 */
	public Utilisateur() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the profil
	 */
	public Profil getProfil() {
		return profil;
	}
	/**
	 * @param profil the profil to set
	 */
	public void setProfil(Profil profil) {
		this.profil = profil;
	}
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the photo
	 */
	public byte[] getPhoto() {
		return photo;
	}
	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	/**
	 * @return the mesSujets
	 */
	public Set<Participation> getMesSujets() {
		return mesSujets;
	}
	/**
	 * @param mesSujets the mesSujets to set
	 */
	public void setMesSujets(Set<Participation> mesSujets) {
		this.mesSujets = mesSujets;
	}

}

/**
 * 
 */
package fr.dauphine.spring.bo;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Mathieu
 *
 */
public class SujetInfo extends BO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String titre;
	protected String description;
	protected Date dateStart;
	protected Date dateEnd;
	
	public SujetInfo() {
		super();
	}
	public SujetInfo(Long id) {
		super(id);
	}
	/**
	 * @return the titre
	 */
	public String getTitre() {
		return titre;
	}
	/**
	 * @param titre the titre to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the dateStart
	 */
	public Date getDateStart() {
		return dateStart;
	}
	/**
	 * @param dateStart the dateStart to set
	 */
	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}
	/**
	 * @return the dateEnd
	 */
	public Date getDateEnd() {
		return dateEnd;
	}
	/**
	 * @param dateEnd the dateEnd to set
	 */
	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}
	
	/**
	 * @return true si le sujet est actif
	 */
	public boolean isActif() {
		Date d = new Date();
		return (d.after(dateStart) || d.equals(dateStart)) && (d.before(dateEnd) || d.equals(dateEnd));
	}
}

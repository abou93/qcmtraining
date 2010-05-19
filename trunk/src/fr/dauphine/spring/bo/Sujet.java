/**
 * 
 */
package fr.dauphine.spring.bo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.dauphine.spring.util.Constants;

/**
 * @author Mathieu
 *
 */
public class Sujet extends BO {
	private String titre;
	private String description;
	private List<Question> listQuestion;
	private int nombreDeParticipant;
	private Date dateStart;
	private Date dateEnd;
	/**
	 * 
	 */
	public Sujet() {
		// TODO Auto-generated constructor stub
	}
	public Sujet(int numberOfQuestion) {
		this.listQuestion = new ArrayList<Question>(numberOfQuestion);
		while(numberOfQuestion != 0) {
			Question q = new Question(Constants.PARAM_DEFAULT_NUMBER_REPONSE);
			this.listQuestion.add(q);
			numberOfQuestion --;
		}
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
	 * @param id
	 */
	public Sujet(String id) {
		super(id);
		// TODO Auto-generated constructor stub
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
	 * @return the listQuestion
	 */
	public List<Question> getListQuestion() {
		return listQuestion;
	}

	/**
	 * @param listQuestion the listQuestion to set
	 */
	public void setListQuestion(List<Question> listQuestion) {
		this.listQuestion = listQuestion;
	}

	/**
	 * @return the nombreDeParticipant
	 */
	public int getNombreDeParticipant() {
		return nombreDeParticipant;
	}

	/**
	 * @param nombreDeParticipant the nombreDeParticipant to set
	 */
	public void setNombreDeParticipant(int nombreDeParticipant) {
		this.nombreDeParticipant = nombreDeParticipant;
	}

}

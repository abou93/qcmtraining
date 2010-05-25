/**
 * 
 */
package fr.dauphine.spring.bo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import fr.dauphine.spring.util.Constants;

/**
 * @author Mathieu
 *
 */
public class Sujet extends SujetInfo {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4059193207764486862L;
	
	private List<Question> listQuestion;
	
	
	/**
	 * 
	 */
	public Sujet() {
		// TODO Auto-generated constructor stub
	}
	
	public void addNewQuestion(short number) {
		if(this.listQuestion == null) {
			this.listQuestion = new ArrayList<Question>(0);
		}
		while(number != 0) {
			Question q = new Question();
			q.addReponse((short)Constants.PARAM_DEFAULT_NUMBER_REPONSE);
			q.setSujet(this);
			this.listQuestion.add(q);
			number --;
		}
	}
	public void addOneNewQuestion() {
		this.addNewQuestion((short)1);
	}
	public boolean isActif() {
		Date today = new Date();
		if((this.dateStart.before(today) || this.dateStart.equals(today)) && this.dateEnd.after(today)) {
			return true;
		}
		return false;
	}

	/**
	 * @param id
	 */
	public Sujet(Long id) {
		super(id);
		// TODO Auto-generated constructor stub
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

	public List<Question> getRandomListOfQuestion() {
		List<Question> listShuffle = new ArrayList<Question>(0);
		listShuffle.addAll(listQuestion);
		Collections.shuffle(listShuffle);
		if(nbQuestionDisplay < listShuffle.size()) {
			listShuffle.subList(0, nbQuestionDisplay).clear();
		}
		for(Question quest : listShuffle) {
			Collections.shuffle(quest.getListResponse());
		}
		return listShuffle;
	}

}

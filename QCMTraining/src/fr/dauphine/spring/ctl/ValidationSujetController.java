/**
 * 
 */
package fr.dauphine.spring.ctl;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import fr.dauphine.spring.bo.Question;
import fr.dauphine.spring.bo.Reponse;
import fr.dauphine.spring.bo.Sujet;
import fr.dauphine.spring.manager.SujetManager;
import fr.dauphine.spring.util.Constants;

/**
 * @author Mathieu
 * 
 */
@SuppressWarnings("deprecation")
public class ValidationSujetController extends SimpleFormController {

	SujetManager manager;
	private String nameOfView;
	private String nameOfObject;
	

	/**
	 * 
	 */
	public ValidationSujetController() {
		// TODO Auto-generated constructor stub
	}

	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
		binder.registerCustomEditor(Date.class, editor);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.servlet.mvc.SimpleFormController#onSubmit(javax
	 * .servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse,
	 * java.lang.Object, org.springframework.validation.BindException)
	 */
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		ModelAndView mav = null;
		String subAction = request
				.getParameter(Constants.PARAM_SUB_ACTION_NAME);
		if (subAction != null) {
			if (subAction.equals(Constants.PARAM_SUB_ACTION_ADD_QUESTION)) {
				mav = this.addQuestionToForm(command);
			} else if (subAction
					.equals(Constants.PARAM_SUB_ACTION_REMOVE_QUESTION)) {
				String indexQuestionString = request
						.getParameter(Constants.PARAM_INDEX_QUESTION);
				if (null != indexQuestionString
						&& !indexQuestionString.isEmpty()) {
					Integer indexQuestion = Integer
							.parseInt(indexQuestionString);
					mav = this.removeQuestion(command, indexQuestion);
				}
			} else {
				mav = this.onSubmit(command);
			}
		} else {
			mav = this.onSubmit(command);
		}
		return mav;
	}

	private ModelAndView removeQuestion(Object command, int indexQuestion) {
		ModelAndView mav = new ModelAndView(nameOfView);
		Sujet sujet = (Sujet) command;
		if (indexQuestion < sujet.getListQuestion().size()) {
			sujet.getListQuestion().remove(indexQuestion);
		}
		mav.addObject(nameOfObject, sujet);
		return mav;
	}

	private ModelAndView addQuestionToForm(Object command) {
		ModelAndView mav = new ModelAndView(nameOfView);
		Sujet sujet = (Sujet) command;
		sujet.addOneNewQuestion();
		mav.addObject(nameOfObject, sujet);
		return mav;
	}

	@Override
	protected ModelAndView onSubmit(Object command) throws Exception {

		Sujet sujet = (Sujet) command;
		System.out.println(">> Sujet : " + sujet.getTitre());
		for(Question quest : sujet.getListQuestion()) {
			quest.getListResponse().get(quest.getIndexResponseTrue()).setGoodResponse(true);
		}
		manager.save(sujet);

		return super.onSubmit(command);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.servlet.mvc.BaseCommandController#onBindAndValidate
	 * (javax.servlet.http.HttpServletRequest, java.lang.Object,
	 * org.springframework.validation.BindException)
	 */
	@Override
	protected void onBindAndValidate(HttpServletRequest request,
			Object command, BindException errors) throws Exception {
		// TODO Auto-generated method stub
		String subAction = request
				.getParameter(Constants.PARAM_SUB_ACTION_NAME);
		Sujet sujet = (Sujet) command;
		if (subAction == null || subAction.isEmpty()) {
			if (sujet == null) {
				errors.rejectValue("sujetForm", "Erreur!", null,
						"Le sujet de QCM est absent.");
			} else {
				if (sujet.getDateStart() == null) {
					errors.rejectValue("dateStart", "Valeur manquante!", null,
							"La date de lancement est obligatoire.");
				}
				if (sujet.getDateEnd() == null) {
					errors.rejectValue("dateEnd", "Valeur manquante!", null,
							"La date de fin est obligatoire.");
				}
				if (sujet.getTitre() == null || sujet.getTitre().isEmpty()) {
					errors.rejectValue("titre", "Valeur manquante!", null,
							"Le titre du QCM est obligatoire.");
				}
				for (short i = 0; i < sujet.getListQuestion().size(); i++) {
					Question question = sujet.getListQuestion().get(i);
					if (question.getLibelle() == null
							|| question.getLibelle().isEmpty()) {
						errors.rejectValue("listQuestion[" + i + "].libelle",
								"Valeur manquante!", null,
								"Le libellé de la question n°" + (i + 1)
										+ " est obligatoire.");
					}
					for (short j = 0; j < question.getListResponse().size(); j++) {
						Reponse rep = question.getListResponse().get(j);
						if (rep.getLibelle() == null
								|| rep.getLibelle().isEmpty()) {
							errors.rejectValue("listQuestion[" + i
									+ "].listResponse[" + j + "].libelle",
									"Valeur manquante!", null,
									"Le libellé de la réponse n°" + (j + 1)
											+ " à la question n°" + (i + 1)
											+ " est obligatoire.");
						}
					}
				}
			}
		}
	}

	/**
	 * @return the manager
	 */
	public SujetManager getManager() {
		return manager;
	}

	/**
	 * @param manager
	 *            the manager to set
	 */
	public void setManager(SujetManager manager) {
		this.manager = manager;
	}

	/**
	 * @return the nameOfView
	 */
	public String getNameOfView() {
		return nameOfView;
	}

	/**
	 * @param nameOfView
	 *            the nameOfView to set
	 */
	public void setNameOfView(String nameOfView) {
		this.nameOfView = nameOfView;
	}

	/**
	 * @return the nameOfObject
	 */
	public String getNameOfObject() {
		return nameOfObject;
	}

	/**
	 * @param nameOfObject
	 *            the nameOfObject to set
	 */
	public void setNameOfObject(String nameOfObject) {
		this.nameOfObject = nameOfObject;
	}

}

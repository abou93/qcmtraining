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

import fr.dauphine.spring.bo.Question;
import fr.dauphine.spring.bo.Reponse;
import fr.dauphine.spring.bo.Sujet;
import fr.dauphine.spring.util.Constants;

/**
 * @author Mathieu
 * 
 */
public class ValidationSujetController extends DefaultSimpleFormController<Sujet> {

	/**
	 * 
	 */
	public ValidationSujetController() {
		// TODO Auto-generated constructor stub
	}
	@Override
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
		if(mav==null) {
			constructView();
		}
		return mav;
	}

	private ModelAndView removeQuestion(Object command, int indexQuestion) {
		ModelAndView mav = constructView();
		Sujet sujet = (Sujet) command;
		if (indexQuestion < sujet.getListQuestion().size()) {
			sujet.getListQuestion().remove(indexQuestion);
		}
		mav.addObject(nameOfObject, sujet);
		return mav;
	}

	private ModelAndView addQuestionToForm(Object command) {
		ModelAndView mav = constructView();
		Sujet sujet = (Sujet) command;
		sujet.addOneNewQuestion();
		mav.addObject(nameOfObject, sujet);
		return mav;
	}

	protected ModelAndView onSubmit(Object command) throws Exception {
		Sujet sujet = (Sujet) command;
		System.out.println(">> Sujet : " + sujet.getTitre());
		for(Question quest : sujet.getListQuestion()) {
			quest.getListResponse().get(quest.getIndexResponse()).setGoodResponse(true);
		}
		manager.save(sujet);
		ModelAndView mav = constructView();
		mav.setViewName("redirect:voirSujet.do?" + Constants.PARAM_REQUEST_ID +"="+ sujet.getId());
		return mav;
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
				boolean errorQuestion = false;
				boolean reponseErreur = false;
				for (short i = 0; i < sujet.getListQuestion().size(); i++) {
					Question question = sujet.getListQuestion().get(i);
					if (!errorQuestion && (question.getLibelle() == null
							|| question.getLibelle().isEmpty())) {
						errors.rejectValue("listQuestion[" + i + "].libelle",
								"Valeur manquante!", null,
								"Le libellé des questions est obligatoire.");
						errorQuestion = true;
					}
					
					for (short j = 0;!reponseErreur && j < question.getListResponse().size(); j++) {
						Reponse rep = question.getListResponse().get(j);
						if (rep.getLibelle() == null
								|| rep.getLibelle().isEmpty()) {
							errors.rejectValue("listQuestion[" + i
									+ "].listResponse[" + j + "].libelle",
									"Valeur manquante!", null,
									"Le libellé des réponses est obligatoire.");
							reponseErreur = true;
						}
					}
				}
			}
		}
	}
}
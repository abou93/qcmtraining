/**
 * 
 */
package fr.dauphine.spring.ctl;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;

import fr.dauphine.spring.bo.Question;
import fr.dauphine.spring.bo.Reponse;
import fr.dauphine.spring.bo.Sujet;
import fr.dauphine.spring.manager.SujetManager;
import fr.dauphine.spring.util.Constants;

/**
 * @author Mathieu
 * 
 */
public class ValidationSujetController extends DefaultSimpleFormController<Sujet> {
	SujetManager sujetManager;
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
				mav = this.addQuestionToForm(command, request);
			} else if (subAction
					.equals(Constants.PARAM_SUB_ACTION_REMOVE_QUESTION)) {
				String indexQuestionString = request
						.getParameter(Constants.PARAM_INDEX_QUESTION);
				if (null != indexQuestionString
						&& !indexQuestionString.isEmpty()) {
					Integer indexQuestion = Integer
							.parseInt(indexQuestionString);
					mav = this.removeQuestion(command, indexQuestion, request);
				}
			} else {
				mav = this.onSubmit(command, request);
			}
		} else {
			mav = this.onSubmit(command, request);
		}
		if(mav==null) {
			constructView();
		}
		return mav;
	}

	private ModelAndView removeQuestion(Object command, int indexQuestion, HttpServletRequest request) {
		ModelAndView mav = constructView();
		Sujet sujet = (Sujet) command;
		if (indexQuestion < sujet.getListQuestion().size()) {
			sujet.getListQuestion().remove(indexQuestion);
		}
		mav.addObject(nameOfObject, sujet);
		return mav;
	}

	private ModelAndView addQuestionToForm(Object command, HttpServletRequest request) {
		ModelAndView mav = constructView();
		Sujet sujet = (Sujet) command;
		sujet.addOneNewQuestion();
		mav.addObject(nameOfObject, sujet);
		return mav;
	}
	
	private void addCategoriesToForm(HttpServletRequest request) {
		request.setAttribute(CreationSujetController.PARAM_LIST_CATEGORY, ((SujetManager)manager).listeCategory());
	}

	protected ModelAndView onSubmit(Object command, HttpServletRequest request) throws Exception {
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
		addCategoriesToForm(request);
		if (StringUtils.isEmpty(subAction)) {
			if (sujet == null) {
				errors.rejectValue("sujetForm", "Erreur!", null, resource.getString(Constants.ERROR_SUJET_NULL));
			} else {
				if (sujet.getDateStart() != null && sujet.getDateEnd() != null) {
					if(sujet.getDateEnd().before(sujet.getDateStart()) || sujet.getDateEnd().equals(sujet.getDateStart())) {
						errors.rejectValue("dateStart", "Date invalide!", null, resource.getString(Constants.ERROR_SUJET_DATE_DEB_AFTER_DATE_END));
					}
				} else {
					if (sujet.getDateStart() == null) {
						errors.rejectValue("dateStart", "Valeur manquante!", null, resource.getString(Constants.ERROR_SUJET_DATE_DEB));
					}
					if (sujet.getDateEnd() == null) {
						errors.rejectValue("dateEnd", "Valeur manquante!", null, resource.getString(Constants.ERROR_SUJET_DATE_FIN));
					}
				}
				if (StringUtils.isEmpty(sujet.getTitre())) {
					errors.rejectValue("titre", "Valeur manquante!", null, resource.getString(Constants.ERROR_SUJET_TITRE));
				}
				if (sujet.getNbQuestionDisplay() == null) {
					errors.rejectValue("nbQuestionDisplay", "Valeur manquante!", null, 
							resource.getString(Constants.ERROR_SUJET_NBQUESTIONDISPLAY_NULL));
				} else if(sujet.getNbQuestionDisplay() < 0 || sujet.getNbQuestionDisplay() > sujet.getListQuestion().size()) {
					errors.rejectValue("nbQuestionDisplay", "Valeur incorrect", null, 
							MessageFormat.format(resource.getString(Constants.ERROR_SUJET_NBQUESTIONDISPLAY_VALEUR),
									sujet.getListQuestion().size()));
				}
				boolean errorQuestion = false;
				boolean reponseErreur = false;
				for (short i = 0; i < sujet.getListQuestion().size(); i++) {
					Question question = sujet.getListQuestion().get(i);
					if (!errorQuestion && (StringUtils.isEmpty(question.getLibelle()))) {
						errors.rejectValue("listQuestion[" + i + "].libelle",
								"Valeur manquante!", null, resource.getString(Constants.ERROR_SUJET_QUESTION_LIBELLE));
						errorQuestion = true;
					}
					
					for (short j = 0;!reponseErreur && j < question.getListResponse().size(); j++) {
						Reponse rep = question.getListResponse().get(j);
						if (StringUtils.isEmpty(rep.getLibelle())) {
							errors.rejectValue("listQuestion[" + i
									+ "].listResponse[" + j + "].libelle",
									"Valeur manquante!", null, resource.getString(Constants.ERROR_SUJET_QUESTION_REPONSE_LIBELLE));
							reponseErreur = true;
						}
					}
				}
			}
		}
	}
	/**
	 * @return the sujetManager
	 */
	public SujetManager getSujetManager() {
		return sujetManager;
	}
	/**
	 * @param sujetManager the sujetManager to set
	 */
	public void setSujetManager(SujetManager sujetManager) {
		this.sujetManager = sujetManager;
	}
	
}
/**
 * 
 */
package fr.dauphine.spring.ctl;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

import fr.dauphine.spring.bo.Participation;
import fr.dauphine.spring.bo.Question;
import fr.dauphine.spring.bo.Reponse;
import fr.dauphine.spring.util.Constants;

/**
 * @author Mathieu
 *
 */
public class ValidationParticipationController extends
		DefaultSimpleFormController<Participation> {

	/**
	 * 
	 */
	public ValidationParticipationController() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.SimpleFormController#onSubmit(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.validation.BindException)
	 */
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		ModelAndView mav = constructView();
		Participation part = (Participation) command;
		part.setReponsesChoisies(new ArrayList<Reponse>(0));
		for(Question quest : part.getListToDisplay()) {
			part.getReponsesChoisies().add(quest.getListResponse().get(quest.getIndexResponse()));
		}
		manager.save(part);
		mav.setViewName("redirect:viewParticipation.do?" + Constants.PARAM_REQUEST_ID +"="+ part.getId());
		return mav;
	}
	
}

/**
 * 
 */
package fr.dauphine.spring.ctl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import fr.dauphine.spring.bo.BO;
import fr.dauphine.spring.manager.AbstractManager;
import fr.dauphine.spring.util.Constants;

/**
 * @author Mathieu
 *
 */
public class DefaultSuppressionController<TypeObject extends BO> extends DefaultController implements Controller {
	private AbstractManager<TypeObject> manager;
	/**
	 * 
	 */
	public DefaultSuppressionController() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.Controller#handleRequest(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse reponse) throws Exception {
		ModelAndView mav = null;
		String idString = request.getParameter(Constants.PARAM_REQUEST_ID);
		if(StringUtils.isEmpty(idString)) {
			mav = constructErrorView(request);
			this.addError(request, resource.getString(PARAM_ERROR_ID_NULL));
		} else {
			
			Long id = Long.parseLong(idString);
			mav = constructSuccessView(request);
			if(secureAccess(request)) {
				TypeObject obj = manager.read(id);
				manager.delete(obj);
			}
		}
		
		return mav;
	}
	
	/**
	 * @return the manager
	 */
	public AbstractManager<TypeObject> getManager() {
		return manager;
	}

	/**
	 * @param manager the manager to set
	 */
	public void setManager(AbstractManager<TypeObject> manager) {
		this.manager = manager;
	}

}

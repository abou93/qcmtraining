/**
 * 
 */
package fr.dauphine.spring.ctl;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

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
public class DefaultViewController<TypeObject extends BO> extends DefaultController<TypeObject> implements Controller {
	private static final String PARAM_ERROR_ID_NULL = "view.object.id.null";
	private String errorView;
	private ResourceBundle resource = ResourceBundle.getBundle(Constants.PARAM_NAME_PROPERTIES_FILE);
	private AbstractManager<TypeObject> manager;
	/**
	 * 
	 */
	public DefaultViewController() {
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
			mav = new ModelAndView(errorView);
			this.addError(request, resource.getString(PARAM_ERROR_ID_NULL));
		} else {
			Long id = Long.parseLong(idString);
			mav = constructView();
			TypeObject obj = manager.read(id);
			mav.addObject(nameOfObject, obj);
		}
		
		return mav;
	}
	
	@SuppressWarnings("unchecked")
	private void addError(HttpServletRequest request, String msg) {
		List<String> listErrors = (List<String>) request.getAttribute(Constants.PARAM_NAME_LIST_ERRORS);
		if(listErrors == null) {
			listErrors = new ArrayList<String>(0);
		}
		listErrors.add(msg);
		request.setAttribute(Constants.PARAM_NAME_LIST_ERRORS, listErrors);
	}

	/**
	 * @return the errorView
	 */
	public String getErrorView() {
		return errorView;
	}

	/**
	 * @param errorView the errorView to set
	 */
	public void setErrorView(String errorView) {
		this.errorView = errorView;
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

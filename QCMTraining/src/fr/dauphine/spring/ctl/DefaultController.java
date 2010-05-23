/**
 * 
 */
package fr.dauphine.spring.ctl;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import fr.dauphine.spring.util.Constants;

/**
 * @author Mathieu
 *
 */
abstract class DefaultController {
	protected static final String PARAM_ERROR_ID_NULL = "view.object.id.null";
	protected String nameOfPageContent;
	protected String nameOfObject;
	protected String nameOfErrorPage;
	protected String activePage;
	protected ResourceBundle resource = ResourceBundle.getBundle(Constants.PARAM_NAME_PROPERTIES_FILE);
	
	/**
	 * 
	 */
	public DefaultController() {
		// TODO Auto-generated constructor stub
	}
	public ModelAndView constructBasicIndexView() {
		ModelAndView mav = new ModelAndView(Constants.PARAM_INDEX_VIEW);
		addStandardObjectToView(mav);
		return mav;
	}
	
	public ModelAndView constructSuccessView() {
		ModelAndView mav = constructBasicIndexView();
		mav.addObject(Constants.PARAM_PAGE_CONTENT, nameOfPageContent);
		return mav;
	}
	public ModelAndView constructErrorView() {
		ModelAndView mav = constructBasicIndexView();
		mav.addObject(Constants.PARAM_PAGE_CONTENT, nameOfErrorPage);
		return mav;
	}
	protected ModelAndView addStandardObjectToView(ModelAndView mav) {
		mav.addObject(Constants.PARAM_ACTIVEPAGE, activePage);
		return mav;
	}
	@SuppressWarnings("unchecked")
	protected void addError(HttpServletRequest request, String msg) {
		List<String> listErrors = (List<String>) request.getAttribute(Constants.PARAM_NAME_LIST_ERRORS);
		if(listErrors == null) {
			listErrors = new ArrayList<String>(0);
		}
		listErrors.add(msg);
		request.setAttribute(Constants.PARAM_NAME_LIST_ERRORS, listErrors);
	}

	/**
	 * @return the nameOfObject
	 */
	public String getNameOfObject() {
		return nameOfObject;
	}

	/**
	 * @param nameOfObject the nameOfObject to set
	 */
	public void setNameOfObject(String nameOfObject) {
		this.nameOfObject = nameOfObject;
	}
	
	/**
	 * @return the nameOfPageContent
	 */
	public String getNameOfPageContent() {
		return nameOfPageContent;
	}
	/**
	 * @param nameOfPageContent the nameOfPageContent to set
	 */
	public void setNameOfPageContent(String nameOfPageContent) {
		this.nameOfPageContent = nameOfPageContent;
	}
	/**
	 * @return the nameOfErrorPage
	 */
	public String getNameOfErrorPage() {
		return nameOfErrorPage;
	}
	/**
	 * @param nameOfErrorPage the nameOfErrorPage to set
	 */
	public void setNameOfErrorPage(String nameOfErrorPage) {
		this.nameOfErrorPage = nameOfErrorPage;
	}
	/**
	 * @return the activePage
	 */
	public String getActivePage() {
		return activePage;
	}
	/**
	 * @param activePage the activePage to set
	 */
	public void setActivePage(String activePage) {
		this.activePage = activePage;
	}
	/**
	 * @return the resource
	 */
	public ResourceBundle getResource() {
		return resource;
	}
	/**
	 * @param resource the resource to set
	 */
	public void setResource(ResourceBundle resource) {
		this.resource = resource;
	}
	
}

/**
 * 
 */
package fr.dauphine.spring.ctl;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import fr.dauphine.spring.bo.Profil;
import fr.dauphine.spring.bo.Utilisateur;
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
	protected int activePage;
	protected int codeSecure;
	protected ResourceBundle resource = ResourceBundle.getBundle(Constants.PARAM_NAME_PROPERTIES_FILE);
	
	/**
	 * 
	 */
	public DefaultController() {
		// TODO Auto-generated constructor stub
	}
	public ModelAndView constructBasicIndexView(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(Constants.PARAM_INDEX_VIEW);
		if(secureAccess(request)) {
			addStandardObjectToView(mav);
		} else {
			mav.setViewName(Constants.REDIRECT_ACCUEIL_VIEW);
		}
		return mav;
	}
	
	protected boolean secureAccess(HttpServletRequest request) {
		boolean isAuthorized = true;
		if(codeSecure != 0) {
			Utilisateur user = (Utilisateur)request.getSession().getAttribute(Constants.PARAM_USER_SESSION);
			if(codeSecure == Profil.ADMIN_CODE) {
				if(!isAuthorized(user, Profil.ADMIN_CODE)) {
					isAuthorized = false;
				}
			} else if(codeSecure == Profil.UTILISATEUR_CODE) {
				if(!isAuthorized(user, Profil.UTILISATEUR_CODE) && !isAuthorized(user, Profil.ADMIN_CODE)) {
					isAuthorized = false;
				}
			}
		}
		return isAuthorized;
	}
	private boolean isAuthorized(Utilisateur user, int codeProfil) {
		if(user != null && user.getProfil() != null && user.getProfil().getCode() == codeProfil) {
			return true;
		}
		return false;
	}
	public ModelAndView constructSuccessView(HttpServletRequest request) {
		ModelAndView mav = constructBasicIndexView(request);
		mav.addObject(Constants.PARAM_PAGE_CONTENT, nameOfPageContent);
		return mav;
	}
	public ModelAndView constructErrorView(HttpServletRequest request) {
		ModelAndView mav = constructBasicIndexView(request);
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
	public int getActivePage() {
		return activePage;
	}
	/**
	 * @param activePage the activePage to set
	 */
	public void setActivePage(int activePage) {
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
	/**
	 * @return the codeSecure
	 */
	public int getCodeSecure() {
		return codeSecure;
	}
	/**
	 * @param codeSecure the codeSecure to set
	 */
	public void setCodeSecure(int codeSecure) {
		this.codeSecure = codeSecure;
	}
	
	
}

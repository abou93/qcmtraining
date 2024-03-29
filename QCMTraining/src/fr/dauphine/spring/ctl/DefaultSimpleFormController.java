/**
 * 
 */
package fr.dauphine.spring.ctl;

import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import fr.dauphine.spring.bo.BO;
import fr.dauphine.spring.bo.Profil;
import fr.dauphine.spring.bo.Utilisateur;
import fr.dauphine.spring.manager.AbstractManager;
import fr.dauphine.spring.util.Constants;

/**
 * @author Mathieu
 *
 */
@SuppressWarnings("deprecation")
public class DefaultSimpleFormController<TypeObject extends BO> extends SimpleFormController {
	protected static final ResourceBundle resource = ResourceBundle.getBundle(Constants.PARAM_NAME_PROPERTIES_FILE);
	protected String nameOfPageContent;
	protected String nameOfObject;
	protected int activePage;
	protected int codeSecure;
	protected AbstractManager<TypeObject> manager;
	
	
	/**
	 * 
	 */
	public DefaultSimpleFormController() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = null;
		if(!secureAccess(request)) {
			mav = new ModelAndView(Constants.REDIRECT_ACCUEIL_VIEW);
		} else {
			mav = super.handleRequest(request, response);
		}
		mav = addStandardObjectToView(mav);
		return mav;
	}
	protected void populateUserInSession(Utilisateur utilisateur,
			HttpServletRequest request) {
		Profil profil = new Profil();
		profil.setCode(utilisateur.getProfil().getCode());
		profil.setId(utilisateur.getProfil().getId());
		profil.setLibelle(utilisateur.getProfil().getLibelle());
		Utilisateur util = new Utilisateur();
		util.setId(utilisateur.getId());
		util.setEmail(utilisateur.getEmail());
		util.setNom(utilisateur.getNom());
		util.setPrenom(utilisateur.getPrenom());
		util.setProfil(profil);
		request.getSession().setAttribute(Constants.PARAM_USER_SESSION, util);
	}
	public ModelAndView constructView() {
		ModelAndView mav = new ModelAndView(Constants.PARAM_INDEX_VIEW);
		mav = addStandardObjectToView(mav);
		return mav;
	}
	protected ModelAndView addStandardObjectToView(ModelAndView mav) {
		mav.addObject(Constants.PARAM_PAGE_CONTENT, nameOfPageContent);
		mav.addObject(Constants.PARAM_ACTIVEPAGE, activePage);
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
					isAuthorized=false;
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
	/**
	 * @return the resource
	 */
	public ResourceBundle getResource() {
		return resource;
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

/**
 * 
 */
package fr.dauphine.spring.ctl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import fr.dauphine.spring.bo.BO;
import fr.dauphine.spring.manager.AbstractManager;
import fr.dauphine.spring.util.Constants;

/**
 * @author Mathieu
 *
 */
@SuppressWarnings("deprecation")
public class DefaultSimpleFormController<TypeObject extends BO> extends SimpleFormController {
	
	protected String nameOfPageContent;
	protected String nameOfObject;
	protected String activePage;
	protected AbstractManager<TypeObject> manager;
	
	/**
	 * 
	 */
	public DefaultSimpleFormController() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = super.handleRequest(request, response);
		mav = addStandardObjectToView(mav);
		return mav;
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

}

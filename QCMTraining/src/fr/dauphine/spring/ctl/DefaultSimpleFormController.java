/**
 * 
 */
package fr.dauphine.spring.ctl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import fr.dauphine.spring.bo.BO;
import fr.dauphine.spring.bo.Utilisateur;
import fr.dauphine.spring.manager.AbstractManager;
import fr.dauphine.spring.util.Constants;

/**
 * @author Mathieu
 *
 */
@SuppressWarnings("deprecation")
public class DefaultSimpleFormController<TypeObject extends BO> extends SimpleFormController {
	
	protected String nameOfView;
	protected String nameOfObject;
	protected String nameOfPageContent;
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
		mav.addObject(Constants.PARAM_PAGE_CONTENT, nameOfPageContent);
		return mav;
	}
	public ModelAndView constructView() {
		ModelAndView mav = new ModelAndView(nameOfView);
		mav.addObject(Constants.PARAM_PAGE_CONTENT, nameOfPageContent);
		return mav;
	}
	/**
	 * @return the nameOfView
	 */
	public String getNameOfView() {
		return nameOfView;
	}
	/**
	 * @param nameOfView the nameOfView to set
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
	
	public String getNameOfPageContent() {
		return nameOfPageContent;
	}
	
	public void setNameOfPageContent(String nameOfPageContent) {
		this.nameOfPageContent = nameOfPageContent;
	}

}

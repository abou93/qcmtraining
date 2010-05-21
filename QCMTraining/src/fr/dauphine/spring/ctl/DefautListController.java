/**
 * 
 */
package fr.dauphine.spring.ctl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import fr.dauphine.spring.bo.BO;
import fr.dauphine.spring.manager.AbstractManager;
import fr.dauphine.spring.util.Constants;

/**
 * @author Mathieu
 *
 */
public class DefautListController<T extends BO> extends AbstractController {
	AbstractManager<T> manager;
	private String nameOfView;
	private String nameOfList;
	/**
	 * 
	 */
	public DefautListController() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.AbstractController#handleRequestInternal(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView(nameOfView);
		mav.addObject(nameOfList, manager.list());
		request.getSession().setAttribute(Constants.PARAM_PAGE_CONTENT,Constants.PARAM_CONTENT_LISTEUSER);
		return mav;
	}

	/**
	 * @return the manager
	 */
	public AbstractManager<T> getManager() {
		return manager;
	}

	/**
	 * @param manager the manager to set
	 */
	public void setManager(AbstractManager<T> manager) {
		this.manager = manager;
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
	 * @return the nameOfList
	 */
	public String getNameOfList() {
		return nameOfList;
	}

	/**
	 * @param nameOfList the nameOfList to set
	 */
	public void setNameOfList(String nameOfList) {
		this.nameOfList = nameOfList;
	}
	
}

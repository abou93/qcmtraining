/**
 * 
 */
package fr.dauphine.spring.ctl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import fr.dauphine.spring.bo.Utilisateur;
import fr.dauphine.spring.util.Constants;


/**
 * @author Mathieu
 *
 */

@SuppressWarnings("deprecation")
public class AdminAccueilController extends DefaultSimpleFormController<Utilisateur> {
	
	/**
	 * 
	 */
	public AdminAccueilController() {
		// TODO Auto-generated constructor stub
	}
	
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = constructView();
		request.getSession().setAttribute(Constants.PARAM_ACTIVEPAGE,Constants.PARAM_ACTIVEPAGE_ADMINISTRATION);
		return mav;
	}

	public String getNameOfView() {
		return nameOfView;
	}

	public void setNameOfView(String nameOfView) {
		this.nameOfView = nameOfView;
	}

	public String getNameOfPageContent() {
		return nameOfPageContent;
	}

	public void setNameOfPageContent(String nameOfPageContent) {
		this.nameOfPageContent = nameOfPageContent;
	}
}

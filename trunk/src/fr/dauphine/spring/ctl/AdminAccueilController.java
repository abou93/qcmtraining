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
public class AdminAccueilController extends SimpleFormController {
	
	/**
	 * 
	 */
	public AdminAccueilController() {
		// TODO Auto-generated constructor stub
	}
	
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("index");
		request.getSession().setAttribute(Constants.PARAM_PAGE_CONTENT,Constants.PARAM_CONTENT_INDEXADMIN);
		return mav;
	}
}

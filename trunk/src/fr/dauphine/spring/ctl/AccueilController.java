/**
 * 
 */
package fr.dauphine.spring.ctl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import fr.dauphine.spring.bo.Utilisateur;


/**
 * @author Mathieu
 *
 */

@SuppressWarnings("deprecation")
public class AccueilController extends SimpleFormController {
	
	/**
	 * 
	 */
	public AccueilController() {
		// TODO Auto-generated constructor stub
	}
	
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("utilisateur", new Utilisateur());
		return mav;
	}
}

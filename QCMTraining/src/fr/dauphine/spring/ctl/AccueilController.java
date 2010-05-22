/**
 * 
 */
package fr.dauphine.spring.ctl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import fr.dauphine.spring.bo.Utilisateur;
import fr.dauphine.spring.util.Constants;


/**
 * @author Mathieu
 *
 */

@SuppressWarnings("deprecation")
public class AccueilController extends DefaultSimpleFormController<Utilisateur> {
	
	public AccueilController() {
		// TODO Auto-generated constructor stub
	}
	
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = constructView();
		mav.addObject("utilisateur", new Utilisateur());
		request.getSession().setAttribute(Constants.PARAM_ACTIVEPAGE,Constants.PARAM_ACTIVEPAGE_ACCUEIL);
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

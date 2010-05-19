/**
 * 
 */
package fr.dauphine.spring.ctl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import fr.dauphine.spring.bo.Sujet;

/**
 * @author Mathieu
 * 
 */
public class CreationSujetController implements Controller {

	private String nameOfView;
	private String nameOfObject;

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView(nameOfView);
		Sujet s = new Sujet(1);
		mav.addObject(nameOfObject, s);
		return mav;
	}


	/**
	 * @return the nameOfView
	 */
	public String getNameOfView() {
		return nameOfView;
	}

	/**
	 * @param nameOfView
	 *            the nameOfView to set
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
	 * @param nameOfObject
	 *            the nameOfObject to set
	 */
	public void setNameOfObject(String nameOfObject) {
		this.nameOfObject = nameOfObject;
	}

}

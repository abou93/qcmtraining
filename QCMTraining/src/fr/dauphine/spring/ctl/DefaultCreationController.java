/**
 * 
 */
package fr.dauphine.spring.ctl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import fr.dauphine.spring.bo.BO;

/**
 * @author Mathieu
 *
 */
public class DefaultCreationController<TypeObject extends BO> extends DefaultController implements Controller {
	protected Class<TypeObject> typeObjectClass;
	/**
	 * 
	 */
	public DefaultCreationController() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.Controller#handleRequest(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return constructSuccessViewWithNewInstance();
	}
	public ModelAndView constructSuccessViewWithNewInstance() throws InstantiationException, IllegalAccessException {
		ModelAndView mav = constructSuccessView();
		TypeObject obj = typeObjectClass.newInstance();
		mav.addObject(nameOfObject, obj);
		return mav;
	}

	/**
	 * @return the typeObjectClass
	 */
	public Class<TypeObject> getTypeObjectClass() {
		return typeObjectClass;
	}

	/**
	 * @param typeObjectClass the typeObjectClass to set
	 */
	public void setTypeObjectClass(Class<TypeObject> typeObjectClass) {
		this.typeObjectClass = typeObjectClass;
	}
	
}

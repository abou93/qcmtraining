/**
 * 
 */
package fr.dauphine.spring.ctl;

import org.springframework.web.servlet.ModelAndView;

import fr.dauphine.spring.bo.BO;

/**
 * @author Mathieu
 *
 */
abstract class DefaultController<TypeObject extends BO> {

	protected String nameOfView;
	protected String nameOfObject;
	protected Class<TypeObject> typeObjectClass;
	
	/**
	 * 
	 */
	public DefaultController() {
		// TODO Auto-generated constructor stub
	}
	public ModelAndView constructView() {
		ModelAndView mav = new ModelAndView(nameOfView);
		return mav;
	}
	public ModelAndView constructViewWithNewInstance() throws InstantiationException, IllegalAccessException {
		ModelAndView mav = constructView();
		TypeObject obj = typeObjectClass.newInstance();
		mav.addObject(nameOfObject, obj);
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

/**
 * 
 */
package fr.dauphine.spring.ctl;

import org.springframework.web.servlet.mvc.SimpleFormController;

import fr.dauphine.spring.bo.BO;
import fr.dauphine.spring.manager.AbstractManager;

/**
 * @author Mathieu
 *
 */
@SuppressWarnings("deprecation")
public class DefaultSimpleFormController<TypeObject extends BO> extends SimpleFormController {
	protected String nameOfView;
	protected String nameOfObject;
	protected AbstractManager<TypeObject> manager;
	/**
	 * 
	 */
	public DefaultSimpleFormController() {
		// TODO Auto-generated constructor stub
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

}

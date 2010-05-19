/**
 * 
 */
package fr.dauphine.spring.ctl;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import fr.dauphine.spring.bo.Sujet;
import fr.dauphine.spring.manager.SujetManager;

/**
 * @author Mathieu
 *
 */
@SuppressWarnings("deprecation")
public class ValidationSujetController extends SimpleFormController {

	SujetManager manager;
	/**
	 * 
	 */
	public ValidationSujetController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected ModelAndView onSubmit(
			Object command) throws Exception {

		Sujet sujet = (Sujet) command;
		System.out.println(">> Sujet : " + sujet.getTitre());
		
		manager.save(sujet);
		
		return super.onSubmit(command);
	}

	/**
	 * @return the manager
	 */
	public SujetManager getManager() {
		return manager;
	}

	/**
	 * @param manager the manager to set
	 */
	public void setManager(SujetManager manager) {
		this.manager = manager;
	}
	
}

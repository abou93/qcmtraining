/**
 * 
 */
package fr.dauphine.spring.ctl;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
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

	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
		binder.registerCustomEditor(Date.class, editor);
	}

	@Override
	protected ModelAndView onSubmit(Object command) throws Exception {

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
	 * @param manager
	 *            the manager to set
	 */
	public void setManager(SujetManager manager) {
		this.manager = manager;
	}

}

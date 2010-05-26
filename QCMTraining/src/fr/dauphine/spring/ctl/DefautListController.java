/**
 * 
 */
package fr.dauphine.spring.ctl;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;

import fr.dauphine.spring.bo.BO;
import fr.dauphine.spring.form.AbstractSearchForm;
import fr.dauphine.spring.manager.AbstractSearchManager;
import fr.dauphine.spring.util.Constants;

/**
 * @author Mathieu
 *
 */
public class DefautListController<TypeObject extends BO, TypeObjectForm extends AbstractSearchForm> extends DefaultSimpleFormController<TypeObject> {
	protected String nameOfList;
	protected Class<TypeObjectForm> typeObjectFormClass;
	/**
	 * 
	 */
	public DefautListController() {
		// TODO Auto-generated constructor stub
	}
	@Override
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
		binder.registerCustomEditor(Date.class, editor);
	}
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.AbstractController#handleRequestInternal(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView mav = super.handleRequest(request, response);
		if(secureAccess(request)) {
			if(mav.getModel().get(nameOfList) == null) {
				mav = getListView(null, request);
			}
		}
		return mav;
	}
	
	@SuppressWarnings("unchecked")
	private ModelAndView getListView(TypeObjectForm form, HttpServletRequest request) throws InstantiationException, IllegalAccessException {
		if(form == null) {
			form = typeObjectFormClass.newInstance();
		}
		ModelAndView mav = constructView();
		mav.addObject(nameOfObject, form);
		mav.addObject(nameOfList, ((AbstractSearchManager<TypeObject, TypeObjectForm>)manager).search(form));
		mav.addObject(Constants.PARAM_PAGE_CONTENT, nameOfPageContent);
		return mav;
	}
	

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.SimpleFormController#onSubmit(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.validation.BindException)
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		return getListView((TypeObjectForm) command, request);
	}


	/**
	 * @return the nameOfList
	 */
	public String getNameOfList() {
		return nameOfList;
	}

	/**
	 * @param nameOfList the nameOfList to set
	 */
	public void setNameOfList(String nameOfList) {
		this.nameOfList = nameOfList;
	}

	/**
	 * @return the typeObjectFormClass
	 */
	public Class<TypeObjectForm> getTypeObjectFormClass() {
		return typeObjectFormClass;
	}

	/**
	 * @param typeObjectFormClass the typeObjectFormClass to set
	 */
	public void setTypeObjectFormClass(Class<TypeObjectForm> typeObjectFormClass) {
		this.typeObjectFormClass = typeObjectFormClass;
	}
	
}

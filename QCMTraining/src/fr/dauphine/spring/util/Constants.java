/**
 * 
 */
package fr.dauphine.spring.util;

/**
 * @author Mathieu
 *
 */
public final class Constants {
	public static final String PARAM_USER_SESSION = "utilisateurSession";
	public static final short PARAM_DEFAULT_NUMBER_REPONSE = 4;
	public static final short PARAM_DEFAULT_NUMBER_QUESTION = 1;
	public static final String PARAM_DOMAIN_NAME = "domainName";
	public static final String PARAM_SUB_ACTION_NAME = "subAction";
	public static final String PARAM_SUB_ACTION_ADD_QUESTION = "addQuestion";
	public static final String PARAM_SUB_ACTION_REMOVE_QUESTION = "removeQuestion";
	public static final String PARAM_INDEX_QUESTION = "indexQuestion";
	
	public static final String PARAM_ISADMIN = "isAdmin";
	public static final String PARAM_ISLOGGED = "isLogged";
	public static final String PARAM_PAGE_CONTENT = "pageContent";
	
	public static final String PARAM_CONTENT_INDEX = "/jsp/general/index.jsp";
	public static final String PARAM_CONTENT_INDEXADMIN = "/jsp/content/indexAdmin.jsp";
	public static final String PARAM_CONTENT_INDEXUSER = "/jsp/content/indexUser.jsp";
	public static final String PARAM_CONTENT_CREERUSER = "/jsp/content/creerUser.jsp";
	public static final String PARAM_REQUEST_ID = "idObject";
	public static final String PARAM_NAME_PROPERTIES_FILE = "message";
	public static final String PARAM_NAME_LIST_ERRORS = "listErrors";
	public static final String PARAM_CONTENT_LISTEUSER = "/jsp/content/listeUser.jsp";
	
	public static final String PARAM_ACTIVEPAGE = "activePage";
	public static final int PARAM_ACTIVEPAGE_ACCUEIL = 1;
	public static final int PARAM_ACTIVEPAGE_ADMINISTRATION = 2;
	public static final int PARAM_ACTIVEPAGE_QCM = 3;
	public static final String PARAM_INDEX_VIEW = "index";
	
	public static final String ERROR_SUJET_NULL = "sujet.form.null";
	public static final String ERROR_SUJET_DATE_DEB = "sujet.form.date.deb.null";
	public static final String ERROR_SUJET_DATE_FIN = "sujet.form.date.fin.null";
	public static final String ERROR_SUJET_TITRE = "sujet.form.titre.null";
	public static final String ERROR_SUJET_NBQUESTIONDISPLAY_NULL = "sujet.form.nbquestiondisplay.null";
	public static final String ERROR_SUJET_NBQUESTIONDISPLAY_VALEUR = "sujet.form.nbquestiondisplay.valeur";
	public static final String ERROR_SUJET_QUESTION_LIBELLE = "sujet.form.question.libelle.null";
	public static final String ERROR_SUJET_QUESTION_REPONSE_LIBELLE = "sujet.form.question.reponse.libelle.null";
	public static final String ERROR_SUJET_DATE_DEB_AFTER_DATE_END = "sujet.form.date.deb.after.date.end";
}

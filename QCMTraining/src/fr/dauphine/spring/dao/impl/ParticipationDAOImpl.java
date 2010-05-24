/**
 * 
 */
package fr.dauphine.spring.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.PropertyValueException;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import fr.dauphine.spring.bo.Participation;
import fr.dauphine.spring.bo.Reponse;
import fr.dauphine.spring.bo.SujetInfo;
import fr.dauphine.spring.bo.Utilisateur;
import fr.dauphine.spring.dao.ParticipationDAO;

/**
 * @author Mathieu
 *
 */
public class ParticipationDAOImpl extends AbstractDAOImpl<Participation>
		implements ParticipationDAO {
	private static final String ID_USER_PROPERTY = "user.id";
	private static final String ID_SUJET_PROPERTY = "sujet.id";
	/* (non-Javadoc)
	 * @see fr.dauphine.spring.dao.impl.AbstractDAOImpl#getTemplateClass()
	 */
	@Override
	protected Class<Participation> getTemplateClass() {
		return Participation.class;
	}
	

	/* (non-Javadoc)
	 * @see fr.dauphine.spring.dao.impl.AbstractDAOImpl#save(java.lang.Object)
	 */
	@Override
	public Participation save(Participation entity) throws PropertyValueException{
		if (entity.getUser() != null && entity.getUser().getId() != null) {
			Utilisateur u = getHibernateTemplate().load(Utilisateur.class, entity.getUser().getId());
			entity.setUser(u);
		} else {
			throw new PropertyValueException("Erreur!", "Participation", "User");
		}
		if(entity.getSujet() != null && entity.getSujet().getId() != null) {
			SujetInfo suj = getHibernateTemplate().load(SujetInfo.class, entity.getSujet().getId());
			entity.setSujet(suj);
		} else {
			throw new PropertyValueException("Erreur!", "Participation", "Sujet");
		}
		List<Reponse> listFromBD = new ArrayList<Reponse> (0);
		for(Reponse rep : entity.getReponsesChoisies()) {
			if(rep != null && rep.getId() != null) {
				rep = getHibernateTemplate().load(Reponse.class, rep.getId());
				listFromBD.add(rep);
			}
		}
		entity.setReponsesChoisies(listFromBD);
		return super.save(entity);
	}


	@Override
	public Participation getParticipationByIdUserAndIdSujet(Long idUser, Long idSujet) {
		Criteria crit = getSession().createCriteria(Participation.class);
		crit.add(Restrictions.eq(ID_SUJET_PROPERTY, idSujet));
		crit.add(Restrictions.eq(ID_USER_PROPERTY, idUser));
		return (Participation) crit.uniqueResult();
	}


	@Override
	public boolean isParticiperAuSujet(Long idUser, Long idSujet) {
		Criteria crit = getSession().createCriteria(Participation.class);
		crit.setProjection(Projections.count("id"));
		crit.add(Restrictions.eq(ID_SUJET_PROPERTY, idSujet));
		crit.add(Restrictions.eq(ID_USER_PROPERTY, idUser));
		return ((Long)crit.uniqueResult()) > 0;
	}

}

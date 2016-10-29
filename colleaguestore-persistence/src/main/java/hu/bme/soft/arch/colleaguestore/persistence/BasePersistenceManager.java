package hu.bme.soft.arch.colleaguestore.persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class BasePersistenceManager {

	@PersistenceContext(unitName = "PU")
	private EntityManager em;

	protected EntityManager getEntityManager() {
		return em;
	}
}

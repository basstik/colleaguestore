package hu.bme.soft.arch.colleaguestore.persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public abstract class BasePersistenceManager<T> {

	@PersistenceContext(unitName = "PU")
	private EntityManager em;

	protected EntityManager getEntityManager() {
		return em;
	}

	public void persist(T entity) {
		getEntityManager().persist(entity);
	}

	public T find(Long id) {
		return getEntityManager().find(getEntityClass(), id);
	}

	public void remove(Long id) {
		getEntityManager().remove(id);
	}

	public abstract Class<T> getEntityClass();
}

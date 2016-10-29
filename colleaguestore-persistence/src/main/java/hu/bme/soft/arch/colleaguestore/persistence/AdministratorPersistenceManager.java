package hu.bme.soft.arch.colleaguestore.persistence;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import hu.bme.soft.arch.colleaguestore.persistence.entity.Administrator;

@Stateless
public class AdministratorPersistenceManager extends BasePersistenceManager {

	public List<Administrator> findAdministrators() {
		TypedQuery<Administrator> query = getEntityManager().createNamedQuery("Administrator.findAll",
				Administrator.class);
		List<Administrator> results = query.getResultList();
		return results;
	}
}

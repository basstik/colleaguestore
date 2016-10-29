package hu.bme.soft.arch.colleaguestore.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import hu.bme.soft.arch.colleaguestore.client.place.AdministratorDTO;
import hu.bme.soft.arch.colleaguestore.persistence.AdministratorPersistenceManager;
import hu.bme.soft.arch.colleaguestore.persistence.entity.Administrator;

@Stateless
public class AdministratorFacade {

	@Inject
	AdministratorPersistenceManager administratorPM;

	public List<AdministratorDTO> getAuthors() {
		List<AdministratorDTO> administratorDto = new ArrayList<>();
		List<Administrator> administrarotEntities = administratorPM.findAdministrators();

		for (Administrator administrator : administrarotEntities) {
			administratorDto.add(new AdministratorDTO(administrator.getId(), administrator.getFirstName(),
					administrator.getLastName()));
		}

		return administratorDto;
	}
}

package hu.bme.soft.arch.colleaguestore.facade;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import hu.bme.soft.arch.colleaguestore.domain.dto.AdministratorDTO;
import hu.bme.soft.arch.colleaguestore.domain.dto.AdministratorFilterDTO;
import hu.bme.soft.arch.colleaguestore.domain.dto.PagingAdministratorDTO;
import hu.bme.soft.arch.colleaguestore.persistence.AdministratorPersistenceManager;
import hu.bme.soft.arch.colleaguestore.persistence.entity.Administrator;

@Stateless
public class AdministratorFacade {

	@Inject
	AdministratorPersistenceManager administratorPM;

	public PagingAdministratorDTO getAdministrators(AdministratorFilterDTO authorFilterDTO) {
		List<AdministratorDTO> administratorDto = new ArrayList<>();
		List<Administrator> administrarotEntities = administratorPM.findAdministrators();

		for (Administrator administrator : administrarotEntities) {
			administratorDto.add(new AdministratorDTO(administrator.getId(), administrator.getFirstName(),
					administrator.getLastName()));
		}

		return new PagingAdministratorDTO(administratorDto, authorFilterDTO.getOffset(), authorFilterDTO.getLimit());
	}
}

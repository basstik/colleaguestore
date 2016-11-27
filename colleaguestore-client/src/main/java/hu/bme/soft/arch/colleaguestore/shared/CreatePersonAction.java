package hu.bme.soft.arch.colleaguestore.shared;

import com.gwtplatform.dispatch.rpc.shared.UnsecuredActionImpl;

import hu.bme.soft.arch.colleaguestore.domain.dto.PersonDTO;

public class CreatePersonAction extends UnsecuredActionImpl<CreatePersonResult> {

	private PersonDTO personDto;

	/**
	 * For serialization only.
	 */
	@SuppressWarnings("unused")
	private CreatePersonAction() {
	}

	public CreatePersonAction(PersonDTO personDto) {
		this.personDto = personDto;
	}

	public PersonDTO getPesronDto() {
		return personDto;
	}

}

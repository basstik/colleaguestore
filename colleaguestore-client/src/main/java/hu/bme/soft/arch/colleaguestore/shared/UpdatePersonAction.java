package hu.bme.soft.arch.colleaguestore.shared;

import com.gwtplatform.dispatch.rpc.shared.UnsecuredActionImpl;

import hu.bme.soft.arch.colleaguestore.domain.dto.PersonDTO;

public class UpdatePersonAction extends UnsecuredActionImpl<UpdatePersonResult> {

	private PersonDTO personDto;

	/**
	 * For serialization only.
	 */
	@SuppressWarnings("unused")
	private UpdatePersonAction() {
	}

	public UpdatePersonAction(PersonDTO personDto) {
		this.personDto = personDto;
	}

	public PersonDTO getPersonDto() {
		return personDto;
	}

}

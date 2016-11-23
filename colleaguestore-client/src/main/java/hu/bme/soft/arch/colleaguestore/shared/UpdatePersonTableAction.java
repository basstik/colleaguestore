package hu.bme.soft.arch.colleaguestore.shared;

import com.gwtplatform.dispatch.rpc.shared.UnsecuredActionImpl;

import hu.bme.soft.arch.colleaguestore.domain.dto.PersonFilterDTO;

public class UpdatePersonTableAction extends UnsecuredActionImpl<UpdatePersonTableResult> {

	private PersonFilterDTO personFilterDTO;

	@SuppressWarnings("unused")
	private UpdatePersonTableAction() {
	}

	public UpdatePersonTableAction(PersonFilterDTO personFilterDTO) {
		this.personFilterDTO = personFilterDTO;
	}

	public PersonFilterDTO getPersonFilterDTO() {
		return personFilterDTO;
	}

}

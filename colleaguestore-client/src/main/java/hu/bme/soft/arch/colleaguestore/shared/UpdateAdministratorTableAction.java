package hu.bme.soft.arch.colleaguestore.shared;

import com.gwtplatform.dispatch.rpc.shared.UnsecuredActionImpl;

import hu.bme.soft.arch.colleaguestore.domain.dto.AdministratorFilterDTO;

public class UpdateAdministratorTableAction extends UnsecuredActionImpl<UpdateAdministratorTableResult> {

	private AdministratorFilterDTO administratorFilterDTO;

	@SuppressWarnings("unused")
	private UpdateAdministratorTableAction() {
	}

	public UpdateAdministratorTableAction(AdministratorFilterDTO administratorFilterDTO) {
		this.administratorFilterDTO = administratorFilterDTO;
	}

	public AdministratorFilterDTO getAuthorFilterDTO() {
		return administratorFilterDTO;
	}
}

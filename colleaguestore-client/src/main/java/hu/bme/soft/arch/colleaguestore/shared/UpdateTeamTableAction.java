package hu.bme.soft.arch.colleaguestore.shared;

import com.gwtplatform.dispatch.rpc.shared.UnsecuredActionImpl;

import hu.bme.soft.arch.colleaguestore.domain.dto.PersonFilterDTO;
import hu.bme.soft.arch.colleaguestore.domain.dto.TeamFilterDTO;

public class UpdateTeamTableAction extends UnsecuredActionImpl<UpdateTeamTableResult> {

	private TeamFilterDTO teamFilterDTO;

	@SuppressWarnings("unused")
	private UpdateTeamTableAction() {
	}

	public UpdateTeamTableAction(TeamFilterDTO teamFilterDTO) {
		this.teamFilterDTO = teamFilterDTO;
	}

	public TeamFilterDTO getTeamFilterDTO() {
		return teamFilterDTO;
	}

}

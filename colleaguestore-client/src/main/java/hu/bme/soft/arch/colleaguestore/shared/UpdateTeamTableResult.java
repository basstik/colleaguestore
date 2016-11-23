package hu.bme.soft.arch.colleaguestore.shared;

import java.util.List;

import com.gwtplatform.dispatch.rpc.shared.Result;

import hu.bme.soft.arch.colleaguestore.domain.dto.PagingPersonDTO;
import hu.bme.soft.arch.colleaguestore.domain.dto.PagingTeamDTO;
import hu.bme.soft.arch.colleaguestore.domain.dto.TeamDTO;

public class UpdateTeamTableResult implements Result {

	private PagingTeamDTO teamDto;

	@SuppressWarnings("unused")
	private UpdateTeamTableResult() {
	}

	public UpdateTeamTableResult(PagingTeamDTO pagingTeamDDT) {
		this.teamDto = pagingTeamDDT;
	}

	public PagingTeamDTO getPagingTeamDTO() {
		return teamDto;
	}
}

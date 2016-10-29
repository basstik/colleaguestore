package hu.bme.soft.arch.colleaguestore.shared;

import com.gwtplatform.dispatch.rpc.shared.Result;

import hu.bme.soft.arch.colleaguestore.domain.dto.PagingAdministratorDTO;

public class UpdateAdministratorTableResult implements Result {

	private PagingAdministratorDTO pagingAdministratorDto;

	@SuppressWarnings("unused")
	private UpdateAdministratorTableResult() {
	}

	public UpdateAdministratorTableResult(PagingAdministratorDTO pagingAdministratorDDT) {
		this.pagingAdministratorDto = pagingAdministratorDDT;
	}

	public PagingAdministratorDTO getPagingAdministratorDTO() {
		return pagingAdministratorDto;
	}
}

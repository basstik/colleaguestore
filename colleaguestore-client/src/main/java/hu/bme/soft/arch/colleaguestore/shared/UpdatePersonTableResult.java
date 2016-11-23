package hu.bme.soft.arch.colleaguestore.shared;

import com.gwtplatform.dispatch.rpc.shared.Result;

import hu.bme.soft.arch.colleaguestore.domain.dto.PagingPersonDTO;

public class UpdatePersonTableResult implements Result {

	private PagingPersonDTO pagingPersonDto;

	@SuppressWarnings("unused")
	private UpdatePersonTableResult() {
	}

	public UpdatePersonTableResult(PagingPersonDTO pagingPersonDDT) {
		this.pagingPersonDto = pagingPersonDDT;
	}

	public PagingPersonDTO getPagingPersonDTO() {
		return pagingPersonDto;
	}
}

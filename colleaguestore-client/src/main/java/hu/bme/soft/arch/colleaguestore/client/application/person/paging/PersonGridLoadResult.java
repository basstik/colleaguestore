package hu.bme.soft.arch.colleaguestore.client.application.person.paging;

import java.util.List;

import com.sencha.gxt.data.shared.loader.PagingLoadResult;

import hu.bme.soft.arch.colleaguestore.domain.dto.PagingPersonDTO;
import hu.bme.soft.arch.colleaguestore.domain.dto.PersonDTO;

public class PersonGridLoadResult implements PagingLoadResult<PersonDTO> {

	private PagingPersonDTO pagingPersonDTO;

	public PersonGridLoadResult(PagingPersonDTO pagingPersonDTO) {
		this.pagingPersonDTO = pagingPersonDTO;
	}

	@Override
	public List<PersonDTO> getData() {
		return pagingPersonDTO.getData();
	}

	@Override
	public int getOffset() {
		return pagingPersonDTO.getOffset();
	}

	@Override
	public int getTotalLength() {
		return pagingPersonDTO.getTotalLength();
	}

	@Override
	public void setOffset(int offset) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setTotalLength(int totalLength) {
		throw new UnsupportedOperationException();
	}

}

package hu.bme.soft.arch.colleaguestore.domain.dto;

import java.io.Serializable;

public class AdministratorFilterDTO implements Serializable {

	private int offset;

	private int limit;

	@SuppressWarnings("unused")
	private AdministratorFilterDTO() {
	}

	public AdministratorFilterDTO(Integer offset, Integer limit) {
		this.offset = offset;
		this.limit = limit;
	}

	public int getOffset() {
		return offset;
	}

	public int getLimit() {
		return limit;
	}
}

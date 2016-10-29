package hu.bme.soft.arch.colleaguestore.domain.dto;

import java.io.Serializable;
import java.util.List;

public class PagingAdministratorDTO implements Serializable {

	private List<AdministratorDTO> data;

	private int totalLength;

	private int offset;

	@SuppressWarnings("unused")
	private PagingAdministratorDTO() {
	}

	public PagingAdministratorDTO(List<AdministratorDTO> data, int totalLength, int offset) {
		this.data = data;
		this.totalLength = totalLength;
		this.offset = offset;
	}

	public List<AdministratorDTO> getData() {
		return data;
	}

	public int getTotalLength() {
		return totalLength;
	}

	public int getOffset() {
		return offset;
	}
}

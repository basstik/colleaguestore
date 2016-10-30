package hu.bme.soft.arch.colleaguestore.domain.dto;

import java.io.Serializable;
import java.util.ArrayList;

public class AdministratorDTO extends ArrayList<AdministratorDTO> implements Serializable {

	private Long id;

	private String firstName;

	private String lastName;

	public AdministratorDTO() {
	}

	public AdministratorDTO(Long id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}

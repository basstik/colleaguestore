package hu.bme.soft.arch.colleaguestore.client.application.person.model;

import java.util.Date;

import com.google.gwt.editor.client.Editor.Path;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

import hu.bme.soft.arch.colleaguestore.domain.dto.PersonDTO;

public interface PersonProperties extends PropertyAccess<PersonDTO> {

	@Path("id")
	ModelKeyProvider<PersonDTO> key();

	ValueProvider<PersonDTO, String> firstName();

	ValueProvider<PersonDTO, String> lastName();

	ValueProvider<PersonDTO, String> nationality();

	ValueProvider<PersonDTO, Date> dateOfBirth();

}

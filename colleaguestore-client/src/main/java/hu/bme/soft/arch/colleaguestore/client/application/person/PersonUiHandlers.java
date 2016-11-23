package hu.bme.soft.arch.colleaguestore.client.application.person;

import com.google.gwt.core.client.Callback;
import com.gwtplatform.mvp.client.UiHandlers;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;

import hu.bme.soft.arch.colleaguestore.domain.dto.PersonDTO;
import hu.bme.soft.arch.colleaguestore.domain.dto.PersonFilterDTO;

public interface PersonUiHandlers extends UiHandlers {

	void loadPersons(PersonFilterDTO personFilterDTO, Callback<PagingLoadResult<PersonDTO>, Throwable> callback);

	void deletePerson(Long id);

	void showEditPersonPopup(PersonDTO person);

	void showAddPersonPopup();

}

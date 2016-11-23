package hu.bme.soft.arch.colleaguestore.client.application.person.popup;

import com.gwtplatform.mvp.client.UiHandlers;

import hu.bme.soft.arch.colleaguestore.domain.dto.PersonDTO;

interface PersonPopupUiHandlers extends UiHandlers {

	void createPerson(PersonDTO person);

	void updatePerson(PersonDTO person);

	void closeWindow();
}
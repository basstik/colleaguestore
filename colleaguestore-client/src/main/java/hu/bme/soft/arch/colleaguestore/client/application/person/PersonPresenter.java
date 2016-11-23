package hu.bme.soft.arch.colleaguestore.client.application.person;

import com.google.gwt.core.client.Callback;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rpc.shared.DispatchAsync;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;

import hu.bme.soft.arch.colleaguestore.client.application.ApplicationPresenter;
import hu.bme.soft.arch.colleaguestore.client.application.person.paging.PersonGridLoadResult;
import hu.bme.soft.arch.colleaguestore.client.application.person.popup.PersonPopupPresenter;
import hu.bme.soft.arch.colleaguestore.client.place.NameTokens;
import hu.bme.soft.arch.colleaguestore.domain.dto.PersonDTO;
import hu.bme.soft.arch.colleaguestore.domain.dto.PersonFilterDTO;
import hu.bme.soft.arch.colleaguestore.shared.DeletePersonAction;
import hu.bme.soft.arch.colleaguestore.shared.DeletePersonResult;
import hu.bme.soft.arch.colleaguestore.shared.UpdatePersonTableAction;
import hu.bme.soft.arch.colleaguestore.shared.UpdatePersonTableResult;

public class PersonPresenter extends Presenter<PersonPresenter.MyView, PersonPresenter.MyProxy>
		implements PersonUiHandlers {

	interface MyView extends View, HasUiHandlers<PersonUiHandlers> {
		void showErrormessage(String errorMessage);

		void loadPersonTable();

		void disableEditableButtons();

	}

	@ProxyStandard
	@NameToken(NameTokens.PERSON)
	interface MyProxy extends ProxyPlace<PersonPresenter> {
	}

	private final PersonPopupPresenter personPopup;

	private DispatchAsync dispatcher;

	@Inject
	PersonPresenter(EventBus eventBus, MyView view, DispatchAsync dispatcher, MyProxy proxy,
			PersonPopupPresenter personPopup) {
		super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);
		getView().setUiHandlers(this);
		this.personPopup = personPopup;
		this.dispatcher = dispatcher;
	}

	@Override
	public void prepareFromRequest(PlaceRequest request) {
		getView().loadPersonTable();
		super.prepareFromRequest(request);
	}

	@Override
	public void loadPersons(PersonFilterDTO personFilterDTO,
			final Callback<PagingLoadResult<PersonDTO>, Throwable> callback) {
		// logger.info("Person tábla frissítése.");
		dispatcher.execute(new UpdatePersonTableAction(personFilterDTO), new AsyncCallback<UpdatePersonTableResult>() {

			@Override
			public void onFailure(Throwable caught) {
				callback.onFailure(caught);
				// logger.info(caught.getMessage());
				getView().showErrormessage("With server communication.");
			}

			@Override
			public void onSuccess(UpdatePersonTableResult result) {
				// logger.info("Author tábla adatai sikeresen megérkeztek.");
				callback.onSuccess(new PersonGridLoadResult(result.getPagingPersonDTO()));
			}
		});
	}

	@Override
	public void showAddPersonPopup() {
		// logger.fine("AddPersonPopup a popupslot-ba helyezése.");
		addToPopupSlot(personPopup);
		personPopup.setModeAddPerson();
	}

	@Override
	public void showEditPersonPopup(PersonDTO person) {
		// logger.fine("EditPersonPopup a popupslot-ba helyezése.");
		addToPopupSlot(personPopup);
		personPopup.setModeUpdatePerson(person);
	}

	@Override
	public void deletePerson(Long personId) {
		// logger.fine("Törlendő Actor id elküldése a szervernek." + " Id
		// értéke: " + personId);
		DeletePersonAction action = new DeletePersonAction(personId);
		dispatcher.execute(action, new AsyncCallback<DeletePersonResult>() {

			@Override
			public void onSuccess(DeletePersonResult result) {
				// logger.fine("Person törlölve.");
				getView().loadPersonTable();
			}

			@Override
			public void onFailure(Throwable caught) {
				getView().showErrormessage("During person delete. " + caught.getMessage());
			}
		});
	}

}
package hu.bme.soft.arch.colleaguestore.client.application.person.popup;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rpc.shared.DispatchAsync;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.PopupView;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;

import hu.bme.soft.arch.colleaguestore.client.place.NameTokens;
import hu.bme.soft.arch.colleaguestore.domain.dto.PersonDTO;
import hu.bme.soft.arch.colleaguestore.shared.CreatePersonAction;
import hu.bme.soft.arch.colleaguestore.shared.CreatePersonResult;
import hu.bme.soft.arch.colleaguestore.shared.UpdatePersonAction;
import hu.bme.soft.arch.colleaguestore.shared.UpdatePersonResult;

public class PersonPopupPresenter extends PresenterWidget<PersonPopupPresenter.MyView>
		implements PersonPopupUiHandlers {

	interface MyView extends PopupView, HasUiHandlers<PersonPopupUiHandlers> {

		void resetView();

		void showErrormessage(String errorInAction);

		void editPersonDto(PersonDTO person);

		void setModeUpdatePerson(PersonDTO person);

		void setModeAddAgent();
	}

	// private Logger logger;

	private DispatchAsync dispatcher;

	private PlaceManager placeManager;

	@Inject
	// PersonPopupPresenter(EventBus eventBus, MyView view, Logger logger,
	// PlaceManager placeManager,
	PersonPopupPresenter(EventBus eventBus, MyView view, PlaceManager placeManager, DispatchAsync dispatcher) {
		super(eventBus, view);
		// this.logger = logger;
		this.placeManager = placeManager;
		this.dispatcher = dispatcher;
		getView().setUiHandlers(this);
		getView().editPersonDto(new PersonDTO());
		// logger.fine("PersonPopupPresenter létrehozva.");
	}

	public void setModeAddPerson() {
		getView().setModeAddAgent();
	}

	public void setModeUpdatePerson(PersonDTO person) {
		getView().setModeUpdatePerson(person);
	}

	@Override
	public void createPerson(PersonDTO person) {
		// logger.fine("Új Actor adatok elküldése a szervernek.");
		CreatePersonAction action = new CreatePersonAction(person);
		dispatcher.execute(action, new AsyncCallback<CreatePersonResult>() {

			@Override
			public void onSuccess(CreatePersonResult result) {
				// logger.fine("Person sikeresen felvéve");
				getView().hide();
			}

			@Override
			public void onFailure(Throwable arg0) {
				// logger.fine("Person felvétele közben hiba jött a
				// szervertől.");
				getView().showErrormessage("During new actor process");
			}
		});
	}

	@Override
	public void updatePerson(PersonDTO person) {
		// logger.fine("Módosított Actor adatok elküldése a szervernek.");
		UpdatePersonAction action = new UpdatePersonAction(person);
		dispatcher.execute(action, new AsyncCallback<UpdatePersonResult>() {

			@Override
			public void onSuccess(UpdatePersonResult arg0) {
				getView().hide();
			}

			@Override
			public void onFailure(Throwable arg0) {
				getView().showErrormessage("During new actor process.");
			}
		});
	}

	@Override
	public void closeWindow() {
		PlaceRequest closePlaceRequest = new PlaceRequest.Builder().nameToken(NameTokens.PERSON).build();
		placeManager.revealPlace(closePlaceRequest);
		// logger.info("Person frissítés kérés elküldve.");
	}
}
package hu.bme.soft.arch.colleaguestore.client.application.person.popup;

import javax.inject.Inject;

import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.event.shared.EventBus;
import com.sencha.gxt.widget.core.client.Window;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.event.HideEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.form.DateField;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.form.validator.RegExValidator;
import com.sencha.gxt.widget.core.client.info.Info;

import hu.bme.soft.arch.colleaguestore.client.application.common.GXTPopupViewWithUiHandlers;
import hu.bme.soft.arch.colleaguestore.domain.dto.PersonDTO;

class PersonPopupView extends GXTPopupViewWithUiHandlers<PersonPopupUiHandlers>
		implements PersonPopupPresenter.MyView, Editor<PersonDTO> {

	interface Binder extends UiBinder<Widget, PersonPopupView> {
	}

	interface Driver extends SimpleBeanEditorDriver<PersonDTO, PersonPopupView> {
	}

	// private Logger logger;

	private final Driver driver;

	@UiField
	Window window;

	@UiField
	TextField firstName;

	@UiField
	TextField lastName;

	@UiField
	TextField nationality;

	@UiField
	DateField dateOfBirth;

	@Ignore
	@UiField
	TextButton addButton;

	@Ignore
	@UiField
	TextButton modifyButton;

	@Ignore
	@UiField
	TextButton closeButton;

	@Inject
	PersonPopupView(Binder uiBinder, EventBus eventBus, Driver driver) {
		super(eventBus);
		// this.logger = logger;
		this.driver = driver;
		initWidget(uiBinder.createAndBindUi(this));
		this.driver.initialize(this);
		firstName.addValidator(new RegExValidator("^[a-zA-Z]{3,50}$"));
		lastName.addValidator(new RegExValidator("^[a-zA-Z]{3,50}$"));
		nationality.addValidator(new RegExValidator("^[A-z]{3,50}$"));
		dateOfBirth.setClearValueOnParseError(false);
		dateOfBirth.setAllowBlank(true);
		// logger.fine("PersonPopupView létrehozva");
	}

	@UiHandler({ "closeButton" })
	public void closeWindow(SelectEvent event) {
		// logger.fine("Bezárás gombra katintása az PersonPopup-on.");
		window.hide();
	}

	@UiHandler({ "addButton" })
	public void onAddButtonSelect(SelectEvent event) {
		// logger.fine("Hozzáadás gombra katintása az PersonPopup-on.");
		if (firstName.isValid() && lastName.isValid() && nationality.isValid()
				&& (dateOfBirth.getValue() == null || dateOfBirth.validate())) {
			PersonDTO person = driver.flush();
			getUiHandlers().createPerson(person);
		}
	}

	@UiHandler({ "modifyButton" })
	public void onModifyButtonSelect(SelectEvent event) {
		// logger.fine("Módosítás gombra katintása az PersonPopup-on.");
		if (firstName.isValid() && lastName.isValid() && nationality.isValid()
				&& (dateOfBirth.getValue() == null || dateOfBirth.validate())) {
			PersonDTO person = driver.flush();
			getUiHandlers().updatePerson(person);
		}
	}

	@UiHandler({ "window" })
	public void onWindowClose(HideEvent event) {
		// logger.info("PersonPopupView onWindowClose.");
		getUiHandlers().closeWindow();
	}

	@Override
	public void resetView() {
		clearErrors();
		lastName.clear();
		firstName.clear();
		nationality.clear();
		dateOfBirth.clear();
	}

	private void clearErrors() {
		lastName.clearInvalid();
		firstName.clearInvalid();
		nationality.clearInvalid();
		dateOfBirth.clearInvalid();
	}

	@Override
	public void showErrormessage(String errorInAction) {
		Info.display("Error", "Error occur: " + errorInAction);
	}

	@Override
	public void setModeUpdatePerson(PersonDTO person) {
		resetView();
		window.setHeading("Edit person");
		addButton.setVisible(false);
		modifyButton.setVisible(true);
		editPersonDto(person);
	}

	@Override
	public void setModeAddAgent() {
		resetView();
		window.setHeading("New person");
		addButton.setVisible(true);
		modifyButton.setVisible(false);
	}

	@Override
	public void editPersonDto(PersonDTO person) {
		driver.edit(person);
	}
}
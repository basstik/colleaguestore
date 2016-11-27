package hu.bme.soft.arch.colleaguestore.client.application.person;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gwt.cell.client.DateCell;
import com.google.gwt.core.client.Callback;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.DateTimeFormat.PredefinedFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.loader.DataProxy;
import com.sencha.gxt.data.shared.loader.LoadResultListStoreBinding;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;
import com.sencha.gxt.data.shared.loader.PagingLoader;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.info.Info;
import com.sencha.gxt.widget.core.client.toolbar.PagingToolBar;

import hu.bme.soft.arch.colleaguestore.client.application.common.RemoveDialog;
import hu.bme.soft.arch.colleaguestore.client.application.person.model.PersonProperties;
import hu.bme.soft.arch.colleaguestore.domain.dto.PersonDTO;
import hu.bme.soft.arch.colleaguestore.domain.dto.PersonFilterDTO;
import hu.bme.soft.arch.colleaguestore.domain.enumeration.Position;

class PersonView extends ViewWithUiHandlers<PersonUiHandlers> implements PersonPresenter.MyView {
	interface Binder extends UiBinder<Widget, PersonView> {
	}

	@UiField(provided = true)
	ColumnModel<PersonDTO> cm;

	@UiField(provided = true)
	ListStore<PersonDTO> store;

	@UiField(provided = true)
	PagingLoader<PagingLoadConfig, PagingLoadResult<PersonDTO>> loader;

	@UiField
	Grid<PersonDTO> grid;

	@UiField
	PagingToolBar toolBar;

	@UiField
	TextButton addPersonBtn;

	@UiField
	TextButton editPersonBtn;

	@UiField
	TextButton deletePersonBtn;

	@Inject
	PersonView(Binder uiBinder, PersonProperties props) {
		ColumnConfig<PersonDTO, String> firstNameCol = new ColumnConfig<>(props.firstName(), 150, "Firstname");
		ColumnConfig<PersonDTO, String> lastNameCol = new ColumnConfig<>(props.lastName(), 150, "Lastname");
		ColumnConfig<PersonDTO, String> nationalityCol = new ColumnConfig<>(props.nationality(), 110, "Nationality");
		ColumnConfig<PersonDTO, Date> dateOfBirthCol = new ColumnConfig<>(props.dateOfBirth(), 150, "Date of birth");
		ColumnConfig<PersonDTO, String> positionCol = new ColumnConfig<>(createPositionValueProvider(), 150,
				"Position");

		firstNameCol.setHorizontalHeaderAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		lastNameCol.setHorizontalHeaderAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		nationalityCol.setHorizontalHeaderAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		dateOfBirthCol.setHorizontalHeaderAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		dateOfBirthCol.setCell(new DateCell(DateTimeFormat.getFormat(PredefinedFormat.DATE_SHORT)));

		List<ColumnConfig<PersonDTO, ?>> columns = new ArrayList<>();
		columns.add(firstNameCol);
		columns.add(lastNameCol);
		columns.add(nationalityCol);
		columns.add(dateOfBirthCol);
		columns.add(positionCol);

		cm = new ColumnModel<>(columns);
		store = new ListStore<>(props.key());
		loader = createPersonGridPagingLoader();
		initWidget(uiBinder.createAndBindUi(this));
		toolBar.bind(loader);

		grid.setBorders(false);
		grid.getView().setStripeRows(true);
		grid.getView().setColumnLines(true);

	}

	private ValueProvider<PersonDTO, String> createPositionValueProvider() {
		return new ValueProvider<PersonDTO, String>() {

			@Override
			public String getValue(PersonDTO object) {
				return object.getPosition().toString();
			}

			@Override
			public void setValue(PersonDTO object, String value) {
				object.setPosition(Position.ADMINISTRATOR);
			}

			@Override
			public String getPath() {
				return "position";
			}

		};
	}

	private PagingLoader<PagingLoadConfig, PagingLoadResult<PersonDTO>> createPersonGridPagingLoader() {
		PagingLoader<PagingLoadConfig, PagingLoadResult<PersonDTO>> loader = new PagingLoader<>(
				new DataProxy<PagingLoadConfig, PagingLoadResult<PersonDTO>>() {

					@Override
					public void load(PagingLoadConfig loadConfig,
							Callback<PagingLoadResult<PersonDTO>, Throwable> callback) {
						getUiHandlers().loadPersons(new PersonFilterDTO(loadConfig.getOffset(), loadConfig.getLimit()),
								callback);
					}
				});

		loader.addLoadHandler(
				new LoadResultListStoreBinding<PagingLoadConfig, PersonDTO, PagingLoadResult<PersonDTO>>(store));
		return loader;
	}

	@UiHandler("addPersonBtn")
	public void onAddPersonBtnSelected(SelectEvent event) {
		// logger.fine("Person hozzáadása gombra kattintás.");
		getUiHandlers().showAddPersonPopup();
	}

	@UiHandler("editPersonBtn")
	public void onEditPersonBtnSelected(SelectEvent event) {
		// logger.fine("Person szerkesztés gombra kattintás.");
		PersonDTO person = grid.getSelectionModel().getSelectedItem();
		if (person != null) {
			getUiHandlers().showEditPersonPopup(person);
		} else {
			Info.display("Warning", "Select one person!");
		}
	}

	@UiHandler("deletePersonBtn")
	public void onDeletePersonBtnSelected(SelectEvent event) {
		// logger.fine("Person törlés gombra kattintás.");
		final PersonDTO person = grid.getSelectionModel().getSelectedItem();
		if (person != null) {
			RemoveDialog mb = new RemoveDialog("Are you sure you want remove this person?") {

				@Override
				protected void onRemove() {
					getUiHandlers().deletePerson(person.getId());
				}
			};
			mb.show();
		} else {
			Info.display("Warning", "Select one person!");
		}
	}

	@Override
	public void loadPersonTable() {
		loader.load();
	}

	@Override
	public void disableEditableButtons() {
		addPersonBtn.disable();
		editPersonBtn.disable();
		deletePersonBtn.disable();
	}

	@Override
	public void showErrormessage(String errorInAction) {
		Info.display("Error", "Error occur: " + errorInAction);
	}
}
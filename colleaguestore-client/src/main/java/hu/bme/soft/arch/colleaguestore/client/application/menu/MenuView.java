package hu.bme.soft.arch.colleaguestore.client.application.menu;

import java.util.logging.Logger;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.info.Info;

import hu.bme.soft.arch.colleaguestore.client.place.NameTokens;

class MenuView extends ViewWithUiHandlers<MenuUiHandlers> implements MenuPresenter.MyView {
    interface Binder extends UiBinder<Widget, MenuView> {
    }

    @UiField
    TextButton personNavigationButton;

    @UiField
    TextButton teamNavigationButton;
    
//    private Logger logger;

    @Inject
    MenuView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
//        this.logger = logger;
    }
    @UiHandler("personNavigationButton")
    public void onPersonButtonClick(SelectEvent event) {
        getUiHandlers().goToPage(NameTokens.PERSON);
    }

    @UiHandler("teamNavigationButton")
    public void onTeamButtonClick(SelectEvent event) {
        getUiHandlers().goToPage(NameTokens.TEAM);
    }

    @Override
    public void showErrormessage(String errorInAction) {
        Info.display("Error", "Error occur: " + errorInAction);
    }
}
package hu.bme.soft.arch.colleaguestore.client.application.menu;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rpc.shared.DispatchAsync;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.PresenterWidget;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;

public class MenuPresenter extends PresenterWidget<MenuPresenter.MyView> implements MenuUiHandlers {
   
	interface MyView extends View , HasUiHandlers<MenuUiHandlers> {
    	 void showErrormessage(String errorInAction);
    }
    	
    @Inject
    private PlaceManager placeManager;

    private DispatchAsync dispatcher;

//    private Logger logger;

    @Inject
    MenuPresenter(
            EventBus eventBus,
            MyView view,
//            Logger logger,
            DispatchAsync dispatcher) {
        super(eventBus, view);
//        this.logger = logger;
        this.dispatcher = dispatcher;
        getView().setUiHandlers(this);
//        logger.fine("MenuPresenter létrehozva.");
    }
    
    @Override
    public void goToPage(String nameToken) {
        PlaceRequest placeRequest = new PlaceRequest.Builder()
                .nameToken(nameToken)
                .build();
        placeManager.revealPlace(placeRequest);
    }
    
}
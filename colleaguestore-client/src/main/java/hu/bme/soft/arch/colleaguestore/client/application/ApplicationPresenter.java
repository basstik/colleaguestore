package hu.bme.soft.arch.colleaguestore.client.application;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.presenter.slots.NestedSlot;
import com.gwtplatform.mvp.client.presenter.slots.SingleSlot;
import com.gwtplatform.mvp.client.proxy.Proxy;

import hu.bme.soft.arch.colleaguestore.client.application.menu.MenuPresenter;

public class ApplicationPresenter extends Presenter<ApplicationPresenter.MyView, ApplicationPresenter.MyProxy> {
	interface MyView extends View {
	}

	   public static final NestedSlot SLOT_CONTENT = new NestedSlot();

	    public static final SingleSlot<MenuPresenter> SLOT_MENU = new SingleSlot<>();
	    
	@ProxyStandard
	interface MyProxy extends Proxy<ApplicationPresenter> {
	}
	
    @Inject
    private MenuPresenter menuPresenter;

	@Inject
	ApplicationPresenter(EventBus eventBus, MyView view, MyProxy proxy) {
		super(eventBus, view, proxy, RevealType.Root);
	}
	
    @Override
    protected void onBind() {
        super.onBind();
        setInSlot(SLOT_MENU, menuPresenter);
    }
}
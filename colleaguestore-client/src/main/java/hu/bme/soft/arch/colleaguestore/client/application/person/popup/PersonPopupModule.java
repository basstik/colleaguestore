package hu.bme.soft.arch.colleaguestore.client.application.person.popup;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class PersonPopupModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
            bindPresenterWidget(PersonPopupPresenter.class, PersonPopupPresenter.MyView.class, PersonPopupView.class);
    }
}
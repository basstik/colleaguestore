package hu.bme.soft.arch.colleaguestore.client.application.person;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

import hu.bme.soft.arch.colleaguestore.client.application.person.popup.PersonPopupModule;

public class PersonModule extends AbstractPresenterModule {
	@Override
	protected void configure() {
		install(new PersonPopupModule());
		bindPresenter(PersonPresenter.class, PersonPresenter.MyView.class, PersonView.class,
				PersonPresenter.MyProxy.class);
	}
}
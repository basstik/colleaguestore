package hu.bme.soft.arch.colleaguestore.client.application;

import hu.bme.soft.arch.colleaguestore.client.application.menu.MenuModule;
import hu.bme.soft.arch.colleaguestore.client.application.person.PersonModule;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class ApplicationModule extends AbstractPresenterModule {
	@Override
	protected void configure() {
		install(new MenuModule());
		install(new PersonModule());

		bindPresenter(ApplicationPresenter.class, ApplicationPresenter.MyView.class, ApplicationView.class,
				ApplicationPresenter.MyProxy.class);
	}
}
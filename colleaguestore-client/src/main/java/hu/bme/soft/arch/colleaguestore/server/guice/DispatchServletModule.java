package hu.bme.soft.arch.colleaguestore.server.guice;

import com.google.inject.Provides;
import com.google.inject.servlet.ServletModule;
import com.gwtplatform.dispatch.rpc.server.guice.DispatchServiceImpl;
import com.gwtplatform.dispatch.rpc.shared.ActionImpl;

import hu.bme.soft.arch.colleaguestore.facade.AdministratorFacade;

public class DispatchServletModule extends ServletModule {

	private final AdministratorFacade administratorFacade;

	public DispatchServletModule(AdministratorFacade administratorFacade) {
		this.administratorFacade = administratorFacade;
	}

	@Override
	public void configureServlets() {
		serve("/" + ActionImpl.DEFAULT_SERVICE_NAME + "*").with(DispatchServiceImpl.class);

	}

	@Provides
	AdministratorFacade createAdministratorFacade() {
		return administratorFacade;
	}
}
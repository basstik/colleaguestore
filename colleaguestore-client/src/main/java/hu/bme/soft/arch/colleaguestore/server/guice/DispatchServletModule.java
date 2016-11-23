package hu.bme.soft.arch.colleaguestore.server.guice;

import com.google.inject.Provides;
import com.google.inject.servlet.ServletModule;
import com.gwtplatform.dispatch.rpc.server.guice.DispatchServiceImpl;
import com.gwtplatform.dispatch.rpc.shared.ActionImpl;

import hu.bme.soft.arch.colleaguestore.facade.PersonFacade;

public class DispatchServletModule extends ServletModule {

	private final PersonFacade personFacade;

	public DispatchServletModule(PersonFacade personFacade) {
		this.personFacade = personFacade;
	}

	@Override
	public void configureServlets() {
		serve("/" + ActionImpl.DEFAULT_SERVICE_NAME + "*").with(DispatchServiceImpl.class);

	}

	@Provides
	PersonFacade createPersonFacade() {
		return personFacade;
	}
}
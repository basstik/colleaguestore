package hu.bme.soft.arch.colleaguestore.server.guice;

import javax.ejb.EJB;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

import hu.bme.soft.arch.colleaguestore.facade.PersonFacade;
import hu.bme.soft.arch.colleaguestore.facade.TeamFacade;

public class GuiceServletConfig extends GuiceServletContextListener {

	@EJB
	private PersonFacade personFacade;

	@EJB
	private TeamFacade teamFacade;

	@Override
	protected Injector getInjector() {
		return Guice.createInjector(new ServerModule(), new DispatchServletModule(personFacade, teamFacade));
	}
}
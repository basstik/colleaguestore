package hu.bme.soft.arch.colleaguestore.client.gin;

import com.gwtplatform.dispatch.rpc.client.gin.RpcDispatchAsyncModule;
import com.gwtplatform.mvp.client.annotations.DefaultPlace;
import com.gwtplatform.mvp.client.annotations.ErrorPlace;
import com.gwtplatform.mvp.client.annotations.UnauthorizedPlace;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;
import com.gwtplatform.mvp.shared.proxy.RouteTokenFormatter;

import hu.bme.soft.arch.colleaguestore.client.application.ApplicationModule;
import hu.bme.soft.arch.colleaguestore.client.place.NameTokens;
import hu.bme.soft.arch.colleaguestore.client.resources.ResourceLoader;

/**
 * See more on setting up the PlaceManager on <a href="// See more on:
 * https://github.com/ArcBees/GWTP/wiki/PlaceManager">DefaultModule's >
 * DefaultPlaceManager</a>
 */
public class ClientModule extends AbstractPresenterModule {
	@Override
	protected void configure() {
		install(new DefaultModule.Builder().tokenFormatter(RouteTokenFormatter.class).build());
		install(new ApplicationModule());
		install(new RpcDispatchAsyncModule());

		// DefaultPlaceManager Places
		bindConstant().annotatedWith(DefaultPlace.class).to(NameTokens.PERSON);
		bindConstant().annotatedWith(ErrorPlace.class).to(NameTokens.PERSON);
		bindConstant().annotatedWith(UnauthorizedPlace.class).to(NameTokens.PERSON);

		bind(ResourceLoader.class).asEagerSingleton();
	}
}
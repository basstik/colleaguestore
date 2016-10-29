package hu.bme.soft.arch.colleaguestore.server.guice;

import com.gwtplatform.dispatch.rpc.server.guice.HandlerModule;

import hu.bme.soft.arch.colleaguestore.server.dispatch.DispatchHandlersModule;

public class ServerModule extends HandlerModule {
	@Override
	protected void configureHandlers() {
		install(new DispatchHandlersModule());
	}
}
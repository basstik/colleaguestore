package hu.bme.soft.arch.colleaguestore.server.dispatch;

import com.gwtplatform.dispatch.rpc.server.guice.HandlerModule;

import hu.bme.soft.arch.colleaguestore.shared.UpdateAdministratorTableAction;

public class DispatchHandlersModule extends HandlerModule {

	@Override
	protected void configureHandlers() {
		bindHandler(UpdateAdministratorTableAction.class, UpateAdministratorTableHandler.class);

	}

}

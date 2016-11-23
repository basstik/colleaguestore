package hu.bme.soft.arch.colleaguestore.server.dispatch;

import com.gwtplatform.dispatch.rpc.server.guice.HandlerModule;

import hu.bme.soft.arch.colleaguestore.server.handler.CreatePersonHandler;
import hu.bme.soft.arch.colleaguestore.server.handler.DeletePersonHandler;
import hu.bme.soft.arch.colleaguestore.server.handler.UpatePersonTableHandler;
import hu.bme.soft.arch.colleaguestore.server.handler.UpdatePersonHandler;
import hu.bme.soft.arch.colleaguestore.shared.CreatePersonAction;
import hu.bme.soft.arch.colleaguestore.shared.DeletePersonAction;
import hu.bme.soft.arch.colleaguestore.shared.UpdatePersonAction;
import hu.bme.soft.arch.colleaguestore.shared.UpdatePersonTableAction;

public class DispatchHandlersModule extends HandlerModule {

	@Override
	protected void configureHandlers() {
		bindHandler(UpdatePersonTableAction.class, UpatePersonTableHandler.class);
		bindHandler(UpdatePersonAction.class, UpdatePersonHandler.class);
		bindHandler(CreatePersonAction.class, CreatePersonHandler.class);
		bindHandler(DeletePersonAction.class, DeletePersonHandler.class);

	}

}

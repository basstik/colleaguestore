package hu.bme.soft.arch.colleaguestore.server.dispatch;

import com.google.inject.Inject;
import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;

import hu.bme.soft.arch.colleaguestore.facade.AdministratorFacade;
import hu.bme.soft.arch.colleaguestore.shared.UpdateAdministratorTableAction;
import hu.bme.soft.arch.colleaguestore.shared.UpdateAdministratorTableResult;

public class UpateAdministratorTableHandler
		implements ActionHandler<UpdateAdministratorTableAction, UpdateAdministratorTableResult> {

	@Inject
	AdministratorFacade authorFacade;

	@Override
	public UpdateAdministratorTableResult execute(UpdateAdministratorTableAction action, ExecutionContext context)
			throws ActionException {
		return new UpdateAdministratorTableResult(authorFacade.getAdministrators(action.getAuthorFilterDTO()));
	}

	@Override
	public Class<UpdateAdministratorTableAction> getActionType() {
		return UpdateAdministratorTableAction.class;
	}

	@Override
	public void undo(UpdateAdministratorTableAction action, UpdateAdministratorTableResult result,
			ExecutionContext context) throws ActionException {
		// Not undoable
	}

}

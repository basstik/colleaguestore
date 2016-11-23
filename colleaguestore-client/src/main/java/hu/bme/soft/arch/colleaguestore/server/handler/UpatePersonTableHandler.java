package hu.bme.soft.arch.colleaguestore.server.handler;

import com.google.inject.Inject;
import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;

import hu.bme.soft.arch.colleaguestore.facade.PersonFacade;
import hu.bme.soft.arch.colleaguestore.shared.UpdatePersonTableAction;
import hu.bme.soft.arch.colleaguestore.shared.UpdatePersonTableResult;

public class UpatePersonTableHandler implements ActionHandler<UpdatePersonTableAction, UpdatePersonTableResult> {

	@Inject
	PersonFacade personFacade;

	@Override
	public UpdatePersonTableResult execute(UpdatePersonTableAction action, ExecutionContext context)
			throws ActionException {
		return new UpdatePersonTableResult(personFacade.getPersons(action.getPersonFilterDTO()));
	}

	@Override
	public Class<UpdatePersonTableAction> getActionType() {
		return UpdatePersonTableAction.class;
	}

	@Override
	public void undo(UpdatePersonTableAction action, UpdatePersonTableResult result, ExecutionContext context)
			throws ActionException {
		// Not undoable
	}

}

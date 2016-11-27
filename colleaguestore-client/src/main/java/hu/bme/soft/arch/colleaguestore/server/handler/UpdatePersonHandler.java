package hu.bme.soft.arch.colleaguestore.server.handler;

import com.google.inject.Inject;
import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;

import hu.bme.soft.arch.colleaguestore.facade.PersonFacade;
import hu.bme.soft.arch.colleaguestore.shared.UpdatePersonAction;
import hu.bme.soft.arch.colleaguestore.shared.UpdatePersonResult;

public class UpdatePersonHandler implements ActionHandler<UpdatePersonAction, UpdatePersonResult> {

	@Inject
	private PersonFacade facade;

	@Override
	public UpdatePersonResult execute(UpdatePersonAction action, ExecutionContext arg1) throws ActionException {
		facade.updatePerson(action.getPersonDto());
		return new UpdatePersonResult();
	}

	@Override
	public Class<UpdatePersonAction> getActionType() {
		return UpdatePersonAction.class;
	}

	@Override
	public void undo(UpdatePersonAction arg0, UpdatePersonResult arg1, ExecutionContext arg2) throws ActionException {
		// Not undoable
	}

}

package hu.bme.soft.arch.colleaguestore.server.handler;

import com.google.inject.Inject;
import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;

import hu.bme.soft.arch.colleaguestore.facade.PersonFacade;
import hu.bme.soft.arch.colleaguestore.shared.DeletePersonAction;
import hu.bme.soft.arch.colleaguestore.shared.DeletePersonResult;

public class DeletePersonHandler implements ActionHandler<DeletePersonAction, DeletePersonResult> {

	@Inject
	private PersonFacade facade;

	@Override
	public DeletePersonResult execute(DeletePersonAction action, ExecutionContext arg1) throws ActionException {
		facade.deletePerson(action.getId());
		return new DeletePersonResult();
	}

	@Override
	public Class<DeletePersonAction> getActionType() {
		return DeletePersonAction.class;
	}

	@Override
	public void undo(DeletePersonAction arg0, DeletePersonResult arg1, ExecutionContext arg2) throws ActionException {
		// no undoable
	}

}

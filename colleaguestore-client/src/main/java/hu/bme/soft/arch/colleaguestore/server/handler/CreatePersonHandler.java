package hu.bme.soft.arch.colleaguestore.server.handler;

import com.google.inject.Inject;
import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;

import hu.bme.soft.arch.colleaguestore.facade.PersonFacade;
import hu.bme.soft.arch.colleaguestore.shared.CreatePersonAction;
import hu.bme.soft.arch.colleaguestore.shared.CreatePersonResult;

public class CreatePersonHandler implements ActionHandler<CreatePersonAction, CreatePersonResult> {

	@Inject
	private PersonFacade facade;

	@Override
	public CreatePersonResult execute(CreatePersonAction action, ExecutionContext arg1) throws ActionException {
		facade.createPerson(action.getPesronDto());
		return new CreatePersonResult();
	}

	@Override
	public Class<CreatePersonAction> getActionType() {
		return CreatePersonAction.class;
	}

	@Override
	public void undo(CreatePersonAction arg0, CreatePersonResult arg1, ExecutionContext arg2) throws ActionException {
		// Not undoable
	}

}

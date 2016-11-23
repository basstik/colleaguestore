package hu.bme.soft.arch.colleaguestore.server.handler;

import com.google.inject.Inject;
import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;

import hu.bme.soft.arch.colleaguestore.facade.PersonFacade;
import hu.bme.soft.arch.colleaguestore.facade.TeamFacade;
import hu.bme.soft.arch.colleaguestore.shared.UpdatePersonTableAction;
import hu.bme.soft.arch.colleaguestore.shared.UpdatePersonTableResult;
import hu.bme.soft.arch.colleaguestore.shared.UpdateTeamTableAction;
import hu.bme.soft.arch.colleaguestore.shared.UpdateTeamTableResult;

public class UpateTeamTableHandler implements ActionHandler<UpdateTeamTableAction, UpdateTeamTableResult> {

	@Inject
	TeamFacade teamFacade;

	@Override
	public UpdateTeamTableResult execute(UpdateTeamTableAction action, ExecutionContext context)
			throws ActionException {
		return new UpdateTeamTableResult(teamFacade.getTeams(action.getTeamFilterDTO()));
	}

	@Override
	public Class<UpdateTeamTableAction> getActionType() {
		return UpdateTeamTableAction.class;
	}

	@Override
	public void undo(UpdateTeamTableAction arg0, UpdateTeamTableResult arg1, ExecutionContext arg2)
			throws ActionException {
		// Not undoable
	}

}

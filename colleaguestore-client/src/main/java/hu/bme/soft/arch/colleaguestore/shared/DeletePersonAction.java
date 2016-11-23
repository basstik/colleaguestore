package hu.bme.soft.arch.colleaguestore.shared;

import com.gwtplatform.dispatch.rpc.shared.UnsecuredActionImpl;

public class DeletePersonAction extends UnsecuredActionImpl<DeletePersonResult> {

	private Long id;

	/**
	 * For serialization only.
	 */
	@SuppressWarnings("unused")
	private DeletePersonAction() {
	}

	public DeletePersonAction(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

}

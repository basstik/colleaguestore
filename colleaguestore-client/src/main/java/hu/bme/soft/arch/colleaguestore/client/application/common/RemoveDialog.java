package hu.bme.soft.arch.colleaguestore.client.application.common;

import com.sencha.gxt.widget.core.client.box.ConfirmMessageBox;
import com.sencha.gxt.widget.core.client.event.DialogHideEvent;
import com.sencha.gxt.widget.core.client.event.DialogHideEvent.DialogHideHandler;

public abstract class RemoveDialog extends ConfirmMessageBox {

	public RemoveDialog(String messageHtml) {
		this("Delete", messageHtml);
		setWidth(300);
		addDialogHideHandler(new DialogHideHandler() {

			@Override
			public void onDialogHide(DialogHideEvent event) {
				if (event.getHideButton() == PredefinedButton.YES) {
					onRemove();
				}
			}
		});
	}

	private RemoveDialog(String titleHtml, String messageHtml) {
		super(titleHtml, messageHtml);
	}

	protected abstract void onRemove();
}

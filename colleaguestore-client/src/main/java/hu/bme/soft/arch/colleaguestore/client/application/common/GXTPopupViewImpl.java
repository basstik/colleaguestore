package hu.bme.soft.arch.colleaguestore.client.application.common;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.HandlerRegistration;
import com.gwtplatform.mvp.client.PopupView;
import com.gwtplatform.mvp.client.PopupViewCloseHandler;
import com.gwtplatform.mvp.client.PopupViewImpl;
import com.gwtplatform.mvp.client.ViewImpl;
import com.gwtplatform.mvp.client.proxy.NavigationEvent;
import com.gwtplatform.mvp.client.proxy.NavigationHandler;
import com.gwtplatform.mvp.client.view.PopupPositioner;
import com.gwtplatform.mvp.client.view.PopupPositioner.PopupPosition;
import com.sencha.gxt.widget.core.client.Window;
import com.sencha.gxt.widget.core.client.event.HideEvent;
import com.sencha.gxt.widget.core.client.event.HideEvent.HideHandler;

public abstract class GXTPopupViewImpl extends ViewImpl implements PopupView {

	private HandlerRegistration autoHideHandler;

	private HandlerRegistration closeHandlerRegistration;

	private final EventBus eventBus;

	private PopupPositioner positioner;

	/**
	 * The {@link PopupViewImpl} class uses the {@link EventBus} to listen to
	 * {@link NavigationEvent} in order to automatically close when this event
	 * is fired, if desired. See
	 * {@link #setAutoHideOnNavigationEventEnabled(boolean)} for details.
	 *
	 * @param eventBus
	 *            The {@link EventBus}.
	 */
	protected GXTPopupViewImpl(EventBus eventBus) {
		this.eventBus = eventBus;
	}

	@Override
	@Deprecated
	public void center() {
		doCenter();
		// We center again in a deferred command to solve a bug in IE where
		// newly
		// created window are sometimes not centered.
		Scheduler.get().scheduleDeferred(new Command() {

			@Override
			public void execute() {
				doCenter();
			}
		});
	}

	@Override
	public void hide() {
		asPopupPanel().hide();
	}

	@Override
	public void setAutoHideOnNavigationEventEnabled(boolean autoHide) {
		if (autoHide) {
			if (autoHideHandler != null) {
				return;
			}
			autoHideHandler = eventBus.addHandler(NavigationEvent.getType(), new NavigationHandler() {

				@Override
				public void onNavigation(NavigationEvent navigationEvent) {
					hide();
				}
			});
		} else {
			if (autoHideHandler != null) {
				autoHideHandler.removeHandler();
			}
		}
	}

	@Override
	public void setCloseHandler(final PopupViewCloseHandler popupViewCloseHandler) {
		if (closeHandlerRegistration != null) {
			closeHandlerRegistration.removeHandler();
		}
		if (popupViewCloseHandler == null) {
			closeHandlerRegistration = null;
		} else {
			closeHandlerRegistration = asPopupPanel().addHideHandler(new HideHandler() {

				@Override
				public void onHide(HideEvent event) {
					popupViewCloseHandler.onClose();
				}
			});

		}
	}

	@Override
	@Deprecated
	public void setPosition(int left, int top) {
		asPopupPanel().setPosition(left, top);
	}

	@Override
	public void show() {
		asPopupPanel().show();
	}

	/**
	 * Retrieves this view as a {@link PopupPanel}. See {@link #asWidget()}.
	 *
	 * @return This view as a {@link PopupPanel} object.
	 */
	protected Window asPopupPanel() {
		return (Window) asWidget();
	}

	/**
	 * This method centers the popup panel, temporarily making it visible if
	 * needed.
	 */
	private void doCenter() {
		boolean wasVisible = asPopupPanel().isVisible();
		asPopupPanel().center();
		if (!wasVisible) {
			asPopupPanel().hide();
		}
	}

	@Override
	public void setPopupPositioner(PopupPositioner popupPositioner) {
		this.positioner = popupPositioner;
	}

	@Override
	public void showAndReposition() {
		onReposition();
		show();
		if (positioner != null) {
			PopupPosition popupPosition = positioner.getPopupPosition(asPopupPanel().getOffsetWidth(),
					asPopupPanel().getOffsetHeight());
			asPopupPanel().setPosition(popupPosition.getLeft(), popupPosition.getTop());
		}
	}

	/**
	 * Override this method to add custom logic that runs before the popup is
	 * repositioned. By default the popup will be repositioned on resize and
	 * this method will be called. So you can add any resize logic here as well.
	 */
	protected void onReposition() {
	}
}

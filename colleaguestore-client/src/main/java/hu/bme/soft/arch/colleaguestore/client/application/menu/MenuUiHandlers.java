package hu.bme.soft.arch.colleaguestore.client.application.menu;

import com.gwtplatform.mvp.client.UiHandlers;

interface MenuUiHandlers extends UiHandlers {
	
	void goToPage(String nameToken);
}
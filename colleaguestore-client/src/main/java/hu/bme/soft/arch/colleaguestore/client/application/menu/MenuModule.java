package hu.bme.soft.arch.colleaguestore.client.application.menu;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class MenuModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
            bindPresenterWidget(MenuPresenter.class, MenuPresenter.MyView.class, MenuView.class);
    }
}
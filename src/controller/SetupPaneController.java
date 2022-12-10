package controller;

import model.facade.MetroFacade;
import model.observer.Observer;
import model.facade.MetroEventsEnum;
import view.panels.SetupPane;

public class SetupPaneController implements Observer {
    private SetupPane view;
    private final MetroFacade model;

    public SetupPaneController(MetroFacade metroFacade) {
        this.model = metroFacade;
        this.model.addObserver(this);
    }

    public void setView(SetupPane setupView) {
        this.view = setupView;
    }

    @Override
    public void update(MetroEventsEnum event) {
        switch (event) {

        }
    }
}

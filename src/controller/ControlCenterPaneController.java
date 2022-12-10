package controller;

import model.observer.Observer;
import model.facade.MetroEventsEnum;
import model.facade.MetroFacade;
import view.panels.ControlCenterPane;

public class ControlCenterPaneController implements Observer {
    private final MetroFacade model;
    private ControlCenterPane view;

    public ControlCenterPaneController(MetroFacade model) {
        this.model = model;
        this.model.addObserver(this);
    }

    public void setView(ControlCenterPane controlView) {
        this.view = controlView;
    }

    // OPENMETROSTATION
    public void openMetroStation() {
        model.openMetroStation();
    }

    @Override
    public void update(MetroEventsEnum event) {
        switch (event) {
            case OPEN_METROSTATION -> openMetroStation();
        }
    }
}

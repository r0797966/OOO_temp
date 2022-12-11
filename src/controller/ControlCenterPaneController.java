package controller;

import model.observer.Observer;
import model.facade.MetroEventsEnum;
import model.facade.MetroFacade;
import model.observer.Subject;
import view.panels.ControlCenterPane;

import java.io.IOException;

public class ControlCenterPaneController implements Observer {
    private MetroFacade model;
    private ControlCenterPane view;

    public ControlCenterPaneController(MetroFacade model) {
        this.model = model;
        this.model.addObserver(this);
    }

    public void setView(ControlCenterPane controlView) {
        this.view = controlView;
    }

    @Override
    public void update(MetroEventsEnum event) throws IOException {
        switch (event) {
            case BUY_METROCARD:
                reloadMetrostation();
                break;

        }

    }

    // OPENMETROSTATION
    public void openMetroStation() {
        model.openMetroStation();
    }

    public void reloadMetrostation() throws IOException {
        model.reloadMetroStation();
    }
}

package controller;

import model.observer.Observer;
import model.facade.MetroEventsEnum;
import model.facade.MetroFacade;
import view.panels.ControlCenterPane;

public class ControlCenterPaneController implements Observer {
    private ControlCenterPane controlCenterPane;
    private MetroFacade metroFacade = new MetroFacade();

    public ControlCenterPaneController() {
        //metroFacadeSubject.addObserver(this);
    }


    @Override
    public void update(MetroEventsEnum event) {
        switch (event) {
            case OPEN_METROSTATION -> openMetroStation();
        }
    }

    // OPENMETROSTATION
    public void openMetroStation() {
        this.metroFacade.openMetroStation();
    }
}

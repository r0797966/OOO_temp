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
            case BUY_TICKETS:
            case ACTIVATE_GATE:
                newTickets();
                break;
            case ALERT:
                addAlert();
        }

    }

    public void openMetroStation() {
        model.openMetroStation();
    }

    public void reloadMetrostation() throws IOException {

        model.reloadMetroStation();
    }

    public void newTickets() {
        view.newTickets(model.getTicketCount(), model.getPriceCount());
    }

    public void closeStation() {
        model.closeStation();
    }

    public void activateGate(int gateid) {
        model.activateGate(gateid);
    }

    public void deactivateGate(int gateid) {
        model.deactivateGate(gateid);
    }

    private void addAlert() {
        view.addAlert(model.createAlert());
    }
}

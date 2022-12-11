package controller;

import model.observer.Observer;
import model.facade.MetroEventsEnum;
import model.facade.MetroFacade;
import view.MetroTicketView;

import java.io.IOException;

public class MetroTicketViewController implements Observer {
    private MetroFacade model;
    public MetroTicketView view;

    public MetroTicketViewController(MetroFacade model) {
        this.model = model;
        this.model.addObserver(this);
    }

    public void setView(MetroTicketView metroTicketView) {
        this.view = metroTicketView;
    }

    @Override
    public void update(MetroEventsEnum event) {
        switch (event) {
            case OPEN_METROSTATION:
                getMetroCardIDList();
                break;
        }
    }

    public void getMetroCardIDList() {
        view.updateMetroCardIdList(model.getMetroCardIdList());
    }

    public void newMetrocard() throws IOException {
        model.newMetrocard();
    }


}

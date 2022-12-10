package controller;

import model.observer.Observer;
import model.facade.MetroEventsEnum;
import model.facade.MetroFacade;
import view.MetroTicketView;

public class MetroTicketViewController implements Observer {
    private final MetroFacade model;
    public MetroTicketView view;

    public MetroTicketViewController(MetroFacade metroFacade) {
        this.model = metroFacade;
        this.model.addObserver(this);
    }

    public void setView(MetroTicketView metroTicketView) {
        this.view = metroTicketView;
    }

    public void getMetroCardList() {
        model.getMetroCardList();
        // TODO: implement arraylist?
        System.out.println("implement arraylist?");
        view.updateMetroCardIdList(null);
    }

    @Override
    public void update(MetroEventsEnum event) {
        switch (event) {
            case OPEN_METROSTATION -> getMetroCardList();
        }
    }


}

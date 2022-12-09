package controller;

import model.observer.Observer;
import model.facade.MetroEventsEnum;
import model.facade.MetroFacade;
import model.observer.Subject;
import view.MetroTicketView;

public class MetroTicketViewController implements Observer {
    private MetroFacade metroFacade;
    public MetroTicketView metroTicketView;

    public MetroTicketViewController(MetroFacade metroFacade) {
        this.metroFacade = metroFacade;
        this.metroFacade.addObserver(this);
    }

    @Override
    public void update(MetroEventsEnum event) {
        switch (event) {
            case OPEN_METROSTATION -> getMetroCardList();
        }
    }

    public void getMetroCardList() {
        metroFacade.getMetroCardList();
        // TODO: implement arraylist?
        System.out.println("implement arraylist?");
        metroTicketView.updateMetroCardIdList(null);
    }


}

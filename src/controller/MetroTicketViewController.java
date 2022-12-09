package controller;

import model.Observer;
import model.facade.MetroEventsEnum;
import model.facade.MetroFacade;
import view.MetroTicketView;

import java.util.ArrayList;

public class MetroTicketViewController implements Observer {
    private MetroFacade metroFacade = new MetroFacade();
    public MetroTicketView metroTicketView = new MetroTicketView();

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
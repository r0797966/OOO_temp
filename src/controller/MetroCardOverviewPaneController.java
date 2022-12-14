package controller;

import model.observer.Observer;
import model.facade.MetroEventsEnum;
import model.facade.MetroFacade;
import view.panels.MetroCardOverviewPane;

public class MetroCardOverviewPaneController implements Observer {
    private MetroFacade model;
    private MetroCardOverviewPane view;

    public MetroCardOverviewPaneController(MetroFacade model) {
        this.model = model;
        this.model.addObserver(this);
    }

    public void setView(MetroCardOverviewPane metroCardOverviewView) {
        this.view = metroCardOverviewView;
    }

    @Override
    public void update(MetroEventsEnum event) {
        switch (event) {
            case OPEN_METROSTATION:
            case BUY_METROCARD:
            case SCAN_METROGATE:
            case BUY_TICKETS:
                getMetroCardList();
                break;

        }
    }

    public void getMetroCardList() {
        view.updateMetroCardList(model.getMetroCardList());
    }
}


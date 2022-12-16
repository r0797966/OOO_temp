package controller;

import model.observer.Observer;
import model.facade.MetroEventsEnum;
import model.facade.MetroFacade;
import view.MetroStationView;

public class MetroStationViewController implements Observer {
    private MetroFacade model;
    public MetroStationView view;

    public MetroStationViewController(MetroFacade model) {
        this.model = model;
        this.model.addObserver(this);
    }

    public void setView(MetroStationView metroStationView) {
        this.view = metroStationView;
    }

    @Override
    public void update(MetroEventsEnum event) {
        switch (event) {
            case OPEN_METROSTATION:
                getMetroCardIdList();
                break;
            case ACTIVATE_GATE:
                changeBackground();
                break;
        }
    }

    public void getMetroCardIdList() {
        view.updateMetroCardIdList(model.getMetroCardIdList());
    }

    public void scanMetroGate(int metrocardid, int gateid) {
        view.scanMetroGate(model.scanMetroGate(metrocardid, gateid));
    }


    public void walkThroughGate(int gateid) {
       view.walkThroughGate(model.walkThroughGate(gateid));
    }

    public void changeBackground() {
        view.changeBackground();
    }
}

package controller;

import model.observer.Observer;
import model.facade.MetroEventsEnum;
import model.facade.MetroFacade;
import model.observer.Subject;
import view.MetroStationView;

public class MetroStationViewController implements Observer {
    private MetroFacade metroFacade;
    public MetroStationView metroStationView;

    public MetroStationViewController(MetroFacade metroFacade) {
        this.metroFacade = metroFacade;
        this.metroFacade.addObserver(this);
    }

    @Override
    public void update(MetroEventsEnum event) {
        switch (event) {
            case OPEN_METROSTATION -> System.out.println("NOTHING YET");
        }
    }


}

package model;

import model.facade.MetroEventsEnum;
import model.facade.MetroFacade;
import model.metroGateStates.ClosedState;
import model.metroGateStates.OpenState;

import java.util.ArrayList;

public class MetroStation {
    private int stationID;
    private ArrayList<MetroGate> metroGates;

    public MetroStation() {
        this.stationID = stationID;
        this.metroGates = new ArrayList<MetroGate>();
        metroGates.add(new MetroGate(1, "Gate 1"));
    }

    public String scanMetroGate(int gateid, MetroCard card, MetroFacade facade) {
        for (MetroGate metroGate : metroGates) {
            if (metroGate.getGateID() == gateid) {
                System.out.println(metroGate.getState().toString());
                System.out.println(!card.isNotValidCard());
                if(!card.isNotValidCard() && metroGate.getState() instanceof ClosedState) {
                    metroGate.increaseNumberOfScannedCards();
                    card.scannedMetroGate();
                    facade.notifyObservers(MetroEventsEnum.SCAN_METROGATE);
                    return metroGate.scanMetroGate();
                } else {
                    facade.notifyObservers(MetroEventsEnum.ALERT);
                    return metroGate.createAlert();
                }
            }
        }
        return null;
    }

    public void increaseNumberOfScannedCards(int gateID) {
        for (MetroGate metroGate : metroGates) {
            if (metroGate.getGateID() == gateID) {
                metroGate.increaseNumberOfScannedCards();
            }
        }

    }

    public String createAlert(int gateID) {
        for (MetroGate metroGate : metroGates) {
            if (metroGate.getGateID() == gateID) {
                return metroGate.createAlert();
            }
        }
        return null;

    }

    public String walkThroughGate(int gateid, MetroFacade model) {
        for (MetroGate metroGate : metroGates) {
            if (metroGate.getGateID() == gateid) {
                if(metroGate.getState() instanceof OpenState){
                    return metroGate.walkThroughGate();
                }
                else{
                    model.notifyObservers(MetroEventsEnum.ALERT);
                    return metroGate.createAlert();
                }
            }

        }
        return null;
    }

    public void activateGate(int gateid) {
        for (MetroGate metroGate : metroGates) {
            if (metroGate.getGateID() == gateid) {
                metroGate.activate();
            }
        }
    }

    public void deactivateGate(int gateid) {
        for (MetroGate metroGate : metroGates) {
            if (metroGate.getGateID() == gateid) {
                metroGate.deactivate();
            }
        }
    }

    // scanMetroGate()
}

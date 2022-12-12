package model;

import java.util.ArrayList;

public class MetroStation {
    private int stationID;
    private ArrayList<MetroGate> metroGates;

    public MetroStation() {
        this.stationID = stationID;
        this.metroGates = new ArrayList<MetroGate>();
        metroGates.add(new MetroGate(1, "Gate 1"));
    }

    public String  scanMetroGate(int gateid) {
        for (MetroGate metroGate : metroGates) {
            if (metroGate.getGateID() == gateid) {
               return metroGate.scanMetroGate();
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

    // scanMetroGate()
}

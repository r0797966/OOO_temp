package model;

import model.metroGateStates.ClosedState;
import model.metroGateStates.MetroGateState;
import model.metroGateStates.MetroStateContext;
import model.metroGateStates.OpenState;

public class MetroGate {
    private MetroGateState state;
    private int GateID;
    private MetroStateContext context = new MetroStateContext();
    // scanMetroGate(getId)
    private String name;

    private int numberOfScannedCards;

    public MetroGate(int GateID, String name) {
        this.GateID = GateID;
        this.name = name;
        this.state = new ClosedState();
    }

    public MetroGate(int GateID){
        this.GateID = GateID;
        this.state = new ClosedState();
    }

    public void setState(MetroGateState state) {
        this.state = state;
    }
    public int getGateID() {
        return GateID;
    }

    public MetroGateState getState() {
        return state;
    }

    public String scanMetroGate() {
       return state.scanMetroGate();
    }

    public void increaseNumberOfScannedCards() {
        state.increaseNumberOfScannedCards(context);
        numberOfScannedCards++;
    }
    public int getNumberOfScannedCards() {
        return numberOfScannedCards;
    }

    public String createAlert() {
        return state.createAlert(context);
    }
}

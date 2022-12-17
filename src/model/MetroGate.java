package model;

import model.metroGateStates.*;

public class MetroGate {
    private MetroGateState state;
    private int GateID;
    private MetroStateContext context;
    private String name;
    private int numberOfScannedCards;

    public MetroGate(int GateID, String name) {
        this.context = new MetroStateContext();
        this.GateID = GateID;
        this.name = name;
        this.state = new InactiveState();
    }

    public MetroGate(int GateID){
        this.GateID = GateID;
        this.state = new InactiveState();
    }

    public void setState(MetroGateState state) {
        switch (state.toString()) {
            case "Open":
                context.setState(new OpenState());
                break;
            case "Closed":
                context.setState(new ClosedState());
                break;
            case "Inactive":
                context.setState(new InactiveState());
                break;
        }
    }

    public String scanMetroGate() {
        return context.getState().scanMetroGate(context);
    }

    public void increaseNumberOfScannedCards() {
        context.getState().increaseNumberOfScannedCards(context);
        numberOfScannedCards++;
    }

    public String createAlert(int id) {
        return context.getState().createAlert(context, id);
    }

    public String walkThroughGate() {
        return context.getState().walkThroughGate(context);

    }

    public void activate() {
        context.getState().activate(context);
    }

    public void deactivate() {
        context.getState().deactivate(context);
    }


    public int getGateID() {
        return GateID;
    }

    public MetroGateState getState() {
        return state;
    }

    public int getNumberOfScannedCards() {
        return numberOfScannedCards;
    }

    public MetroStateContext getContext() {
        return context;
    }


}

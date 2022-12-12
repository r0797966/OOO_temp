package model.metroGateStates;

public class ClosedState extends MetroGateState {
    // Constructor


    @Override
    public String walkThroughGate(MetroStateContext context) {
        context.setState(new ClosedState());
        return "Gate is closed";
    }

    @Override
    public String scanMetroGate() {

        return "0";
    }

    @Override
    public void increaseNumberOfScannedCards(MetroStateContext context) {
        context.setState(new OpenState());
        // add 1 to scanned cards

    }

    @Override
    public String createAlert(MetroStateContext context) {
        context.setState(new ClosedState());
        return "you have no available tickets left";

    }

    @Override
    public String toString() {
        return "Gate is Closed";
    }




}

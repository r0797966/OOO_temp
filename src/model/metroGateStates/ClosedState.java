package model.metroGateStates;

public class ClosedState extends MetroGateState {
    // Constructor


    @Override
    public String walkThroughGate(MetroStateContext context) {
        context.setState(new ClosedState());
        return "Gate is closed";
    }

    @Override
    public String scanMetroGate(MetroStateContext context) {
        context.setState(new OpenState());
        return "Card scanned";
    }

    @Override
    public void increaseNumberOfScannedCards(MetroStateContext context) {

        // add 1 to scanned cards


    }



    @Override
    public String createAlert(MetroStateContext context) {
        context.setState(new ClosedState());
        return "you have no available tickets left";
    }

    @Override
    public String toString() {
        return "Closed";
    }




}

package model.metroGateStates;

public class ClosedState extends MetroGateState {
    // Constructor


    @Override
    public String walkThroughGate(MetroStateContext context) {
        context.setState(new ClosedState());

        return createAlert(context);
    }

    @Override
    public String scanMetroGate(MetroStateContext context) {
        context.setState(new OpenState());
        return "Card scanned";
    }

    @Override
    public void increaseNumberOfScannedCards(MetroStateContext context) {


    }



    @Override
    public String createAlert(MetroStateContext context) {
        context.setState(new ClosedState());
        return "User has no available tickets left";
    }

    @Override
    public String deactivate(MetroStateContext context) {
        context.setState(new InactiveState());
        return "Gate is inactive";
    }
    @Override
    public String toString() {
        return "Closed";
    }




}

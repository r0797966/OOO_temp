package model.metroGateStates;

public class ClosedState extends MetroGateState {



    @Override
    public String walkThroughGate(MetroStateContext context) {
        context.setState(new ClosedState());
        return "Can't walk through closed gate";
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
    public String createAlert(MetroStateContext context, int id) {
        context.setState(new ClosedState());
        return "Unauthorized access at gate " + id;
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

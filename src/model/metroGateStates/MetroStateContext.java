package model.metroGateStates;

public class MetroStateContext {
    private MetroGateState state;

    public MetroStateContext() {
        this.state = new ClosedState();
    }

    public void setState(MetroGateState state) {
        this.state = state;
    }

    public MetroGateState getState() {
        return state;
    }
}

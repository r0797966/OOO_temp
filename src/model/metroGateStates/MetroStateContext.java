package model.metroGateStates;

public class MetroStateContext {
    private MetroGateState state;

    public MetroStateContext() {
        this.state = new InactiveState();
    }

    public void setState(MetroGateState state) {
        this.state = state;
    }

    public MetroGateState getState() {
        return state;
    }
}

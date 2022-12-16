package model.metroGateStates;

public class InactiveState extends MetroGateState {


    public String activate (MetroStateContext context){
        context.setState(new ClosedState());
        return "Gate is activated";
    }


    


    @Override
    public String toString() {
        return "Inactive";
    }
}


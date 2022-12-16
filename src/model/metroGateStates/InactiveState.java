package model.metroGateStates;

public class InactiveState extends MetroGateState {


    public String activate (MetroStateContext context){
        context.setState(new ClosedState());
        System.out.println(context.getState());
        System.out.println("Gate is active");
        return "Gate is activated";
    }

    @Override
    public String toString() {
        return "Inactive";
    }
}


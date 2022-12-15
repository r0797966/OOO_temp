package model.metroGateStates;

public class OpenState extends MetroGateState {





@Override
public String walkThroughGate(MetroStateContext context) {
    context.setState(new ClosedState());
    return "Walked through gate -OBAMA 2014";

}

@Override
public String scanMetroGate(MetroStateContext context) {
    context.setState(new OpenState());
    return "Card already scanned";
}

@Override
public String createWarning(MetroStateContext context) {
    context.setState(new OpenState());
    return "Card already scanned and warning is created";
}


    @Override
    public String toString() {
        return "Open";
    }
}

package model.metroGateStates;

public class OpenState extends MetroGateState {





    @Override
    public String walkThroughGate(MetroStateContext context) {
        context.setState(new ClosedState());
        return "Walked through gate ";

    }

    @Override
    public String scanMetroGate(MetroStateContext context) {
        context.setState(new OpenState());
        return "Card already scanned";
    }

    @Override
    public String createAlert(MetroStateContext context, int id) {
        context.setState(new OpenState());
        return "Double scan at gate " + id;
    }


        @Override
        public String toString() {
            return "Open";
        }
    }

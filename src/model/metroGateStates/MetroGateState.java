package model.metroGateStates;

public abstract class MetroGateState {



    public String openGate(MetroStateContext context){
        return "Gate is open";
    }
    public String closeGate(MetroStateContext context){
        return "Gate is closed";

    }
    public String createAlert(MetroStateContext context){
        return "You can't do this ";
        
    }
    public String createWarning(MetroStateContext context){
        return "Warning is created";

    }
    public void increaseNumberOfScannedCards(MetroStateContext context){

        // increase number of scanned cards
        /// .... + 1
    }
    public String scanMetroGate(MetroStateContext context){
        return "Gate is scanned";
    }
    public String walkThroughGate(MetroStateContext context){
        return "Person walks through gate";

    }
    /*public String activate(){
        return "Gate is activated";

    }*/
  /*  public String deactivate(){
        return "Gate is deactivated";

    }*/

    public void setClosedState(MetroStateContext context) {
        context.setState(new ClosedState());
    }

    public void activate(MetroStateContext context) {

    }

    public void deactivate(MetroStateContext context) {
    }


    // scanMetroGate()

    // STATES

}

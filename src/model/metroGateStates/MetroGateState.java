package model.metroGateStates;

public abstract class MetroGateState {




    public String createAlert(MetroStateContext context){
        return "Unauthorized passage ";
        
    }
    public String createWarning(MetroStateContext context){
        return "Warning!";

    }
    public void increaseNumberOfScannedCards(MetroStateContext context){

        // increase number of scanned cards
        /// .... + 1
    }
    public String scanMetroGate(MetroStateContext context){
        return "You cannot do this";
    }
    public String walkThroughGate(MetroStateContext context){
        return createAlert(context);

    }
    /*public String activate(){
        return "Gate is activated";

    }*/
  /*  public String deactivate(){
        return "Gate is deactivated";

    }*/


    public String activate(MetroStateContext context) {
        return "Gate is already active";
    }

    public String deactivate(MetroStateContext context) {
        return "Gate is already inactive";

    }


    // scanMetroGate()

    // STATES

}

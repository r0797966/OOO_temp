package model.metroGateStates;

public abstract class MetroGateState {




    public String createAlert(MetroStateContext context, int id){
        return "Create Alert cannot be used";
    }
    public String createWarning(MetroStateContext context){
        return "Warning cannot be used";
    }
    public void increaseNumberOfScannedCards(MetroStateContext context){

    }
    public String scanMetroGate(MetroStateContext context){
        return "Scan Metro Gate cannot be used";
    }
    public String walkThroughGate(MetroStateContext context){
        return "Walk Through Gate cannot be used";
    }


    public String activate(MetroStateContext context) {
        return "Activate cannot be used";
    }

    public String deactivate(MetroStateContext context) {
        return "Deactivate cannot be used";
    }

}

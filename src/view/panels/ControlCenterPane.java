package view.panels;

import controller.ControlCenterPaneController;
import javafx.geometry.Insets;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import model.facade.MetroFacade;

import java.io.IOException;

public class ControlCenterPane extends GridPane {
    ControlCenterPaneController controlCenterPaneController;

    public ControlCenterPane(ControlCenterPaneController controlCenterPaneController) throws IOException {
        this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);

        controlCenterPaneController.setView(this);
        this.controlCenterPaneController = controlCenterPaneController;

        openStationButton();
    }

    public void stationInformation(){

    }

    public void openStationButton() throws IOException {
        // open metrostation button
        Button openButton = new Button("Open metrostation");
        openButton.setOnAction(e ->
                {
                    controlCenterPaneController.openMetroStation();
                    openButton.setDisable(true);
                });
        this.add(openButton, 0, 0, 1, 1);
    }


}

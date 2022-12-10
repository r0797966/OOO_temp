package view.panels;

import controller.ControlCenterPaneController;
import javafx.geometry.Insets;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import model.facade.MetroFacade;

import java.io.IOException;

public class ControlCenterPane extends GridPane {

    public ControlCenterPane(ControlCenterPaneController controlCenterPaneController) throws IOException {
        this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);

        showControlCenter(controlCenterPaneController);
        controlCenterPaneController.setView(this);
    }

    public void showControlCenter(ControlCenterPaneController controlCenterPaneController) throws IOException {
        // open metrostation button
        Button openButton = new Button("Open metrostation");
        openButton.setOnAction(e ->
                {
                    System.out.println("open button clicked");
                    controlCenterPaneController.openMetroStation();
                    openButton.setDisable(true);
                });
        this.add(openButton, 0, 0, 1, 1);
    }


}

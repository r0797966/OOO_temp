package view.panels;

import controller.ControlCenterPaneController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.facade.MetroFacade;

import java.io.IOException;

public class ControlCenterPane extends GridPane {
    private final ControlCenterPaneController controlCenterPaneController;
    private final TextField ticketField = new TextField("0");
    private final TextField amountField = new TextField("0");

    public ControlCenterPane(ControlCenterPaneController controlCenterPaneController) throws IOException {
        this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);

        VBox root = new VBox();
        root.setSpacing(10);
        root.setPadding(new Insets(10, 10, 10, 10));
        this.getChildren().add(root);

        controlCenterPaneController.setView(this);
        this.controlCenterPaneController = controlCenterPaneController;

        stationInformation(root);
        openStationButton(root);
        closeStationButton(root);
    }

    public void stationInformation(VBox root) {
        HBox stationInformationBox = new HBox();
        stationInformationBox.setSpacing(10);
        stationInformationBox.setAlignment(Pos.CENTER_LEFT);

        Text ticketsSold = new Text("Number of sold tickets this session:");

        Text totalAmount = new Text("Total € amont of sold tickets this session:");

        stationInformationBox.getChildren().add(ticketsSold);
        stationInformationBox.getChildren().add(ticketField);
        stationInformationBox.getChildren().add(totalAmount);
        stationInformationBox.getChildren().add(amountField);

        root.getChildren().add(stationInformationBox);
    }

    public void gateInformation(VBox root){

    }

    public void alertInformation(VBox root){

    }

    public void openStationButton(VBox root) throws IOException {
        // open metrostation button
        Button openButton = new Button("Open metrostation");
        openButton.setOnAction(e ->
                {
                    controlCenterPaneController.openMetroStation();
                    openButton.setDisable(true);
                });
        root.getChildren().add(openButton);
    }

    public void closeStationButton(VBox root){
        Button closeButton = new Button("Close metrostation");
        closeButton.setOnAction(e ->
                {
                    controlCenterPaneController.closeStation();
                    // exit the program
                    System.exit(0);
                });
        root.getChildren().add(closeButton);
    }

    // METHODES
    public void newTickets(int tickets, double amount){
        ticketField.setText(String.valueOf(tickets));
        amountField.setText(String.valueOf(amount));
    }


}

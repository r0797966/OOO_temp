package view.panels;

import controller.ControlCenterPaneController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
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
    TextArea alert = new TextArea();

    private String statusstring = "Inactive";

    public ControlCenterPane(ControlCenterPaneController controlCenterPaneController) throws IOException {
        this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);

        VBox root = new VBox();
        HBox hBox = new HBox();
        root.setSpacing(10);
        root.setPadding(new Insets(10, 10, 10, 10));
        this.getChildren().add(root);

        controlCenterPaneController.setView(this);
        this.controlCenterPaneController = controlCenterPaneController;

        stationInformation(root);
        openStationButton(root);
        closeStationButton(root);
        for (int i = 1; i < 4; i++) {
            setgateField(hBox, i);

        }
        root.getChildren().add(hBox);
        setAlertField(root);



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

    public void setgateField(HBox root,int gateid){
        Label status = new Label(statusstring);

        HBox statusBox = new HBox();
        VBox gateInformationBox = new VBox();
        gateInformationBox.setSpacing(5);
        gateInformationBox.setAlignment(Pos.CENTER_LEFT);

        Label gate = new Label("Gate" + gateid + "/");
        statusBox.getChildren().add(gate);
        Button active =  new Button("Activate");
        active.setOnAction(e ->
        {
            controlCenterPaneController.activateGate(gateid);
            //active.setDisable(true);
            status.setText("Active");
            gateInformationBox.setStyle("-fx-background-color: grey; -fx-border-color: black; -fx-border-width: 1px;");
        });
        Button deactive =  new Button("Deactivate");
        deactive.setOnAction(e ->
        {
            controlCenterPaneController.deactivateGate(gateid);
            // deactive.setDisable(true);
            status.setText("Inactive");
            gateInformationBox.setStyle("-fx-background-color: orange; -fx-border-color: black; -fx-border-width: 1px;");
        });




        // Add the buttons and labels to each VBox
        statusBox.getChildren().add(status);
        gateInformationBox.getChildren().add(statusBox);
        gateInformationBox.getChildren().add(active);
        gateInformationBox.getChildren().add(deactive);
        gateInformationBox.getChildren().add(new Label("#Scanned cards: "));
        TextField textArea = new TextField("0");
        gateInformationBox.getChildren().add(textArea);
        textArea.setEditable(false);
        gateInformationBox.setPadding(new Insets(10, 10, 10, 10));
        gateInformationBox.setPrefWidth(225);
        gateInformationBox.setPrefHeight(200);
        gateInformationBox.setStyle("-fx-background-color: orange; -fx-border-color: black; -fx-border-width: 1px;");





        // make a grey box around the gate information but dont make the background the entire length of the window
        root.getChildren().add(gateInformationBox);

    }

    public void setAlertField(VBox root){
        HBox alertBox = new HBox();

        alert.setEditable(false);
        alert.setStyle("-fx-border-color: black; -fx-border-width: 1px;");
        alertBox.getChildren().add(alert);
        root.getChildren().add(alertBox);
    }

    // METHODES
    public void newTickets(int tickets, double amount){
        ticketField.setText(String.valueOf(tickets));
        amountField.setText(String.valueOf(amount));
    }

    public void addAlert(String alert) {
        this.alert.appendText(alert);
        // add a newline
        this.alert.appendText("\n");

    }









}

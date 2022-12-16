package view;

import controller.MetroStationViewController;
import controller.MetroTicketViewController;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.facade.MetroFacade;

import java.util.ArrayList;

public class MetroStationView {
	private Stage stage = new Stage();
	private ChoiceBox<Integer> metroCardIdList;
	private MetroStationViewController metroStationViewController;
	private TextField information;
	private VBox gate;
	private Button scanCardButton;
	private Button walkThroughGateButton;


	
	public MetroStationView(MetroStationViewController metroStationViewController) {
		stage.setTitle("METRO STATION VIEW");
		stage.initStyle(StageStyle.UTILITY);
		stage.setX(5);
		stage.setY(390);
		HBox root = new HBox();
		Scene scene = new Scene(root, 650, 300);			
		stage.setScene(scene);
		stage.sizeToScene();			
		stage.show();

		metroStationViewController.setView(this);
		this.metroStationViewController = metroStationViewController;
		metroGate(root);
	}

	public void metroGate(HBox root) {
		gate = new VBox();
		gate.setSpacing(10);
		gate.setPadding(new Insets(10, 10, 10, 10));
		gate.setStyle("-fx-background-color: orange;");

		Text title1 = new Text("Gate 1");
		Label label = new Label("MetroCardID:");
		metroCardIdList = new ChoiceBox<Integer>();
		metroCardIdList.setDisable(true);
		metroCardIdList.setPrefWidth(125);
		metroCardIdList.getSelectionModel().selectFirst();

		scanCardButton = new Button("Scan card");
		scanCardButton.setPrefWidth(125);
		scanCardButton.setDisable(true);
		scanCardButton.setOnAction(e -> {
			metroStationViewController.scanMetroGate(metroCardIdList.getValue(), 1);
		});

		walkThroughGateButton = new Button("Walk through gate");
		walkThroughGateButton.setPrefWidth(125);
		walkThroughGateButton.setDisable(true);
		walkThroughGateButton.setOnAction(e -> {
			metroStationViewController.walkThroughGate(1);
		});

		information = new TextField();
		information.setEditable(false);
		information.setPrefWidth(125);

		gate.getChildren().add(title1);
		gate.getChildren().add(label);
		gate.getChildren().add(metroCardIdList);
		gate.getChildren().add(scanCardButton);
		gate.getChildren().add(walkThroughGateButton);
		gate.getChildren().add(information);

		root.getChildren().add(gate);

	}

	public void updateMetroCardIdList(ArrayList<Integer> ids) {
		metroCardIdList.setItems(FXCollections.observableArrayList(ids));
		metroCardIdList.getSelectionModel().selectFirst();
	}



	public void scanMetroGate(String scanMetroGate) {
		information.setText(scanMetroGate);
	}

	public void walkThroughGate(String walkThroughGate) {
		information.setText(walkThroughGate);
	}

	public void changeBackground() {
		gate.setStyle("-fx-background-color: grey;");
		scanCardButton.setDisable(false);
		walkThroughGateButton.setDisable(false);
		metroCardIdList.setDisable(false);
	}
}

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
	private ChoiceBox<Integer> metroCardIdList = new ChoiceBox<Integer>();
	private MetroStationViewController metroStationViewController;
	TextField information = new TextField("");
	
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
		VBox gate1 = new VBox();
		gate1.setSpacing(10);
		gate1.setPadding(new Insets(10, 10, 10, 10));
		gate1.setStyle("-fx-background-color: grey;");

		// metrocard id
		Text title1 = new Text("Gate 1");
		Label label = new Label("MetroCardID:");
		metroCardIdList.setPrefWidth(125);
		metroCardIdList.getSelectionModel().selectFirst();

		// scan card
		Button scanCardButton = new Button("Scan card");
		scanCardButton.setPrefWidth(125);
		scanCardButton.setOnAction(e -> {
			metroStationViewController.scanMetroGate(metroCardIdList.getValue(), 1);
		});

		// walk through gate
		Button walkThroughGateButton = new Button("Walk through gate");
		walkThroughGateButton.setPrefWidth(125);
		walkThroughGateButton.setOnAction(e -> {
			metroStationViewController.walkThroughGate(1);
		});

		// information

		information.setEditable(false);
		information.setPrefWidth(125);

		gate1.getChildren().add(title1);
		gate1.getChildren().add(label);
		gate1.getChildren().add(metroCardIdList);
		gate1.getChildren().add(scanCardButton);
		gate1.getChildren().add(walkThroughGateButton);
		gate1.getChildren().add(information);

		root.getChildren().add(gate1);

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
}

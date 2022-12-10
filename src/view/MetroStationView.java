package view;

import controller.MetroStationViewController;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.facade.MetroFacade;

import java.util.ArrayList;

public class MetroStationView {
	private Stage stage = new Stage();
	ChoiceBox<Integer> metroCardIdList = new ChoiceBox<Integer>();
	
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
		metroStationShow(root);
	}

	public void metroStationShow(HBox root) {
		// gate 1
		VBox gate1 = new VBox();
		gate1.setSpacing(10);
		gate1.setPadding(new Insets(10, 10, 10, 10));

		Text title1 = new Text("Gate 1");
		Label label = new Label("MetroCardID:");

		gate1.getChildren().add(title1);
		gate1.getChildren().add(label);
		gate1.getChildren().add(metroCardIdList);

		root.getChildren().add(gate1);
	}

	public void updateMetroCardIdList(ArrayList<Integer> ids) {
		metroCardIdList.setItems(FXCollections.observableArrayList(ids));
	}
}

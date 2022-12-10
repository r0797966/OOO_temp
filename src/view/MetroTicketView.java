package view;

import controller.MetroTicketViewController;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.facade.MetroFacade;

import java.util.ArrayList;

public class MetroTicketView extends GridPane {
	private Stage stage = new Stage();		
		
	public MetroTicketView(MetroTicketViewController metroTicketViewController) {
		stage.setTitle("METROTICKET VIEW");
		stage.initStyle(StageStyle.UTILITY);
		stage.setX(5);
		stage.setY(5);
		Group root = new Group();
		Scene scene = new Scene(root, 650, 350);
		stage.setScene(scene);
		stage.sizeToScene();			
		stage.show();

		metroTicketViewController.setView(this);

		Button newCardButton = new Button("New metro card");
		newCardButton.setOnAction(e -> {
			System.out.println("New metro card");
		});
		root.getChildren().add(newCardButton);

	}

	// UPDATEMETROCARDIDLIST(IDs ArrayList<Integer>)
	public void updateMetroCardIdList(ArrayList<Integer> ids) {
		// TODO: refresh doen van de choicebox met metrocard ID’s -> hebben we nog niet
		System.out.println("implement (nog niet mogelijk nog geen view");
	}
}

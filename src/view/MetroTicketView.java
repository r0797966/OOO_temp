package view;

import com.sun.tools.javac.Main;
import controller.MetroTicketViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.facade.MetroFacade;

import java.util.ArrayList;

public class MetroTicketView extends GridPane {
	private Stage stage = new Stage();
	private ChoiceBox<Integer> metroCardIdList = new ChoiceBox<Integer>();
		
	public MetroTicketView(MetroTicketViewController metroTicketViewController) {
		stage.setTitle("METROTICKET VIEW");
		stage.initStyle(StageStyle.UTILITY);
		stage.setX(5);
		stage.setY(5);
		VBox root = new VBox();
		Scene scene = new Scene(root, 650, 350);
		stage.setScene(scene);
		stage.sizeToScene();			
		stage.show();

		metroTicketViewController.setView(this);
		metroTicketShow(root, metroTicketViewController);

	}

	public void metroTicketShow(VBox root, MetroTicketViewController metroTicketViewController){
		// VBOX 1
		VBox vBox1 = new VBox();

		vBox1.setSpacing(10);
		vBox1.setPadding(new Insets(10, 10, 10, 10));
		// NEW CARD BUTTON
		Button newCardButton = new Button("New metro card");
		newCardButton.setOnAction(e -> {
			System.out.println("New metro card");
			metroTicketViewController.newMetrocard();
		});
		// TEXT
		Text text1 = new Text("Metro card price is 15€ - 2 free rides included");

		vBox1.getChildren().add(newCardButton);
		vBox1.getChildren().add(text1);
		// VBOX 2
		VBox vBox2 = new VBox();
		vBox2.setSpacing(10);
		vBox2.setPadding(new Insets(10, 10, 10, 10));

		// select metrocard choicebox
		Label label = new Label("Select metro card:");
		vBox2.getChildren().add(label);
		metroCardIdList.setMinWidth(100);
		vBox2.getChildren().add(metroCardIdList);

		root.getChildren().add(vBox1);
		root.getChildren().add(vBox2);
	}

	// UPDATEMETROCARDIDLIST(IDs ArrayList<Integer>)
	public void updateMetroCardIdList(ArrayList<Integer> ids) {
		metroCardIdList.setItems(FXCollections.observableArrayList(ids));
	}
}

package view;

import controller.MetroTicketViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.database.loadSaveStrategies.LoadSaveStrategy;
import model.facade.MetroFacade;

import java.io.IOException;
import java.util.ArrayList;

public class MetroTicketView extends GridPane {
	private Stage stage = new Stage();
	private ChoiceBox<Integer> metroCardIdList = new ChoiceBox<Integer>();
	private Button newCardButton = new Button("New metro card");
	private MetroTicketViewController metroTicketViewController;
	private LoadSaveStrategy loadSaveStrategy;
		
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
		this.metroTicketViewController = metroTicketViewController;

		metroTicketViewController.setView(this);
		newCardView(root);
		addRidesView(root);
	}

	// NEW CARD VBOX
	public void newCardView(VBox root){
		VBox vBox = new VBox();

		vBox.setSpacing(10);
		vBox.setPadding(new Insets(10, 10, 10, 10));
		// NEW CARD BUTTON
		newCardButton.setDisable(true);
		newCardButton.setOnAction(e -> {
			try {
				metroTicketViewController.newMetrocard();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		});
		// TEXT
		Text text1 = new Text("Metro card price is 15€ - 2 free rides included");

		vBox.getChildren().add(newCardButton);
		vBox.getChildren().add(text1);
		root.getChildren().add(vBox);
	}

	// ADD RIDES VBOX
	public void addRidesView(VBox root){
		// select metrocard choicebox
		HBox hBox = new HBox();
		hBox.setSpacing(10);
		Label label = new Label("Select metro card:");
		hBox.getChildren().add(label);
		metroCardIdList.setPrefWidth(80);
		hBox.getChildren().add(metroCardIdList);

		// number of rides
		HBox hBox2 = new HBox();
		hBox2.setSpacing(16);
		Label label2 = new Label("Number of rides:");
		TextField textField = new TextField();
		textField.setPrefWidth(80);
		hBox2.getChildren().add(label2);
		hBox2.getChildren().add(textField);

		// higher education student?
		HBox hBox3 = new HBox();
		hBox3.setSpacing(10);
		CheckBox checkBox = new CheckBox("Higher education student?");
		hBox3.getChildren().add(checkBox);

		// age range
		HBox hBox4 = new HBox();
		hBox4.setSpacing(10);
		ToggleGroup toggleGroup = new ToggleGroup();
		RadioButton radioButton1 = new RadioButton("younger than 26 years");
		RadioButton radioButton2 = new RadioButton("between 26 and 64 years");
		RadioButton radioButton3 = new RadioButton("older than 64 years");
		radioButton1.setToggleGroup(toggleGroup);
		radioButton2.setToggleGroup(toggleGroup);
		radioButton3.setToggleGroup(toggleGroup);
		hBox4.getChildren().add(radioButton1);
		hBox4.getChildren().add(radioButton2);
		hBox4.getChildren().add(radioButton3);

		// information
		VBox vBox2 = new VBox();
		vBox2.setSpacing(10);
		vBox2.setPadding(new Insets(10, 10, 10, 10));
		// add button
		Button button = new Button("Add extra rides to metro card");
		// price
		HBox hBox5 = new HBox();
		hBox5.setSpacing(10);
		Label label3 = new Label("Total price:");
		TextField textField2 = new TextField("to change");
		textField2.setPrefWidth(80);
		textField2.setEditable(false);
		hBox5.getChildren().add(label3);
		hBox5.getChildren().add(textField2);
		// text
		Text text = new Text("This needs to change depending on choice (price)");
		// confirm or cancel
		HBox hBox6 = new HBox();
		hBox6.setSpacing(10);
		Button button2 = new Button("Confirm");
		Button button3 = new Button("Cancel");
		hBox6.getChildren().add(button2);
		hBox6.getChildren().add(button3);

		vBox2.getChildren().add(button);
		vBox2.getChildren().add(hBox5);
		vBox2.getChildren().add(text);
		vBox2.getChildren().add(hBox6);

		vBox2.setStyle("-fx-border-color: black; -fx-border-width: 1px; -fx-border-style: solid;");


		// add boxes
		VBox vBox = new VBox();
		vBox.setSpacing(10);
		vBox.setPadding(new Insets(10, 10, 10, 10));
		vBox.setStyle("-fx-background-color: grey;");
		vBox.getChildren().add(hBox);
		vBox.getChildren().add(hBox2);
		vBox.getChildren().add(hBox3);
		vBox.getChildren().add(hBox4);
		vBox.getChildren().add(vBox2);
		root.getChildren().add(vBox);
	}

	// UPDATEMETROCARDIDLIST(IDs ArrayList<Integer>)
	public void updateMetroCardIdList(ArrayList<Integer> ids) {
		metroCardIdList.setItems(FXCollections.observableArrayList(ids));
		metroCardIdList.getSelectionModel().selectFirst();
		newCardButton.setDisable(false);
	}
}

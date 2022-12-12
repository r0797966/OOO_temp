package view;

import controller.MetroTicketViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
import model.MetroCard;
import model.database.loadSaveStrategies.LoadSaveStrategy;
import model.facade.MetroFacade;
import model.ticketPriceDecorator.TicketPrice;

import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

import static jdk.nashorn.internal.objects.NativeMath.round;

public class MetroTicketView extends GridPane {
	private Stage stage = new Stage();
	private final MetroTicketViewController metroTicketViewController;

	private final ChoiceBox<Integer> metroCardIdList = new ChoiceBox<Integer>();
	private final Button newCardButton = new Button("New metro card");
	private final TextField numberRides = new TextField("1");
	private final Button addRides = new Button("Add extra rides to metro card");
	private final TextField ticketPrice = new TextField("");
	private final Button confirmButton = new Button("Confirm");
	private final Text priceText = new Text("");
		
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
		addRides(root);
		informationView(root);
	}

	// NEW CARD VBOX
	public void newCardView(VBox root){
		VBox vBox = new VBox();

		vBox.setSpacing(5);
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

	public void addRides(VBox root){
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
		numberRides.setPrefWidth(80);
		hBox2.getChildren().add(label2);
		hBox2.getChildren().add(numberRides);

		// higher education student?
		HBox hBox3 = new HBox();
		hBox3.setSpacing(10);
		CheckBox studies = new CheckBox("Higher education student?");
		hBox3.getChildren().add(studies);

		// age range
		HBox hBox4 = new HBox();
		hBox4.setSpacing(5);
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

		// add rides button
		addRides.setDisable(true);
		addRides.setOnAction(e -> {
			Integer id = metroCardIdList.getValue();
			int rides = Integer.parseInt(numberRides.getText());
			boolean student = studies.isSelected();
			boolean senior = radioButton3.isSelected();
			addRidesInformation(id, rides, student, senior);
		});

		VBox vBox = new VBox();
		vBox.setSpacing(10);
		vBox.setPadding(new Insets(10, 10, 10, 10));
		vBox.setStyle("-fx-background-color: grey;");
		vBox.getChildren().add(hBox);
		vBox.getChildren().add(hBox2);
		vBox.getChildren().add(hBox3);
		vBox.getChildren().add(hBox4);
		vBox.getChildren().add(addRides);
		root.getChildren().add(vBox);
	}

	// ADD RIDES VBOX
	public void informationView(VBox root){
		// information
		VBox vBox2 = new VBox();
		vBox2.setSpacing(5);
		vBox2.setPadding(new Insets(10, 10, 10, 10));
		// price
		HBox hBox5 = new HBox();
		hBox5.setSpacing(10);
		hBox5.setAlignment(Pos.CENTER_LEFT);
		Label label3 = new Label("Total price:");
		ticketPrice.setPrefWidth(80);
		ticketPrice.setEditable(false);
		hBox5.getChildren().add(label3);
		hBox5.getChildren().add(ticketPrice);
		// text
		// confirm or cancel
		HBox hBox6 = new HBox();
		hBox6.setSpacing(10);
		confirmButton.setOnAction(e -> {
			int id = metroCardIdList.getValue();
			int rides = Integer.parseInt(numberRides.getText());
			metroTicketViewController.addRides(id, rides);
		});
		Button cancelButton = new Button("Cancel");
		cancelButton.setOnAction(e -> {
			metroCardIdList.getSelectionModel().selectFirst();
			numberRides.setText("1");
			ticketPrice.setText("");
		});
		hBox6.getChildren().add(confirmButton);
		hBox6.getChildren().add(cancelButton);

		vBox2.getChildren().add(hBox5);
		vBox2.getChildren().add(priceText);
		vBox2.getChildren().add(hBox6);

		// add boxes
		VBox vBox = new VBox();
		vBox.setSpacing(10);
		vBox.setPadding(new Insets(10, 10, 10, 10));
		vBox.getChildren().add(vBox2);
		root.getChildren().add(vBox);
	}

	// UPDATEMETROCARDIDLIST(IDs ArrayList<Integer>)
	public void updateMetroCardIdList(ArrayList<Integer> ids) {
		metroCardIdList.setItems(FXCollections.observableArrayList(ids));
		metroCardIdList.getSelectionModel().selectFirst();
		newCardButton.setDisable(false);
		addRides.setDisable(false);
	}

	public void addRidesInformation(Integer id, int rides, boolean student, boolean senior){
		metroTicketViewController.addRidesInformation(id, rides, student, senior);
		double price = metroTicketViewController.addRidesInformation(id, rides, student, senior).getPrice();
		price *= Integer.parseInt(numberRides.getText());
		// round price to 2 after comma
		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.CEILING);
		String priceString = df.format(price);
		ticketPrice.setText(priceString);
		priceText.setText(metroTicketViewController.addRidesInformation(id, rides, student, senior).getPriceText());
	}
}

package view.panels;


import controller.MetroCardOverviewPaneController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import model.MetroCard;
import model.database.MetrocardDatabase;
import model.facade.MetroFacade;

import java.io.IOException;
import java.util.ArrayList;


public class MetroCardOverviewPane extends GridPane{
	private MetrocardDatabase metrocardDatabase;
	private ObservableList<MetroCard> metroCards;
	private TableView<MetroCard> table = new TableView<MetroCard>();
	
	public MetroCardOverviewPane(MetroCardOverviewPaneController metroCardOverviewPaneController) throws IOException {
		this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);        
		this.add(new Label("List of Metro cards:"), 0, 0, 1, 1);

		showMetrocards();
		metroCardOverviewPaneController.setView(this);
	}

	public void showMetrocards() throws IOException {
		metrocardDatabase = new MetrocardDatabase();
		// id column
		TableColumn<MetroCard, Integer> colId = new TableColumn<MetroCard, Integer>("Id");
		colId.setMinWidth(150);
		colId.setCellValueFactory(new PropertyValueFactory<MetroCard, Integer>("metrokaartID"));
		// datum column
		TableColumn<MetroCard, String> colDate = new TableColumn<MetroCard, String>("Date");
		colDate.setMinWidth(150);
		colDate.setCellValueFactory(new PropertyValueFactory<MetroCard, String>("datum"));
		// beschikbaar column
		TableColumn<MetroCard, Integer> colBeschikbaar = new TableColumn<MetroCard, Integer>("Beschikbaar");
		colBeschikbaar.setMinWidth(150);
		colBeschikbaar.setCellValueFactory(new PropertyValueFactory<MetroCard, Integer>("beschikbareTickets"));
		// verbruikt column
		TableColumn<MetroCard, Integer> colVerbruikt = new TableColumn<MetroCard, Integer>("Verbruikt");
		colVerbruikt.setMinWidth(150);
		colVerbruikt.setCellValueFactory(new PropertyValueFactory<MetroCard, Integer>("verbruikeTickets"));


		table.getColumns().addAll(colId, colDate, colBeschikbaar, colVerbruikt);
		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		table.prefHeightProperty().bind(this.heightProperty());
		table.prefWidthProperty().bind(this.widthProperty());
		this.add(table, 0, 1, 1, 1);

	}

	public void updateMetroCardList(ArrayList<MetroCard> metroCards) {
		this.metroCards = FXCollections.observableList(metroCards);
		table.setItems(this.metroCards);
		table.refresh();

	}
}

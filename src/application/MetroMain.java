package application;
	
import controller.*;
import javafx.application.Application;
import javafx.stage.Stage;
import model.MetroCard;
import model.facade.MetroFacade;
import model.ticketPriceDecorator.TicketPriceFactory;
import view.AdminView;
import view.MetroStationView;
import view.MetroTicketView;
import view.panels.ControlCenterPane;
import view.panels.SetupPane;

import java.io.IOException;


public class MetroMain extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {
		// FACADE
		MetroFacade model = new MetroFacade();
		// CONTROLLERS
		ControlCenterPaneController controlCenterPaneController = new ControlCenterPaneController(model);
		MetroCardOverviewPaneController metroCardOverviewPaneController = new MetroCardOverviewPaneController(model);
		MetroStationViewController metroStationViewController = new MetroStationViewController(model);
		MetroTicketViewController metroTicketViewController = new MetroTicketViewController(model);
		SetupPaneController setupPaneController = new SetupPaneController(model);
		// VIEWS
		new AdminView(controlCenterPaneController, metroCardOverviewPaneController, setupPaneController);
		new MetroTicketView(metroTicketViewController);
		new MetroStationView(metroStationViewController);

		// test
		MetroCard metroCard = new MetroCard(1, "02#2022", 5, 2);
		TicketPriceFactory.createTicketPrice(true, true, false, metroCard);

	}
	
	public static void main(String[] args) {
		launch(args);
	}

}

package application;
	
import controller.ControlCenterPaneController;
import controller.MetroCardOverviewPaneController;
import controller.MetroStationViewController;
import controller.MetroTicketViewController;
import javafx.application.Application;
import javafx.stage.Stage;
import model.facade.MetroFacade;
import view.AdminView;
import view.MetroStationView;
import view.MetroTicketView;
import view.panels.ControlCenterPane;

import java.io.IOException;


public class MetroMain extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {
		// FACADE
		MetroFacade metroFacade = new MetroFacade();
		// CONTROLLERS
		ControlCenterPaneController controlCenterPaneController = new ControlCenterPaneController();
		MetroCardOverviewPaneController metroCardOverviewPaneController = new MetroCardOverviewPaneController();
		MetroStationViewController metroStationViewController = new MetroStationViewController();
		MetroTicketViewController metroTicketViewController = new MetroTicketViewController();
		// setup controller
		// VIEWS
		AdminView adminView = new AdminView();
		MetroTicketView metroTicketView = new MetroTicketView();
		MetroStationView metroStationView = new MetroStationView();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}

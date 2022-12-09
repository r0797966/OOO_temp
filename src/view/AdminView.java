package view;

import controller.MetroCardOverviewPaneController;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.facade.MetroFacade;

import java.io.IOException;

public class AdminView {
	private Stage stage = new Stage();
	private MetroCardOverviewPaneController metroCardOverviewPaneController = new MetroCardOverviewPaneController();
	private MetroFacade metroFacade = new MetroFacade();
		
	public AdminView() throws IOException {
		stage.setTitle("ADMIN VIEW");
		stage.initStyle(StageStyle.UTILITY);
		stage.setX(660);
		stage.setY(5);
		Group root = new Group();
		Scene scene = new Scene(root, 690, 680);
		BorderPane borderPane = new AdminMainPane();
		borderPane.prefHeightProperty().bind(scene.heightProperty());
		borderPane.prefWidthProperty().bind(scene.widthProperty());
		root.getChildren().add(borderPane);
		stage.setScene(scene);
		stage.sizeToScene();			
		stage.show();		
	}
}

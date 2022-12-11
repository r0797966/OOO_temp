package view.panels;

import controller.SetupPaneController;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;

import java.io.*;
import java.util.Properties;

public class SetupPane extends GridPane {
    private ChoiceBox choiceBox;
    Button saveButton = new Button("Save");

    public SetupPane(SetupPaneController setupPaneController) {
        this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);

        showSetup();
        setupPaneController.setView(this);
    }

    public void showSetup() {
        // CHOICEBOX
        choiceBox = new ChoiceBox(FXCollections.observableArrayList(
                "tekst", "excel")
        );
        choiceBox.getSelectionModel().selectFirst();
        this.add(choiceBox, 0, 0, 1, 1);

        // SAVE BUTTON
        saveButton.setDisable(true);
        saveButton.setOnAction(e ->
                {
                    String value = (String) choiceBox.getValue();
                     try (OutputStream output = new FileOutputStream("src/bestanden/settings.properties")) {
                         InputStream file = new FileInputStream("src/bestanden/settings.properties");
                         Properties properties = new Properties();
                         properties.load(file);

                         properties.setProperty("filetype", value);

                         properties.store(output, "Changed filetype to " + value);
                         file.close();
                     } catch (IOException ex) {
                         System.out.println(ex.getMessage());
                }
                    });
        this.add(saveButton, 0, 1,  1, 1);
    }

    public void openSetup() {
        saveButton.setDisable(false);
    }



}

package view.panels;

import controller.SetupPaneController;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;

import java.io.*;
import java.util.Properties;

public class SetupPane extends GridPane {
    //private SetupPaneController setupPaneController = new SetupPaneController();
    private ChoiceBox choiceBox;

    public SetupPane() {
        this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);

        showSetup();
    }

    public void showSetup() {
        // CHOICEBOX
        choiceBox = new ChoiceBox(FXCollections.observableArrayList(
                "tekst", "excel")
        );
        this.add(choiceBox, 0, 0, 1, 1);

        // SAVE BUTTON
        Button saveButton = new Button("Save");
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



}

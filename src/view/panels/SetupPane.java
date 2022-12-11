package view.panels;

import controller.SetupPaneController;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.StringJoiner;

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
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(5, 5, 5, 5));
        vBox.setSpacing(10);
        // FILE TYPE
        HBox fileTypeBox = new HBox();
        fileTypeBox.setSpacing(10);
        fileTypeBox.setAlignment(Pos.CENTER_LEFT);
        Label fileTypeLabel = new Label("File Type:");
        choiceBox = new ChoiceBox(FXCollections.observableArrayList(
                "tekst", "excel")
        );
        choiceBox.getSelectionModel().selectFirst();
        fileTypeBox.getChildren().addAll(fileTypeLabel, choiceBox);

        // DISCOUNT CHOICES
        Label discountLabel = new Label("Discounts:");
        CheckBox plus64 = new CheckBox("AGE64PLUSDISCOUNT");
        CheckBox christmas = new CheckBox("CHRISTMASDISCOUNT");
        CheckBox student = new CheckBox("STUDENTDISCOUNT");
        CheckBox frequent = new CheckBox("FREQUENTDISCOUNT");
        HBox discount = new HBox();
        discount.setSpacing(10);
        discount.getChildren().addAll(plus64, christmas, student, frequent);

        // SAVE BUTTON
        saveButton.setDisable(true);
        saveButton.setOnAction(e ->
                {
                    // save to file
                    String value = (String) choiceBox.getValue();
                    // checkbox choices
                    boolean plus64Selected = plus64.isSelected();
                    boolean christmasSelected = christmas.isSelected();
                    boolean studentSelected = student.isSelected();
                    boolean frequentSelected = frequent.isSelected();
                    try (OutputStream output = new FileOutputStream("src/bestanden/settings.properties")) {
                        InputStream file = new FileInputStream("src/bestanden/settings.properties");
                        Properties properties = new Properties();
                        properties.load(file);

                        properties.setProperty("filetype", value);

                        ArrayList<String> discountList = new ArrayList<>();
                        if(plus64Selected) {
                            discountList.add("AGE64PLUSDISCOUNT");
                        }
                        if(christmasSelected) {
                            discountList.add("CHRISTMASDISCOUNT");
                        }
                        if(studentSelected) {
                            discountList.add("STUDENTDISCOUNT");
                        }
                        if(frequentSelected) {
                            discountList.add("FREQUENTDISCOUNT");
                        }
                        StringJoiner sj = new StringJoiner(",");
                        discountList.forEach(sj::add);
                        properties.setProperty("discounts", sj.toString());


                        properties.store(output, "Changed filetype");
                        file.close();
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                });

        vBox.getChildren().add(fileTypeBox);
        vBox.getChildren().add(discountLabel);
        vBox.getChildren().add(discount);
        vBox.getChildren().add(saveButton);

        this.getChildren().add(vBox);
    }

    public void openSetup() {
        saveButton.setDisable(false);
    }

}

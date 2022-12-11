package view.panels;

import controller.SetupPaneController;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.database.loadSaveStrategies.LoadSaveStrategyEnum;
import model.ticketPriceDecorator.TicketPriceDiscountEnum;

import java.io.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.StringJoiner;

public class SetupPane extends GridPane {
    private Button saveButton = new Button("Save");
    private SetupPaneController controller;

    private String filetype = "tekst";
    private ArrayList<String> discountTypes = new ArrayList<>();

    public SetupPane(SetupPaneController setupPaneController) {
        this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);
        VBox root = new VBox();
        root.setSpacing(10);
        root.setPadding(new Insets(10, 10, 10, 10));
        this.getChildren().add(root);

        this.controller = setupPaneController;
        setupPaneController.setView(this);

        filetypeChoice(root);
        discountChoices(root);
        saveButton(root);
    }

    public void filetypeChoice(VBox root) {
        HBox fileTypeBox = new HBox();
        fileTypeBox.setSpacing(10);
        fileTypeBox.setAlignment(Pos.CENTER_LEFT);
        fileTypeBox.setPadding(new Insets(5, 5, 5, 5));

        ToggleGroup toggleGroup = new ToggleGroup();

        Label chooseFileExtensionLabel = new Label("File type:");
        fileTypeBox.getChildren().add(chooseFileExtensionLabel);

        LoadSaveStrategyEnum[] loadSaveStrategiesEnums = LoadSaveStrategyEnum.values();

        for (int i = 0; i < loadSaveStrategiesEnums.length; i++) {
            LoadSaveStrategyEnum strategyEnum = loadSaveStrategiesEnums[i];

            RadioButton radioButton = new RadioButton(strategyEnum.getOmschrijving());
            radioButton.setToggleGroup(toggleGroup);
            radioButton.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
                this.filetype = radioButton.getText();
            });

            fileTypeBox.getChildren().add(radioButton);
        }

        root.getChildren().add(fileTypeBox);
    }

    public void discountChoices(VBox root){
        HBox discountBox = new HBox();
        discountBox.setSpacing(10);
        discountBox.setPadding(new Insets(5, 5, 5, 5));

        Label chooseDiscountLabel = new Label("Discount:");
        discountBox.getChildren().add(chooseDiscountLabel);

        TicketPriceDiscountEnum[] ticketPriceDiscountEnums = TicketPriceDiscountEnum.values();

        for (int i = 0; i < ticketPriceDiscountEnums.length; i++) {
            TicketPriceDiscountEnum strategyEnum = ticketPriceDiscountEnums[i];

            CheckBox checkBox = new CheckBox(strategyEnum.getOmschrijving());
            checkBox.selectedProperty().addListener(e -> {
                if(checkBox.isSelected()){
                    discountTypes.add(checkBox.getText());
                } else {
                    discountTypes.remove(checkBox.getText());
                }
            });

            discountBox.getChildren().add(checkBox);
        }

        root.getChildren().add(discountBox);

    }

    public void saveButton(VBox root){
        HBox saveButtonBox = new HBox();
        saveButtonBox.setPadding(new Insets(5, 5, 5, 5));
        saveButton.setDisable(true);
        saveButton.setOnAction(e -> {
            try (OutputStream output = new FileOutputStream("src/bestanden/settings.properties")) {
                InputStream file = new FileInputStream("src/bestanden/settings.properties");
                Properties properties = new Properties();
                properties.load(file);

                properties.setProperty("filetype", filetype);

                StringJoiner stringJoiner = new StringJoiner(",");
                for (String discountType : discountTypes) {
                    stringJoiner.add(discountType);
                }
                properties.setProperty("discounts", stringJoiner.toString());

                properties.store(output, "Changed filetype");
                file.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        });
        saveButtonBox.getChildren().add(saveButton);
        root.getChildren().add(saveButtonBox);
    }

    public void openSetup() {
        saveButton.setDisable(false);
    }

}
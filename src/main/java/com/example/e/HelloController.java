package com.example.e;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {

    @FXML
    private TabPane tabPane;
    @FXML
    private TextField textName, textPrice, textWeight, textScreenSize, textCameraResolution, textRamSize, textProcessorType, textBatteryLife;
    @FXML
    private CheckBox checkStylus;
    @FXML
    private ListView<Device> listView;
    @FXML
    private Label selectedText;

    private final ObservableList<Device> devices = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        listView.setItems(devices);
        listView.setOnMouseClicked(event -> onListClicked());
    }

    @FXML
    void onAddClick(ActionEvent event) {
        String name = textName.getText();
        double price = Double.parseDouble(textPrice.getText());
        double weight = Double.parseDouble(textWeight.getText());

        Device device = null;
        String selectedTab = tabPane.getSelectionModel().getSelectedItem().getText();

        switch (selectedTab) {
            case "Smartphone" -> {
                double screenSize = Double.parseDouble(textScreenSize.getText());
                double cameraResolution = Double.parseDouble(textCameraResolution.getText());
                device = new Smartphone(name, price, weight, screenSize, cameraResolution);
            }
            case "Laptop" -> {
                int ramSize = Integer.parseInt(textRamSize.getText());
                String processorType = textProcessorType.getText();
                device = new Laptop(name, price, weight, ramSize, processorType);
            }
            case "Tablet" -> {
                double batteryLife = Double.parseDouble(textBatteryLife.getText());
                boolean hasStylus = checkStylus.isSelected();
                device = new Tablet(name, price, weight, batteryLife, hasStylus);
            }
        }

        if (device != null) {
            devices.add(device);
            clearInputFields();
        }
    }

    @FXML
    void onRemoveClick(ActionEvent event) {
        Device selected = listView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            devices.remove(selected);
        }
    }

    @FXML
    void onListClicked() {
        Device selected = listView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            selectedText.setText(selected.toString());
        }
    }

    private void clearInputFields() {
        textName.clear();
        textPrice.clear();
        textWeight.clear();
        textScreenSize.clear();
        textCameraResolution.clear();
        textRamSize.clear();
        textProcessorType.clear();
        textBatteryLife.clear();
        checkStylus.setSelected(false);
    }
}

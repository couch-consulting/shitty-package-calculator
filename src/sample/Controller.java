package sample;

import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;


public class Controller {
    @FXML
    private TextField width, height, depth, weight, result;

    @FXML
    private Label wUnit, hUnit, dUnit, weightUnit;

    @FXML
    private ComboBox lengthUnitBox, weightUnitBox;

    @FXML
    private MenuItem closeItem;

    private ObjectProperty<ULength> lengthProp = new SimpleObjectProperty<>();
    private ObjectProperty<UWeight> weightProp = new SimpleObjectProperty<>();


    public void initialize() {

        closeItem.setOnAction(e -> Platform.exit());

        width.textProperty().addListener((observable, oldValue, newValue) -> {
            result.setText(width.getText() + height.getText() + depth.getText() + weight.getText());
        });
        height.textProperty().addListener((observable, oldValue, newValue) -> {
            result.setText(width.getText() + height.getText() + depth.getText() + weight.getText());
        });
        depth.textProperty().addListener((observable, oldValue, newValue) -> {
            result.setText(width.getText() + height.getText() + depth.getText() + weight.getText());
        });
        weight.textProperty().addListener((observable, oldValue, newValue) -> {
            result.setText(width.getText() + height.getText() + depth.getText() + weight.getText());
        });

        //comboboxes
        for (ULength u : ULength.values())
            lengthUnitBox.setItems(FXCollections.observableArrayList(ULength.values()));


        lengthProp.addListener((observable, oldValue, newValue) -> {

            wUnit.setText(newValue.toString());
            hUnit.setText(newValue.toString());
            dUnit.setText(newValue.toString());
        });
        lengthProp.bind(lengthUnitBox.valueProperty());

        lengthUnitBox.setValue(ULength.cm);

//
        for (UWeight u : UWeight.values())
            weightUnitBox.setItems(FXCollections.observableArrayList(UWeight.values()));

        weightProp.addListener((observable, oldValue, newValue) -> {
            weightUnit.setText(newValue.toString());
        });
        weightProp.bind(weightUnitBox.valueProperty());

        weightUnitBox.setValue(UWeight.g);
    }

    public double calcShippingCosts (String length, String height, String width, String weigth) {
        
    }
}

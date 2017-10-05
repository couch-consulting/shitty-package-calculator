package sample;

import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

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

        width.addEventFilter(KeyEvent.KEY_TYPED, e -> inputFilter(e));
        height.addEventFilter(KeyEvent.KEY_TYPED, e -> inputFilter(e));
        depth.addEventFilter(KeyEvent.KEY_TYPED, e -> inputFilter(e));
        weight.addEventFilter(KeyEvent.KEY_TYPED, e -> inputFilter(e));

        closeItem.setOnAction(e -> Platform.exit());

        width.textProperty().addListener((observable, oldValue, newValue) -> {
            result.setText(Double.toString(calcShippingCosts(depth.getText(), height.getText(), width.getText(), weight.getText())));
        });
        height.textProperty().addListener((observable, oldValue, newValue) -> {
            result.setText(Double.toString(calcShippingCosts(depth.getText(), height.getText(), width.getText(), weight.getText())));
        });
        depth.textProperty().addListener((observable, oldValue, newValue) -> {
            result.setText(Double.toString(calcShippingCosts(depth.getText(), height.getText(), width.getText(), weight.getText())));
        });
        weight.textProperty().addListener((observable, oldValue, newValue) -> {
            result.setText(Double.toString(calcShippingCosts(depth.getText(), height.getText(), width.getText(), weight.getText())));
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

    public double calcShippingCosts (String length, String height, String width, String weight) {
        PackageConfig s = new PackageConfig();
        Double d_length = Double.parseDouble(length.isEmpty() ? "0.0" : length);
        Double d_height = Double.parseDouble(height.isEmpty() ? "0.0" : height);
        Double d_width = Double.parseDouble(width.isEmpty() ? "0.0" : width);
        Double d_weight = Double.parseDouble(weight.isEmpty() ? "0.0" : weight);
        d_length /= 10;
        d_height /= 10;
        d_width /= 10;
        d_weight /= 1000;

        if (d_length <= s.small.length && d_width <= 30 && d_height <= 15 && d_weight < 1) {
            return 4.00;
        } else if (d_length <= 60 && d_width <= 30 && d_height <= 15 && d_weight < 2 ) {
            return 4.50;
        } else if (d_length <= 120 && d_width <= 60 && d_height <= 60 ) {
            if (d_weight <= 5) {
                return 6.99;
            } else if ( d_weight <= 10) {
                return 9.49;
            } else if (d_weight <= 31.5) {
                return 16.49;
            } else {
                return 1000000;
            }
        } else {
            return 100000000;
        }
    }

    private void inputFilter(KeyEvent e){
        char c = e.getCharacter().charAt(0);
        if (!(Character.isDigit(c) || c == ',')){
            e.consume();
        }
    }
}

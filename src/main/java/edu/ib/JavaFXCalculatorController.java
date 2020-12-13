package edu.ib;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class JavaFXCalculatorController {

    boolean dotPresent = false;
    double input = 0;
    double input2 = 0;
    double result = 0;
    int operation = 0;
    boolean lastEquals = false;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField display;

    @FXML
    private Button clear;

    @FXML
    private Button opposite;

    @FXML
    private Button perc;

    @FXML
    private Button div;

    @FXML
    private Button seven;

    @FXML
    private Button eight;

    @FXML
    private Button nine;

    @FXML
    private Button mult;

    @FXML
    private Button four;

    @FXML
    private Button five;

    @FXML
    private Button six;

    @FXML
    private Button minus;

    @FXML
    private Button one;

    @FXML
    private Button two;

    @FXML
    private Button three;

    @FXML
    private Button plus;

    @FXML
    private Button zero;

    @FXML
    private Button dot;

    @FXML
    private Button equals;

    @FXML
    void onClick(ActionEvent event) {
        Button[] buttons = {zero, one, two, three, four, five, six, seven, eight, nine};
        String[] values = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

        for (int i = 0; i < buttons.length; i++) {
            if (event.getSource() == buttons[i]) {
                if (display.getText().equals("0") || lastEquals) {
                    display.setText(values[i]);
                    lastEquals = false;
                } else {
                    display.setText(display.getText() + values[i]);
                }
            }
        }

        if (event.getSource() == clear) {
            display.setText("0");
            dotPresent = false;
            input = 0;
            input2 = 0;
            result = 0;
            operation = 0;
            lastEquals = false;
        }

        if (event.getSource() == dot && !dotPresent) {
            display.setText(display.getText() + ".");
            dotPresent = true;
        }

        if (event.getSource() == opposite) {
            input = Double.parseDouble(display.getText());
            input *= (-1.0);
            display.setText(String.valueOf(input));
        }

        if (event.getSource() == perc) {
            input = Double.parseDouble(display.getText());
            input *= (0.01);
            display.setText(String.valueOf(input));
        }
    }

    @FXML
    void onOperatorClick(ActionEvent event) {

        if (event.getSource() == div) {
            input = Double.parseDouble(display.getText());
            operation = 1;
            display.setText("0");
            dotPresent = false;
            lastEquals = false;

        } else if (event.getSource() == mult) {
            input = Double.parseDouble(display.getText());
            operation = 2;
            display.setText("0");
            dotPresent = false;
            lastEquals = false;

        } else if (event.getSource() == minus) {
            input = Double.parseDouble(display.getText());
            operation = 3;
            display.setText("0");
            dotPresent = false;
            lastEquals = false;

        } else if (event.getSource() == plus) {
            input = Double.parseDouble(display.getText());
            operation = 4;
            display.setText("0");
            dotPresent = false;
            lastEquals = false;

        } else if (event.getSource() == equals) {
            if (!lastEquals) {
                input2 = Double.parseDouble(display.getText());
            }
            result = 0;
            switch (operation) {
                case 1:
                    result = input / input2;
                    if (Double.isInfinite(result) || Double.isNaN(result)) {
                        display.setText("Error");
                    } else {
                        display.setText(String.valueOf(result));
                    }
                    break;
                case 2:
                    result = input * input2;
                    display.setText(String.valueOf(result));
                    break;
                case 3:
                    result = input - input2;
                    display.setText(String.valueOf(result));
                    break;
                case 4:
                    result = input + input2;
                    display.setText(String.valueOf(result));
                    break;
            }
            input = result;
            lastEquals = true;
        }
    }

    @FXML
    void initialize() {
        assert display != null : "fx:id=\"display\" was not injected: check your FXML file 'calculator.fxml'.";
        assert clear != null : "fx:id=\"clear\" was not injected: check your FXML file 'calculator.fxml'.";
        assert opposite != null : "fx:id=\"opposite\" was not injected: check your FXML file 'calculator.fxml'.";
        assert perc != null : "fx:id=\"perc\" was not injected: check your FXML file 'calculator.fxml'.";
        assert div != null : "fx:id=\"div\" was not injected: check your FXML file 'calculator.fxml'.";
        assert seven != null : "fx:id=\"seven\" was not injected: check your FXML file 'calculator.fxml'.";
        assert eight != null : "fx:id=\"eight\" was not injected: check your FXML file 'calculator.fxml'.";
        assert nine != null : "fx:id=\"nine\" was not injected: check your FXML file 'calculator.fxml'.";
        assert mult != null : "fx:id=\"mult\" was not injected: check your FXML file 'calculator.fxml'.";
        assert four != null : "fx:id=\"four\" was not injected: check your FXML file 'calculator.fxml'.";
        assert five != null : "fx:id=\"five\" was not injected: check your FXML file 'calculator.fxml'.";
        assert six != null : "fx:id=\"six\" was not injected: check your FXML file 'calculator.fxml'.";
        assert minus != null : "fx:id=\"minus\" was not injected: check your FXML file 'calculator.fxml'.";
        assert one != null : "fx:id=\"one\" was not injected: check your FXML file 'calculator.fxml'.";
        assert two != null : "fx:id=\"two\" was not injected: check your FXML file 'calculator.fxml'.";
        assert three != null : "fx:id=\"three\" was not injected: check your FXML file 'calculator.fxml'.";
        assert plus != null : "fx:id=\"plus\" was not injected: check your FXML file 'calculator.fxml'.";
        assert zero != null : "fx:id=\"zero\" was not injected: check your FXML file 'calculator.fxml'.";
        assert dot != null : "fx:id=\"dot\" was not injected: check your FXML file 'calculator.fxml'.";
        assert equals != null : "fx:id=\"equals\" was not injected: check your FXML file 'calculator.fxml'.";

    }
}

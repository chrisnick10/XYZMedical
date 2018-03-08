/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyzmedical.view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

/**
 *
 * @author Will
 */
public class LoginPane extends GridPane {
    final String IDLE_TEXT = "Enter Username...";
    TextField usernameField;
    PasswordField passwordField;
    Button submitButton;
    
    public LoginPane() {
        super();
        usernameField = new TextField();
        passwordField = new PasswordField();
        submitButton = new Button();

        usernameField.setText(IDLE_TEXT);
        submitButton.setText("LOGIN");
        submitButton.setMaxWidth(Double.MAX_VALUE);

        usernameField.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                usernameFocusChanged(newValue);
            }
        });

        setPadding(new Insets(20, 20, 20, 20));
        setVgap(5);

        getChildren().add(usernameField);
        getChildren().add(passwordField);
        getChildren().add(submitButton);

        // Set positioning of widgets
        setRowIndex(usernameField, 0);
        setColumnIndex(usernameField, 0);
        setRowIndex(passwordField, 1);
        setColumnIndex(passwordField, 0);
        setRowIndex(submitButton, 2);
        setColumnIndex(submitButton, 0);

        // Allow widgets to resize
        ColumnConstraints mainColumn = new ColumnConstraints(300, 100, Double.MAX_VALUE);
        mainColumn.setHgrow(Priority.ALWAYS);
        getColumnConstraints().add(mainColumn);
        
        setAlignment(Pos.CENTER);
    }
    
    private void usernameFocusChanged(boolean newValue) {
        if (newValue) { // Focus in
            if (usernameField.getText().equalsIgnoreCase(IDLE_TEXT)) {
                usernameField.setText("");
            }
        } else { // Focus out
            if (usernameField.getText().equalsIgnoreCase("")) {
                usernameField.setText(IDLE_TEXT);
            }
        }
    }
}

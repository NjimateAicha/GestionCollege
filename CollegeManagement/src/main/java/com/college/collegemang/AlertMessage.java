package com.college.collegemang;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;


public class AlertMessage {


        public void successMessage(String message) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Message");
            alert.setHeaderText(null);
            alert.setContentText(message);
            alert.show();
        }

        public void errorMessage(String message) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText(message);
            alert.show();
        }

        public boolean confirmMessage(String message) {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText(message);

            Optional<ButtonType> option = alert.showAndWait();

            return option.get().equals(ButtonType.OK);
        }
    }


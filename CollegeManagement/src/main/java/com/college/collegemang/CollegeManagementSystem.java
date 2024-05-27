package com.college.collegemang;  // Assurez-vous que le nom du package est correct

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CollegeManagementSystem extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLlogin.fxml"));

        Scene scene = new Scene(root);

        stage.setTitle("College Management System");

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        //demare l appl javafx
        launch();
    }
}
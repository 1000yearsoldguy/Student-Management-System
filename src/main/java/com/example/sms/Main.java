package com.example.sms;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application {
    //public static Stage primaryStage;

    @Override
    public void start(Stage stage) throws IOException {
       // primaryStage = stage;

        Parent root = FXMLLoader.load(getClass().getResource("LogInPage.fxml"));
        Scene scene = new Scene(root, 900, 700);

        stage.setTitle("Student Management System");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        launch();
    }
}


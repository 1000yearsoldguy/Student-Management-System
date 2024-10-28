package com.example.sms;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class MediCareController {

    @FXML
    private Button add_prb_btn;

    @FXML
    private Button delete_prb_btn;

    @FXML
    private Label label_username;

    @FXML
    private Button logout;

    @FXML
    private Button reg_btn;
    @FXML
    private ListView<String> listofProblems;

    @FXML
    private TextField problemField;

    @FXML
    void addProblem(MouseEvent event) { listofProblems.getItems().add(problemField.getText());

    }

    @FXML
    void deleteProblem(MouseEvent event) {
        int selectedProblems = listofProblems.getSelectionModel().getSelectedIndex();
        listofProblems.getItems().remove(selectedProblems);
    }

    @FXML
    void switchToDashboard(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void switchToLogInPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("LogInPage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void switchToPayTheFess(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("PayTheFess.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void switchToRegistration(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Registration.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void switchToSettings(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FAQ.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void switchToVaccineStatus(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("VaccineStatus.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
package com.example.sms;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.io.IOException;

public class RegistrationController {

    @FXML
    private Button add_course_btn;

    @FXML
    private TextField courseField;

    @FXML
    private ListView<String> listOfCourses;

    @FXML
    private Button logout;

    @FXML
    private Button reg_btn;

    @FXML
    private Button remove_course_btn;

    @FXML
    private Text txt_username;

    @FXML
    private Button vc_status_btn;

    @FXML
    void addCourse(MouseEvent event) {
        listOfCourses.getItems().add(courseField.getText());
    }

    @FXML
    void deleteCourse(MouseEvent event) {
        int selectedCourse = listOfCourses.getSelectionModel().getSelectedIndex();
        listOfCourses.getItems().remove(selectedCourse);
    }

    //For switching scene to Dashboard
    public void switchToDashboard(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
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
    @FXML
    void switchToLogInPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("LogInPage.fxml"));
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
    void switchToPayTheFess(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("PayTheFess.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void switchToMediCare(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MediCare.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}

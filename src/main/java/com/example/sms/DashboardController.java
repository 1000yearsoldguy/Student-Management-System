package com.example.sms;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;


public class DashboardController implements Initializable {

    @FXML
    private Button logout;
    private Stage stage;
    private Scene scene;

    @FXML
    private Label label_username;


    @FXML
    private Label label_Announcement;
    public void displayName(String username){
        label_username.setText(""+username);
    }

    public void initialize(URL url, ResourceBundle resourceBundle){
        label_Announcement.setText(Messages.text);
        Messages.text="";
    }

    public void switchToRegistration(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Registration.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
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
        try (Socket socket = new Socket("localhost", 1234)) {

            // writing to server
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // reading from server
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // object of scanner class
            Scanner sc = new Scanner(System.in);
            String line = null;

            //place new code here
            Parent root = FXMLLoader.load(getClass().getResource("LogInPage.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

            System.out.println("Logout Successful");
            // closing the scanner object
            sc.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
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


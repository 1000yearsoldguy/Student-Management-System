package com.example.sms;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class VaccineStatusController implements Initializable  /*implements Initializable*/ {

    @FXML
    private ChoiceBox<String> choicebox1;

    @FXML
    private ChoiceBox<String> choicebox2;

    @FXML
    private TextField id_field;

    @FXML
    private Button update;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choicebox1.getItems().addAll("Astrazeneca", "Phizer", "Moderna" , "Johnson & Johnson");
        choicebox2.getItems().addAll("Astrazeneca", "Phizer", "Moderna" , "Johnson & Johnson");
    }
    @FXML
    private DatePicker datePicker1;

    @FXML
    private DatePicker datePicker2;

    @FXML
    void onClickUpdate(ActionEvent event) throws IOException {
        try (Socket socket = new Socket("localhost", 1234)) {

            // writing to server
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // reading from server
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // object of scanner class
            Scanner sc = new Scanner(System.in);
            String line = null;

            //place new code here
            StringBuilder sb1 = new StringBuilder();
            sb1.append(choicebox1.getValue().toString());
            String date1 = String.valueOf((datePicker1.getValue()));
            StringBuilder sb2 = new StringBuilder();
            sb2.append(choicebox2.getValue().toString());
            String date2 = String.valueOf((datePicker2.getValue()));

            FileWriter fw = new FileWriter(new File("src/main/resources/Info/VaccineUpdate.txt"), true);
            fw.write("\n"+id_field.getText()+","+sb1.toString()+","+date1.toString()+","+sb2.toString()+","+date2.toString());
            fw.close();

            System.out.println("Update Successful");
            // closing the scanner object
            sc.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void switchToRegistration(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Registration.fxml"));
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
    void switchToDashboard(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
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
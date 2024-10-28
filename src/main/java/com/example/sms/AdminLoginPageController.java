package com.example.sms;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class AdminLoginPageController {

    @FXML
    private PasswordField password_field;

    @FXML
    private TextField tf_username;


    @FXML
    public void signIn(ActionEvent event) throws IOException {

        try (Socket socket = new Socket("localhost", 1234)) {
            // writing to server
            PrintWriter out = new PrintWriter(
                    socket.getOutputStream(), true);

            // reading from server
            BufferedReader in
                    = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));

            // object of scanner class
            Scanner sc = new Scanner(System.in);
            String line = null;
            Path path = Paths.get("src/main/resources/Info/AdminLogin.txt");
            //Counts number of line in text file
            long count = Files.lines(path).count();

            // read each line
            for (int i = 0; i < count; i++)
            {
                String lines = Files.readAllLines(path).get(i);
                if(!lines.trim().equals(""))
                {
                    String[] profile = lines.split(",");

                    String name = profile[0];
                    String password = profile[1];

                    //Email Matched!
                    if(name.trim().equals(tf_username.getText())){ //Note trim() method remove space from front and behind of string if there is any
                        //Now checking if password match
                        if(password.trim().equals(password_field.getText())){
                            String username = tf_username.getText();
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminDashboard.fxml"));
                            Object root = loader.load();
                            AdminDashboardController adminDashboardController = loader.getController();
                            adminDashboardController.displayName(username);
                            System.out.println("Admin Login Successful");

                            //Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
                            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            Scene scene = new Scene((Parent) root);
                            stage.setScene(scene);
                            stage.show();
                        }
                    }

                }
            }

            // closing the scanner object
            sc.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onClickStudentLogin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("LogInPage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}

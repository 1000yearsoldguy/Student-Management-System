package com.example.sms;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class LogInPageController{

    @FXML
    private Button btn_signIn;

    @FXML
    private PasswordField password_field;

    @FXML
    private TextField tf_username;

    @FXML
    private Label wrongInput;


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
            Path path = Paths.get("src/main/resources/Info/Login.txt");
            //Counts number of line in text file
            long count = Files.lines(path).count();
            /// read each line
            for (int i = 0; i < count; i++)
            {
                String lines = Files.readAllLines(path).get(i);
                if(!lines.trim().equals(""))
                {
                    //According to format Name, Email, Password, Age, Gender
                    String[] profile = lines.split(",");

                    String name = profile[0];
                    String password = profile[1];

                    //Email Matched!
                    if(name.trim().equals(tf_username.getText())){ //Note trim() method remove space from front and behind of string if there is any
                        //Now checking if password match
                        if(password.trim().equals(password_field.getText())){
                            String username = tf_username.getText();
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
                            Object root = loader.load();
                            DashboardController dashboardController = loader.getController();
                            dashboardController.displayName(username);
                            System.out.println("Student Login Successful\t"+profile[0]);

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
    void onClickAdminLogin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AdminLoginPage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void switchToSignUP(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SignUP.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}



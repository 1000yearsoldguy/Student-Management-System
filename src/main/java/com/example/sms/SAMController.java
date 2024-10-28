package com.example.sms;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class SAMController {

    @FXML
    private Label Show;

    @FXML
    private TextField tf_FindStudent;

    @FXML
    private TextField tf_pass;

    @FXML
    private TextField tf_id;

    public String foundData;


    @FXML
    void ConfirmUpdate(ActionEvent event) throws IOException {
        try (Socket socket = new Socket("localhost", 1234)) {

            // writing to server
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // reading from server
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // object of scanner class
            Scanner sc = new Scanner(System.in);
            String line = null;

            //place new code here

            String id1 = tf_id.getText();
            String pass1 = tf_pass.getText();

            BufferedWriter bw1 = new BufferedWriter(new FileWriter("src/main/resources/Info/Login.txt", true));
            bw1.write("\n"+id1 + ","+pass1+"\n");
            bw1.close();

            ArrayList<Student> studentsList = new ArrayList<>();

            System.out.println("Saved Successfully");
            // closing the scanner object
            sc.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void FindStudent(ActionEvent event) throws IOException {
        try (Socket socket = new Socket("localhost", 1234)) {

            // writing to server
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // reading from server
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // object of scanner class
            Scanner sc = new Scanner(System.in);
            //String line = null;

            //place new code here
            Path path = Paths.get("src/main/resources/Info/NewStudent.txt");
            long count = Files.lines(path).count();
            boolean found = false;

            ArrayList<String> allLines = new ArrayList<>();
            for(int i=0; i<count; i++) allLines.add(Files.readAllLines(Path.of("src/main/resources/Info/NewStudent.txt")).get(i));

            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/Info/NewStudent.txt"));
            for(String line : allLines){
                if(line.contains(tf_FindStudent.getText())){
                    found = true;
                    foundData = line;
                    continue;
                }
                bufferedReader.readLine();
            }
            bufferedReader.close();
            if(found) Show.setText("Student Found In The File!!!");
            else Show.setText("Sorry! Student Not Found In File!!!");

            System.out.println("Login Successful");
            // closing the scanner object
            sc.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void backToDashBoard(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AdminDashboard.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void getfoundData(String foundData){
        String[] parts = foundData.split(",");
        tf_id.setText(parts[0]);
    }

    @FXML
    void getData(ActionEvent event) {
        getfoundData(foundData);
    }
}

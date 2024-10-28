package com.example.sms;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.time.LocalDate;
import java.util.*;

public class AddStudentController {

    @FXML
    private Button backButton;
    @FXML
    private TextField nametxtField;

    @FXML
    private DatePicker datepicker1;

    @FXML
    private TextField idtxtField;

    @FXML
    private TextField agetxtField;

    @FXML
    private TextField classtxtField;

    @FXML
    private Label wrongInput;
    @FXML
    private TextFlow tf_show;

    static class sortAgeWise implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            if (o1.age < o2.age) return -1;
            if (o2.age < o1.age) return -1;
            else return 0;
        }
    }
    ArrayList<Student> studentsList = new ArrayList<>();
    @FXML
    void saveStudentAction(ActionEvent event) throws IOException {
        try (Socket socket = new Socket("localhost", 1234)) {

            // writing to server
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // reading from server
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // object of scanner class
            Scanner sc = new Scanner(System.in);
            String line = null;

            //place new code here
            String name = nametxtField.getText();
            String id = idtxtField.getText();
            LocalDate dob = LocalDate.parse(String.valueOf(datepicker1.getValue()));
            int classes = Integer.parseInt(classtxtField.getText());
            int age = Integer.parseInt(agetxtField.getText());


            studentsList.add(new Student(name, id, dob, age, classes));

            Text txt = new Text("New Student Added : " + id + ", " + name + ", " + classes + ", " + age + ", " + dob + "\n");
            tf_show.getChildren().add(txt);

            idtxtField.setText("");
            nametxtField.setText("");
            classtxtField.setText("");
            agetxtField.setText("");
            datepicker1.setValue(null);

            Collections.sort(studentsList, new sortAgeWise());

            BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/resources/Info/NewStudent.txt", true));
            for(Student person : studentsList) bw.write(person.id + ","+person.name+","+ person.classes+","+person.age+","+person.dob+"\n");
            bw.close();

            System.out.println("Add Student Successful");
            // closing the scanner object
            sc.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void backToHome(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AdminDashboard.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }



       /* BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\University\\6th Trimester\\AOOP - Class Materials\\OfflineAssignment\\src\\main\\resources\\Files\\NewStudent.txt", true ));
        for(Student person : studentsList) bw.write("Student ID: "+person.id + "\n"+"Student Name: "+ person.name+"\n"+"Student Class: "+person.classes+"\n"+"Student Age: "+person.age+"\n"+"Date Of Birth: "+person.dob+"\n\n");
        bw.close();
        //if(name.equals("") && id.equals("") && dateofBirth.equals("") && Objects.equals(classes, "") && Objects.equals(age, "")) return;


        */

}


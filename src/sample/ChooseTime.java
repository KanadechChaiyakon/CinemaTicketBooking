package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;

public class ChooseTime {

    private Loginuser user;
    private String username;
    private String name;
    private String movie;

    @FXML
    private Button Th1, Th2, Th3, Th4, Back;

    @FXML
    private Label description;

    @FXML
    public void initialize(){
        try {
            FileReader fileReader = new FileReader("CurrentUser.csv");
            BufferedReader reader = new BufferedReader(fileReader);
            String line = null;
            while ((line = reader.readLine()) != null){
                String[] data = line.split(",");
                name = data[0];
                username = data[1];
                movie = data[2];
            }
        }
        catch (IOException x){
            System.err.println(x.getMessage());
        }
    }

    @FXML
    public void handleGoTh1OnAction(ActionEvent event) throws IOException {
        Parent loader = FXMLLoader.load(getClass().getResource("Theater1.fxml"));
        Scene scene = new Scene(loader);
        Stage stage = (Stage) Th1.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    public void handleGoTh2OnAction(ActionEvent event) throws IOException {
        Parent loader = FXMLLoader.load(getClass().getResource("Theater2.fxml"));
        Scene scene = new Scene(loader);
        Stage stage = (Stage) Th2.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    public void handleGoTh3OnAction(ActionEvent event) throws IOException {
        Parent loader = FXMLLoader.load(getClass().getResource("Theater3.fxml"));
        Scene scene = new Scene(loader);
        Stage stage = (Stage) Th3.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    public void handleGoTh4OnAction(ActionEvent event) throws IOException {
        Parent loader = FXMLLoader.load(getClass().getResource("Theater4.fxml"));
        Scene scene = new Scene(loader);
        Stage stage = (Stage) Th4.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    public void handleGoBackOnAction(ActionEvent event) throws IOException {
        Parent loader = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene scene = new Scene(loader);
        Stage stage = (Stage) Back.getScene().getWindow();
        stage.setScene(scene);
    }
}

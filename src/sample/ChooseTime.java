package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ChooseTime {

    @FXML
    private Button Back;

    @FXML
    private Button Th1;

    @FXML
    private Button Th2;

    @FXML
    private Button Th3;

    @FXML
    private Button Th4;

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

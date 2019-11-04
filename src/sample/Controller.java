package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class Controller {

    private Loginuser loginuser;
    private ArrayList<String> user;
    private String username;
    private String name;

    @FXML
    private Button buy1, buy2, buy3, buy4, logout;

    @FXML
    private Label showusername;

    @FXML
    public void initialize(){
        try {
            FileReader fileReader = new FileReader("CurrentUser.csv");
            BufferedReader reader = new BufferedReader(fileReader);
            String line = null;
            while((line = reader.readLine()) != null ){
                String[] data = line.split(",");
                this.name = data[0];
                this.username = data[1];
                showusername.setText(data[1]);
            }
        }
        catch (IOException x){
            System.err.println(x.getMessage());
        }
    }

    @FXML
    public void Selectmovie(String movie){
        try{
            FileWriter fileWriter = new FileWriter("Currentuser.csv");
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write(name+","+username+","+movie);
        }
        catch (IOException x){
            System.err.println(x.getMessage());
        }

    }

    @FXML
    public void handleLogoutOnAction(ActionEvent event) throws IOException {
        Parent loader = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(loader);
        Stage stage = (Stage) logout.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    public void handleGobuy1OnAction(ActionEvent event) throws IOException {
        Parent loader = FXMLLoader.load(getClass().getResource("ChooseTime.fxml"));
        Scene scene = new Scene(loader);
        Stage stage = (Stage) buy1.getScene().getWindow();
        Selectmovie("Antman and The Wasp");
        stage.setScene(scene);
    }

    @FXML
    public void handleGobuy2OnAction(ActionEvent event) throws IOException {
        Parent loader = FXMLLoader.load(getClass().getResource("ChooseTime.fxml"));
        Scene scene = new Scene(loader);
        Stage stage = (Stage) buy2.getScene().getWindow();
        Selectmovie("PointBreak");
        stage.setScene(scene);
    }

    @FXML
    public void handleGobuy3OnAction(ActionEvent event) throws IOException {
        Parent loader = FXMLLoader.load(getClass().getResource("ChooseTime.fxml"));
        Scene scene = new Scene(loader);
        Stage stage = (Stage) buy3.getScene().getWindow();
        Selectmovie("Mission Impossible:Fallout");
        stage.setScene(scene);
    }

    @FXML
    public void handleGobuy4OnAction(ActionEvent event) throws IOException {
        Parent loader = FXMLLoader.load(getClass().getResource("ChooseTime.fxml"));
        Scene scene = new Scene(loader);
        Stage stage = (Stage) buy4.getScene().getWindow();
        Selectmovie("Begin Again");
        stage.setScene(scene);
    }

}


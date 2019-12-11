package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class Login {

    private ArrayList<Userdata> userdata;

    @FXML
    private Button loginbtn, registerbtn, profile;

    @FXML
    private TextField username, password;

    @FXML
    private Label noregist, incorrectpassword, noinput;

    public void initialize(){
        File file = new File("Userdata.csv");
        File currentuser = new File("Currentuser.csv");
        try {
            if(!file.exists()){
                file.createNewFile();
                FileWriter fileWriter = new FileWriter("Userdata.csv");
                BufferedWriter writer = new BufferedWriter(fileWriter);
                writer.write("admin@gamail.com,admin,admin,123");
                writer.newLine();
                writer.flush();
                writer.write("kanadech.c@ku.th,big,papergun,123456");
                writer.newLine();
                writer.flush();
                if (writer != null){
                    writer.close();
                }
            }
            if(!currentuser.exists()){
                currentuser.createNewFile();
            }
        }
        catch (IOException x){
            System.err.println(x.getMessage());
        }

    }

    public void handleGoLoginOnAction(ActionEvent event) throws IOException{

        boolean checkpassword = true;

        noregist.setOpacity(0);
        noinput.setOpacity(0);
        incorrectpassword.setOpacity(0);

        if(username.getText().equals("") || password.getText().equals("")){
            noinput.setOpacity(1);
        }
        else {
            try {
                FileReader file = new FileReader("Userdata.csv");
                BufferedReader reader = new BufferedReader(file);
                String line = null;
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split(",");
                    if (username.getText().equals(data[2])) {
                        if (password.getText().equals(data[3])) {
                            Userdata loginuser = new Userdata(data[0],data[1],data[2],data[3]);
                            try {
                                FileWriter fileWriter = new FileWriter("CurrentUser.csv");
                                BufferedWriter writer = new BufferedWriter(fileWriter);
                                writer.write(data[1]+","+data[2]);
                                writer.newLine();
                                writer.flush();
                                if(writer != null){
                                    writer.close();
                                }
                            }
                            catch (IOException x){
                                System.err.println(x.getMessage());
                            }
                            Parent loader = FXMLLoader.load(getClass().getResource("sample.fxml"));
                            Scene scene = new Scene(loader);
                            Stage stage = (Stage) loginbtn.getScene().getWindow();
                            stage.setScene(scene);
                        }
                        else if (!password.getText().equals(data[3])){
                            checkpassword = false;
                            incorrectpassword.setOpacity(1);
                        }
                    }
                }
                if (checkpassword)
                    noregist.setOpacity(1);
            } catch (IOException x) {
                System.err.println(x.getMessage());
            }
        }

    }

    @FXML
    public void handleGoRegisterOnAction(ActionEvent event) throws IOException {
        Parent loader = FXMLLoader.load(getClass().getResource("Register.fxml"));
        Scene scene = new Scene(loader);
        Stage stage = (Stage) registerbtn.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    public void handleGoProfileOnAction(ActionEvent event) throws IOException {
        Parent loader = FXMLLoader.load(getClass().getResource("profile.fxml"));
        Scene scene = new Scene(loader);
        Stage stage = (Stage) profile.getScene().getWindow();
        stage.setScene(scene);
    }
}

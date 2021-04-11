package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class Register {

    private Userdata newuser;
    private String username;
    private String password;
    private ArrayList<Userdata> userdata;

    @FXML
    private Button back, register;

    @FXML
    private TextField addusername, addemail, addname;

    @FXML
    private PasswordField addpassword, addrepassword;

    @FXML
    private Label Usernameused, Passwordnotmatch, noinput;

    public void initialize(){

        userdata = new ArrayList<Userdata>();

        try{
            FileReader file = new FileReader("Userdata.csv");
            BufferedReader reader = new BufferedReader(file);
            String line = null;
            while((line = reader.readLine()) != null){
                String[] data = line.split(",");
                userdata.add(new Userdata(data[0],data[1],data[2],data[3]));
            }
        }
        catch (IOException x){
            System.err.println(x.getMessage());
        }
    }

    public boolean checkusername(String username){
        try {
            FileReader file = new FileReader("Userdata.csv");
            BufferedReader reader = new BufferedReader(file);
            String line = null;
            while ((line = reader.readLine()) != null){
                String[] data = line.split(",");
                if(username.equals(data[2])){
                    return true;
                }
            }
        }
        catch (IOException x){
            System.err.println(x.getMessage());
        }
        return false;
    }

    @FXML
    public void handleGoBackOnAction(ActionEvent event) throws IOException {
        Parent loader = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(loader);
        Stage stage = (Stage) back.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    public void handleRegisterOnAction(ActionEvent event) throws IOException {

        if (addemail.getText()=="" || addname.getText()=="" || addusername.getText()=="" || addpassword.getText()=="" || addrepassword.getText()==""){
            noinput.setOpacity(1);
        }
        else if (checkusername(addusername.getText())) {
            Usernameused.setOpacity(1);
        } else if (!addpassword.getText().equals(addrepassword.getText())) {
            Passwordnotmatch.setOpacity(1);
        } else {
            try {
                FileWriter file = new FileWriter("Userdata.csv",true);
                BufferedWriter writer = new BufferedWriter(file);
                writer.write(addemail.getText()+","+addname.getText()+","+addusername.getText() + "," + addpassword.getText());
                writer.newLine();
                writer.flush();
                if (writer != null){
                    writer.close();
                }
            } catch (IOException x) {
                System.err.println(x.getMessage());
            }
            Parent loader = FXMLLoader.load(getClass().getResource("Login.fxml"));
            Scene scene = new Scene(loader);
            Stage stage = (Stage) register.getScene().getWindow();
            stage.setScene(scene);
        }




    }


}



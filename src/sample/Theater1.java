package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Theater1 {

    private String name;
    private String username;
    private String movie;
    private String theater;
    private String time;
    private ArrayList<String> chairclick;
    private int totalmoney;


    @FXML
    private Button Back, confirm, cancle;

    @FXML
    private Label total;

    @FXML
    private ImageView a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14,b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,d1,d2,d3,d4,d5,d6,d7,d8,d9,d10,d11,d12,d13,d14;

    @FXML
    private Button a1btn,a2btn,a3btn,a4btn,a5btn,a6btn,a7btn,a8btn,a9btn,a10btn,a11btn,a12btn,a13btn,a14btn,b1btn,b2btn,b3btn,b4btn,b5btn,b6btn,b7btn,b8btn,b9btn,b10btn,b11btn,b12btn,b13btn,b14btn,c1btn,c2btn,c3btn,c4btn,c5btn,c6btn,c7btn,c8btn,c9btn,c10btn,c11btn,c12btn,c13btn,c14btn,d1btn,d2btn,d3btn,d4btn,d5btn,d6btn,d7btn,d8btn,d9btn,d10btn,d11btn,d12btn,d13btn,d14btn;

    @FXML
    final Button[] vip = {b1btn,b2btn,b3btn,b4btn,b5btn,b6btn,b7btn,b8btn,b9btn,b10btn,b11btn,b12btn,b13btn,b14btn};

    @FXML
    final Button[] normal = {c1btn,c2btn,c3btn,c4btn,c5btn,c6btn,c7btn,c8btn,c9btn,c10btn,c11btn,c12btn,c13btn,c14btn,d1btn,d2btn,d3btn,d4btn,d5btn,d6btn,d7btn,d8btn,d9btn,d10btn,d11btn,d12btn,d13btn,d14btn};

    @FXML
    final Button[] honeymoon ={a1btn,a2btn,a3btn,a4btn,a5btn,a6btn,a7btn,a8btn,a9btn,a10btn,a11btn,a12btn,a13btn,a14btn};

    @FXML
    private ImageView[] imageViews = {a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14,b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,d1,d2,d3,d4,d5,d6,d7,d8,d9,d10,d11,d12,d13,d14};

    @FXML
    public void initialize(){
        File file = new File("BookingData.csv");
        try{
            FileReader fileReader = new FileReader("CurrentUser.csv");
            BufferedReader reader = new BufferedReader(fileReader);
            String line = null;
            while ((line = reader.readLine()) != null){
                String[] data = line.split(",");
                this.name = data[0];
                this.username = data[1];
                this.movie = data[2];
                this.theater = data[3];
                this.time = data[4];
            }
            d1btn.setOpacity(1);
            d1btn.setStyle("-fx-background-image: url('/images/Normal.png')");
        }
        catch (IOException x){
            System.err.println(x.getMessage());
        }
        try {
            Button[] vip = {b1btn,b2btn,b3btn,b4btn,b5btn,b6btn,b7btn,b8btn,b9btn,b10btn,b11btn,b12btn,b13btn,b14btn};
            Button[] normal = {c1btn,c2btn,c3btn,c4btn,c5btn,c6btn,c7btn,c8btn,c9btn,c10btn,c11btn,c12btn,c13btn,c14btn,d1btn,d2btn,d3btn,d4btn,d5btn,d6btn,d7btn,d8btn,d9btn,d10btn,d11btn,d12btn,d13btn,d14btn};
            Button[] honeymoon ={a1btn,a2btn,a3btn,a4btn,a5btn,a6btn,a7btn,a8btn,a9btn,a10btn,a11btn,a12btn,a13btn,a14btn};
            if(!file.exists()){
                file.createNewFile();
            }
            FileReader fileReader = new FileReader("BookingData.csv");
            BufferedReader reader = new BufferedReader(fileReader);
            String line = null;
            while ((line = reader.readLine()) != null){
                String[] data = line.split(",");
                String moviecheck = data[2];
                String theatercheck = data[3];
                String bookedchairid = data[5];
                if(moviecheck.equals(movie) && theatercheck.equals(theater)){
                    for(int i = 0; i<28; i++){
                        if(bookedchairid.equals(normal[i].getText())){
                            normal[i].setStyle("-fx-background-image: url('/images/BookedChairs.png')");
                            normal[i].setOpacity(1);
                            normal[i].setDisable(true);
                        }
                    }
                    for(int i = 0; i<14; i++){
                        if(bookedchairid.equals(vip[i].getText())){
                            vip[i].setStyle("-fx-background-image: url('/images/BookedChairs.png')");
                            vip[i].setOpacity(1);
                            vip[i].setDisable(true);
                        }
                    }
                    for(int i = 0; i<14; i++){
                        if(bookedchairid.equals(honeymoon[i].getText())){
                            honeymoon[i].setStyle("-fx-background-image: url('/images/BookedChairs.png')");
                            honeymoon[i].setOpacity(1);
                            honeymoon[i].setDisable(true);
                        }
                    }
                }
            }
        }
        catch (IOException x){
            System.err.println(x.getMessage());
        }

    }

    @FXML
    public void handleClickChairOnAction(ActionEvent event) throws IOException{
        Button x = (Button)event.getSource();
        if(x.getStyle() == null ){
            x.setStyle("-fx-background-image: url('/images/click.png')");
            chairclick.add(x.getText());
            for(int i =0; i<28; i++){
                if(x.getText().equals(normal[i].getText()))
                    totalmoney += 120;
            }
            for(int i =0; i<14; i++){
                if(x.getText().equals(vip[i].getText()))
                    totalmoney += 200;
            }
            for(int i =0; i<28; i++){
                if(x.getText().equals(honeymoon[i].getText()))
                    totalmoney += 300;
            }
            chairclick.add(x.getId());
            total.setText("Total "+chairclick.size()+" Ticket Amount: "+totalmoney+" baht");
        }
        else if(x.getStyle() == "-fx-background-image: url('/images/click.png')" ){
            x.setOpacity(0);
            x.setStyle(null);
            chairclick.remove(x.getText());
            for(int i =0; i<28; i++){
                if(x.getText().equals(normal[i].getText()))
                    totalmoney -= 120;
            }
            for(int i =0; i<14; i++){
                if(x.getText().equals(vip[i].getText()))
                    totalmoney -= 200;
            }
            for(int i =0; i<28; i++){
                if(x.getText().equals(honeymoon[i].getText()))
                    totalmoney -= 300;
            }
            chairclick.remove(x.getId());
            total.setText("Total "+chairclick.size()+" Ticket Amount: "+totalmoney+" baht");
        }

    }

    @FXML
    public void handleGoBackOnAction(ActionEvent event) throws IOException {
        Parent loader = FXMLLoader.load(getClass().getResource("ChooseTime.fxml"));
        Scene scene = new Scene(loader);
        Stage stage = (Stage) Back.getScene().getWindow();
        stage.setScene(scene);
    }
}

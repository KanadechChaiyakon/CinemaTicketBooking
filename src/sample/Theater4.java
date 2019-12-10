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

public class Theater4 {

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
    private Button a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14,a15,a16,b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,d1,d2,d3,d4,d5,d6,d7,d8,d9,d10,d11,d12,d13,d14,d15,d16,e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11,e12,e13,e14,e15,e16,f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f11,f12,f13,f14,f15,f16;

    public Theater4(){
        this.totalmoney = 0;
        this.chairclick = new ArrayList<>();
    }

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
        }
        catch (IOException x){
            System.err.println(x.getMessage());
        }
        try {
            Button[] normal = {a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14,a15,a16,b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,d1,d2,d3,d4,d5,d6,d7,d8,d9,d10,d11,d12,d13,d14,d15,d16,e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11,e12,e13,e14,e15,e16,f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f11,f12,f13,f14,f15,f16};
            for(int i = 0; i<96; i++){
                normal[i].setStyle("-fx-background-image: url('/images/Normal.png')");
            }
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
                    for(int i = 0; i<96; i++){
                        if(bookedchairid.equals(normal[i].getText())){
                            normal[i].setStyle("-fx-background-image: url('/images/BookedChairs.png')");
                            normal[i].setOpacity(1);
                            normal[i].setDisable(true);
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
        Button[] normal = {a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14,a15,a16,b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,d1,d2,d3,d4,d5,d6,d7,d8,d9,d10,d11,d12,d13,d14,d15,d16,e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11,e12,e13,e14,e15,e16,f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f11,f12,f13,f14,f15,f16};
        Button x = (Button)event.getSource();
        if(x.getStyle() == "-fx-background-image: url('/images/Normal.png')" || x.getStyle() == "-fx-background-image: url('/images/VIP.png')" || x.getStyle() == "-fx-background-image: url('/images/Honeymoon.png')" ){
            x.setStyle("-fx-background-image: url('/images/NormalClick.png')");
            for(int i =0; i<96; i++){
                if(x.getId().equals(normal[i].getId())){
                    totalmoney += 120;
                }
            }
            chairclick.add(x.getId());
            total.setText("Total "+chairclick.size()+" Ticket Amount: "+totalmoney+" baht");
        }
        else if(x.getStyle() == "-fx-background-image: url('/images/NormalClick.png')" ){
            for(int i =0; i<96; i++){
                if(x.getId().equals(normal[i].getId())){
                    totalmoney -= 120;
                    x.setStyle("-fx-background-image: url('/images/Normal.png')");
                }
            }
            chairclick.remove(x.getId());
            total.setText("Total "+chairclick.size()+" Ticket Amount: "+totalmoney+" baht");
        }

    }

    @FXML
    public void handleConfirmOnAction(ActionEvent event) throws IOException{
        Button[] chair = {a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14,a15,a16,b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,d1,d2,d3,d4,d5,d6,d7,d8,d9,d10,d11,d12,d13,d14,d15,d16,e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11,e12,e13,e14,e15,e16,f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f11,f12,f13,f14,f15,f16};
        try{
            FileWriter fileWriter = new FileWriter("BookingData.csv",true);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            for(int i = 0; i<chairclick.size(); i++){
                for(int j =0; j<96; j++){
                    if(chairclick.get(i).equals(chair[j].getId())){
                        chair[j].setStyle("-fx-background-image: url('/images/BookedChairs.png')");
                        chair[i].setOpacity(1);
                        chair[i].setDisable(true);
                    }
                }
                writer.write(name+","+username+","+movie+","+theater+","+time+","+chairclick.get(i));
                writer.newLine();
                writer.flush();
            }
            if(writer != null){
                writer.close();
            }
        }
        catch (IOException x){
            System.err.println(x.getMessage());
        }
        chairclick.clear();
        totalmoney = 0;
        total.setText("Total "+chairclick.size()+" Ticket Amount: "+totalmoney+" baht");

    }

    @FXML
    public void handleCancleOnAction(ActionEvent event) throws IOException{
        Button[] normal = {a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14,a15,a16,b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,d1,d2,d3,d4,d5,d6,d7,d8,d9,d10,d11,d12,d13,d14,d15,d16,e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11,e12,e13,e14,e15,e16,f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f11,f12,f13,f14,f15,f16};
        Button[] chair = {a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14,a15,a16,b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,d1,d2,d3,d4,d5,d6,d7,d8,d9,d10,d11,d12,d13,d14,d15,d16,e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11,e12,e13,e14,e15,e16,f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f11,f12,f13,f14,f15,f16};
        for(int i = 0; i<96 ; i++){
            if(chair[i].getStyle() == "-fx-background-image: url('/images/NormalClick.png')" ){
                for(int j =0; j<96; j++){
                    if(chair[i].getId().equals(normal[j].getId())){
                        chair[i].setStyle("-fx-background-image: url('/images/Normal.png')");
                    }
                }
            }
        }
        chairclick.clear();
        totalmoney = 0;
        total.setText("Total "+chairclick.size()+" Ticket Amount: "+totalmoney+" baht");
    }

    @FXML
    public void handleGoBackOnAction(ActionEvent event) throws IOException {
        Parent loader = FXMLLoader.load(getClass().getResource("ChooseTime.fxml"));
        Scene scene = new Scene(loader);
        Stage stage = (Stage) Back.getScene().getWindow();
        stage.setScene(scene);
    }
}

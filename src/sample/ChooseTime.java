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

import java.io.*;

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
            while((line = reader.readLine()) != null ){
                String[] data = line.split(",");
                this.name = data[0];
                this.username = data[1];
                this.movie = data[2];
            }
        }
        catch (IOException x){
            System.err.println(x.getMessage());
        }
        if(movie.equals("Antman2")){
            description.setText("Two years after Scott Lang was placed under house arrest due to his involvement with the Avengers, in violation of the Sokovia Accords,\n" +
                    "Hank Pym and his daughter Hope van Dyne briefly manage to open a tunnel to the quantum realm. They believe Pym's wife Janet van Dyne \n" +
                    "might be trapped there after shrinking to sub-atomic levels in 1987. When he had previously visited the quantum realm, \n" +
                    "Lang had unknowingly become quantumly entangled with Janet, and now he receives an apparent message from her");
            Th1.setText("20.00");
            Th2.setText("20.00");
            Th3.setText("20.00");
            Th4.setText("20.00");
        }
        else if(movie.equals("PointBreak")){
            description.setText("Extreme sport athlete Johnny Utah (Luke Bracey), and his friend Jeff (Max Thieriot), are traversing a steep ridgeline on motorbikes.\n" +
                    "The run ends with a jump onto a lone stone column, where Jeff overshoots the landing and falls to his death.");
            Th1.setText("16.00");
            Th2.setText("16.00");
            Th3.setText("16.00");
            Th4.setText("16.00");
        }
        else if (movie.equals("MissionImpossible")){
            description.setText("Two years after Solomon Lane's capture, the remnants of his organization, the Syndicate, have reorganized as a terrorist group \n" +
                    "called the Apostles. IMF agent Ethan Hunt is assigned to buy three stolen plutonium cores in Berlin from Eastern European gangsters \n" +
                    "before the Apostles can. He is joined by Benji Dunn and Luther Stickell for the mission, but the team fails when Stickell is taken \n" +
                    "hostage and Hunt's attempt to save him allows the Apostles to make off with the plutonium. The team later captures nuclear weapons \n" +
                    "expert Nils Delbruuk, who designed nuclear bombs for the Apostles' client, an extremist named John Lark. With the use of a fake broadcast\n" +
                    ", they managed to trick him into handing over a phone that he used to communicate with Lark.");
            Th1.setText("10.00");
            Th2.setText("10.00");
            Th3.setText("10.00");
            Th4.setText("10.00");
        }
        else if(movie.equals("BeginAgain")){
            description.setText("Dan Mulligan (Mark Ruffalo) is a formerly successful record label executive living in New York City who is estranged from his wife Miriam (Catherine Keener) and \n" +
                    "struggling to keep up with the changing music industry. After being fired from his job, he goes on a drinking binge which leads him to a bar in the Lower East Side\n" +
                    "where he encounters Gretta James (Keira Knightley). Gretta is a young and fiercely independent songwriter who has just broken up with her long-time boyfriend\n" +
                    " and songwriting partner Dave Kohl (Adam Levine), a newly successful musician who had an affair with one of his producers' assistants. Captivated by \n" +
                    "Gretta's music, Dan offers to sign her to his former record label, and although she initially refuses she reconsiders the offer and agrees.");
            Th1.setText("12.00");
            Th2.setText("12.00");
            Th3.setText("12.00");
            Th4.setText("12.00");
        }
    }

    public void SelectTheater(String theater){
        try {
            FileWriter fileWriter = new FileWriter("CurrentUser.csv");
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write(name+","+username+","+movie+","+theater+","+Th1.getText());
            writer.newLine();
            writer.flush();
            if(writer != null){
                writer.close();
            }
        }
        catch (IOException x){
            System.err.println(x.getMessage());
        }
    }

    @FXML
    public void handleGoTh1OnAction(ActionEvent event) throws IOException {
        SelectTheater("Th1");
        Parent loader = FXMLLoader.load(getClass().getResource("Theater1.fxml"));
        Scene scene = new Scene(loader);
        Stage stage = (Stage) Th1.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    public void handleGoTh2OnAction(ActionEvent event) throws IOException {
        SelectTheater("Th2");
        Parent loader = FXMLLoader.load(getClass().getResource("Theater2.fxml"));
        Scene scene = new Scene(loader);
        Stage stage = (Stage) Th2.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    public void handleGoTh3OnAction(ActionEvent event) throws IOException {
        SelectTheater("Th3");
        Parent loader = FXMLLoader.load(getClass().getResource("Theater3.fxml"));
        Scene scene = new Scene(loader);
        Stage stage = (Stage) Th3.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    public void handleGoTh4OnAction(ActionEvent event) throws IOException {
        SelectTheater("Th4");
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

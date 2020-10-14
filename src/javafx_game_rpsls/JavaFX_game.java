/*
 * Useful links for this project:
https://www.tutorialspoint.com/javafx/javafx_ui_controls.htm
https://www.tutorialspoint.com/javafx/javafx_images.htm
https://www.tutorialspoint.com/how-to-add-an-image-to-a-button-action-in-javafx
https://www.tutorialspoint.com/javafx/javafx_layout_panes.htm
 */
package javafx_game_rpsls;

import java.io.FileInputStream;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;

/**
 * Name: Muhaddatha Abdulghani
 * Professor: Dr. John Baugh
 * Class: Java programming (CIS 296)
 * Description:
 * 
 */
public class JavaFX_game extends Application {
    
    int imageHeight = 20;
    int buttonSize = 20;
    
    private Label computerPickLabel = new Label("Computer");
    private Label playerPickLabel = new Label("Player");
    private Label gameResult = new Label();
    private Label selectOptionLabel = new Label("Please selct your weapon of choice");
    
    //Creating images
    private Image rockImage = new Image("javafx_game_rpsls/images/rock.jpg");
    ImageView rockView = new ImageView(rockImage);
    
    
//    private Image paperImage = new Image("javafx_game_rpsls/rock.jpg");
//    ImageView paperView = new ImageView(paperImage);
//    private Image scissorsImage = new Image("images/paper.jpg");
//    ImageView scissorsView = new ImageView(scissorsImage);
//    private Image lizardImage = new Image("images/scissors.jpg");
//    ImageView lizardView = new ImageView(lizardImage);
//    private Image spockImage = new Image("images/spock.jpg");
//    ImageView spockView = new ImageView(spockImage);
    
    Button rockButton = new Button("Rock");
    
    Button paperButton = new Button("Paper");
    Button scissorsButton = new Button("Scissors");
    Button lizardButton = new Button("Lizard");
    Button spockButton = new Button("Spock");
    
    
    

    @Override//start method from the Application class needs to be overridden
    public void start(Stage stage) throws Exception {
       
        //Create UI
        GridPane gridPane = new GridPane();
        gridPane.add(computerPickLabel, 0, 0);
        gridPane.add(playerPickLabel, 0, 2);
        gridPane.add(rockButton, 0, 5);
        gridPane.add(paperButton, 1, 5);
        gridPane.add(scissorsButton, 2, 5);
        gridPane.add(lizardButton, 3, 5);
        gridPane.add(spockButton, 4, 5);
        
        computerPickLabel.setAlignment(Pos.CENTER);
        playerPickLabel.setAlignment(Pos.CENTER);
        
        rockButton.setGraphic(rockView);
        
        
        Scene scene = new Scene(gridPane, 400, 500);
        stage.setTitle("Rock, paper, scissors, lizard, spock game");
        stage.setScene(scene);
        stage.show();
    }
    
    
    
    public static void main(String[] args){
        launch(args);
    }
    
    
}

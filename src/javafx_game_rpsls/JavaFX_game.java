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
import java.util.Random;

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
    private Image paperImage = new Image("javafx_game_rpsls/images/paper.jpg");
    ImageView paperView = new ImageView(paperImage);
    private Image scissorsImage = new Image("javafx_game_rpsls/images/scissors.jpg");
    ImageView scissorsView = new ImageView(scissorsImage);
    private Image lizardImage = new Image("javafx_game_rpsls/images/lizard.jpg");
    ImageView lizardView = new ImageView(lizardImage);
    private Image spockImage = new Image("javafx_game_rpsls/images/spock.jpg");
    ImageView spockView = new ImageView(spockImage);

    
    
    
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
        
        rockView.setFitHeight(80);
        rockView.setPreserveRatio(true);
        paperView.setFitHeight(80);
        paperView.setPreserveRatio(true);
        scissorsView.setFitHeight(80);
        scissorsView.setPreserveRatio(true);
        lizardView.setFitHeight(80);
        lizardView.setPreserveRatio(true);
        spockView.setFitHeight(80);
        spockView.setPreserveRatio(true);
        
        rockButton.setGraphic(rockView);
        paperButton.setGraphic(paperView);
        scissorsButton.setGraphic(scissorsView);
        lizardButton.setGraphic(lizardView);
        spockButton.setGraphic(spockView);
        
        Scene scene = new Scene(gridPane, 400, 500);
        stage.setTitle("Rock, paper, scissors, lizard, spock game");
        stage.setScene(scene);
        do{
            stage.show();
            
            
        }while(true);
        
        
        
        
    }
    
    //precondition: userPlay is a number between 0 and 4, inclusive
    //postcondition:
    //Description:
    public String play(int userPlay, boolean userWinStatus){
        
        String[] playOptions = new String[5];
        playOptions[0] = "Rock";
        playOptions[1] = "Paper";
        playOptions[2] = "Scissors";
        playOptions[3] = "Lizard";
        playOptions[4] = "Spock";
        
        int computerPlay = (int)(Math.random() * 5);
        
        //array of possible game plays. The first index represents the user's 
        //play and the second index represents
        //the computer's random play
        //The matrix summarizes the interaction between the
        //user and computer picks by looking up the index in the 
        //gameResultText array
        int[][] gameResult = {
            {0, 1, 3, 4, 7},
            {1, 0, 5, 9, 2},
            {3, 5, 0, 6, 8},
            {4, 9, 6, 0, 10},
            {7, 2, 8, 10, 0},
            
        };
        
        
        String[] gameResultText = new String[11];
        gameResultText[0] = "Tie";
        gameResultText[1] = "Paper covers Rock";
        gameResultText[2] = "Paper disproves Spock";
        gameResultText[3] = "Rock crushes Scissors";
        gameResultText[4] = "Rock crushes Lizard";
        gameResultText[5] = "Scissors cuts paper";
        gameResultText[6] = "Scissors decapitates Lizard";
        gameResultText[7] = "Spock vaporizes Rock";
        gameResultText[8] = "Spock smashes Scissors";
        gameResultText[9] = "Lizard eats Paper";
        gameResultText[10] = "Lizard poisons Spock";
        
    
        //Splitting the result of the game into array to find the name of the first weapon
        //The first weapon in an index in the gameResultText is the dominant weapon
        //So if the winner has selected this item, they win
        //The winning or losing status of the user is communicated with
        //the userWinStatus variable.
        String gamePlay = gameResultText[gameResult[userPlay][computerPlay]];
        String[] arrayOfGamePlay = gamePlay.split(" ", 2);
        
        
        //If the user picked the first weapon, he/she wins the round
        if(playOptions[userPlay] == arrayOfGamePlay[0]){
            userWinStatus = true;
        }
        
        return gamePlay;
        
    }
    
    public static void main(String[] args){
        launch(args);
    }
    
    
}

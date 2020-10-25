/*
 * Useful links for this project:
https://www.tutorialspoint.com/javafx/javafx_ui_controls.htm
https://www.tutorialspoint.com/javafx/javafx_images.htm
https://www.tutorialspoint.com/how-to-add-an-image-to-a-button-action-in-javafx
https://www.tutorialspoint.com/javafx/javafx_layout_panes.htm
 */
package javafx_game_rpsls;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import java.util.Random;



/**
 * Name: Muhaddatha Abdulghani
 * Professor: Dr. John Baugh
 * Class: Java programming (CIS 296)
 * Description: Rock, Paper, Scissors, Lizard, and Spock GUI game.
 * 
 */
public class JavaFX_game extends Application implements EventHandler<ActionEvent>{
    
    int imageHeight = 50;
    int buttonSize = 20;
    boolean debugging = true;
    static int computerPlay;
    static int userPlay;
    static int labelFontSize = 18;
    
    String[] pathsToImages = {
        "javafx_game_rpsls/images/rock.jpg", // 0 = rock
        "javafx_game_rpsls/images/paper.jpg", // 1 = paper
        "javafx_game_rpsls/images/scissors.jpg", // 2 = scissors
        "javafx_game_rpsls/images/lizard.jpg", // 3 =lizard
        "javafx_game_rpsls/images/spock.jpg" // 4 = spock
    };
    
    private final Label computerPickLabel = new Label("Computer");
    private final ImageView computerPickImageView = new ImageView();
    
    private final Label playerPickLabel = new Label("Player");
    private final ImageView userPickImageView = new ImageView();
    
    private final Label gameResult = new Label();
    private final Label selectOptionLabel = new Label("Please select your\nweapon of choice\nbelow: ");
    
    //Creating images
    private final Image rockImage = new Image(pathsToImages[0]);
    ImageView rockView = new ImageView(rockImage);
    private final Image paperImage = new Image(pathsToImages[1]);
    ImageView paperView = new ImageView(paperImage);
    private final Image scissorsImage = new Image(pathsToImages[2]);
    ImageView scissorsView = new ImageView(scissorsImage);
    private final Image lizardImage = new Image(pathsToImages[3]);
    ImageView lizardView = new ImageView(lizardImage);
    private final Image spockImage = new Image(pathsToImages[4]);
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
        gridPane.add(computerPickImageView,1 ,0 );
        gridPane.add(userPickImageView,1, 2 );
        gridPane.add(playerPickLabel, 0, 2);
        gridPane.add(rockButton, 0, 6);
        gridPane.add(paperButton, 1, 6);
        gridPane.add(scissorsButton, 2, 6);
        gridPane.add(lizardButton, 3, 6);
        gridPane.add(spockButton, 4, 6);
        gridPane.add(gameResult, 3, (int) 1.5);
        gridPane.add(selectOptionLabel, 0, 4);
        computerPickLabel.setAlignment(Pos.CENTER);
        playerPickLabel.setAlignment(Pos.CENTER);
        
        
        //seeting fonts
        computerPickLabel.setFont(new Font("Ariel", labelFontSize));
        playerPickLabel.setFont(new Font("Ariel", labelFontSize));
        selectOptionLabel.setFont(Font.font("Ariel", FontPosture.ITALIC, labelFontSize));
        gameResult.setFont(new Font("Ariel", labelFontSize));
        
        
        rockView.setFitHeight(imageHeight);
        rockView.setPreserveRatio(true);
        paperView.setFitHeight(imageHeight);
        paperView.setPreserveRatio(true);
        scissorsView.setFitHeight(imageHeight);
        scissorsView.setPreserveRatio(true);
        lizardView.setFitHeight(imageHeight);
        lizardView.setPreserveRatio(true);
        spockView.setFitHeight(imageHeight);
        spockView.setPreserveRatio(true);
        
        //test
        computerPickImageView.setFitHeight(imageHeight);
        computerPickImageView.setPreserveRatio(true);
        
        userPickImageView.setFitHeight(imageHeight);
        userPickImageView.setPreserveRatio(true);
         
        
        rockButton.setGraphic(rockView);
        paperButton.setGraphic(paperView);
        scissorsButton.setGraphic(scissorsView);
        lizardButton.setGraphic(lizardView);
        spockButton.setGraphic(spockView);
        
        rockButton.setOnAction(this);
        paperButton.setOnAction(this);
        scissorsButton.setOnAction(this);
        lizardButton.setOnAction(this);
        spockButton.setOnAction(this);
        
        
        
        Scene scene = new Scene(gridPane, 700, 400);
        stage.setTitle("Rock, Paper, Scissors, Lizard, Spock game");
        stage.setScene(scene);
        stage.show();
    }
    
    //precondition: userPlay is a number between 0 and 4, inclusive
    //postcondition: The status of the game is returned in a String called gamePlay
    //Description: This function determines the result of a round played by
    //the user and the computer.
    public String play(){
        
        String[] playOptions = new String[5];
        playOptions[0] = "Rock";
        playOptions[1] = "Paper";
        playOptions[2] = "Scissors";
        playOptions[3] = "Lizard";
        playOptions[4] = "Spock";
        
        Random randomComputerPick = new Random();
        computerPlay = randomComputerPick.nextInt(5);
        
        
        
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
        gameResultText[0] = "Tie!";
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
        
    
   
        String gamePlay = gameResultText[gameResult[userPlay][computerPlay]];       
        return gamePlay;
        
    }
    
    
    @Override
    public void handle(ActionEvent event){
        
        String[] playOptionsCopy = new String[5];
        playOptionsCopy[0] = "Rock";
        playOptionsCopy[1] = "Paper";
        playOptionsCopy[2] = "Scissors";
        playOptionsCopy[3] = "Lizard";
        playOptionsCopy[4] = "Spock";
        
        int computerOption;
        
        String gameStatus = " ";
        
        
        if(event.getSource() == rockButton){
            userPlay = 0;
        }
        else if(event.getSource() == paperButton){
            userPlay = 1;
        }
        else if(event.getSource() == scissorsButton){
            userPlay = 2;
        }
        else if(event.getSource() == lizardButton){
            userPlay = 3;
        }
        else if(event.getSource() == spockButton){
            userPlay = 4;
        }
        
        
        
        //set computer pick label graphic, user pick label graphic and game result
        
        //If the first word of the gameResult matches the user's pick, he/she wins.
        gameStatus = play();
        computerPickImageView.setImage(new Image(pathsToImages[computerPlay]));
        userPickImageView.setImage(new Image(pathsToImages[userPlay]));
        
        //If the user picked the first weapon, he/she wins the round
        String[] arrayOfGamePlay = gameStatus.split(" ", 2);
        
        if(debugging){
            System.out.println("The first word in gameStatus is: " + arrayOfGamePlay[0]);
        }
        if("Tie!".equals(gameStatus)){
            if(debugging){
                System.out.println("There is a tie");
            }
            gameResult.setText(gameStatus);
        }
        else if(playOptionsCopy[userPlay] == null ? arrayOfGamePlay[0] == null : playOptionsCopy[userPlay].equals(arrayOfGamePlay[0])){
            gameResult.setText(gameStatus + "\n You win! ");
        }
        else{
            gameResult.setText(gameStatus + "\n You lose! ");
        }
        
        if(debugging){
                System.out.println("The user played " + playOptionsCopy[userPlay] + 
                        " and the computer played " + playOptionsCopy[computerPlay] + 
                        "\n The game result is " + gameStatus);
            }
        
    }
    
    
    public static void main(String[] args){
        launch(args);
    }
    
    
}

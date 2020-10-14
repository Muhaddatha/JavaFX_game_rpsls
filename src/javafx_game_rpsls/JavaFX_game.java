/*
 * Useful links for this project:
https://www.tutorialspoint.com/javafx/javafx_ui_controls.htm
https://www.tutorialspoint.com/javafx/javafx_images.htm
https://www.tutorialspoint.com/how-to-add-an-image-to-a-button-action-in-javafx
 */
package javafx_game_rpsls;

import java.io.FileInputStream;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * Name: Muhaddatha Abdulghani
 * Professor: Dr. John Baugh
 * Class: Java programming (CIS 296)
 * Description:
 * 
 */
public class JavaFX_game extends Application {
    
    int imageHeight = 20;
    int buttonSize = 50;
    
    private Label ComputerPickLabel = new Label("Computer");
    private Label PlayerPickLabel = new Label("Player");
    private Label gameResult = new Label();
    private Label selectOptionLabel = new Label("Please selct your weapon of choice");
    
    //Creating images
    private Image rockImage = new Image("images/rock.jpg"); //need to specify path still
    ImageView rockView = new ImageView(rockImage);
    private Image paperImage = new Image("images/paper.jpg");
    ImageView paperView = new ImageView(paperImage);
    private Image scissorsImage = new Image("images/paper.jpg");
    ImageView scissorsView = new ImageView(scissorsImage);
    private Image lizardImage = new Image("images/scissors.jpg");
    ImageView lizardView = new ImageView(lizardImage);
    private Image spockImage = new Image("images/spock.jpg");
    ImageView spockView = new ImageView(spockImage);
    
    Button rockButton = new Button();
    Button paperButton = new Button();
    Button scissorsButton = new Button();
    Button lizardButton = new Button();
    Button spockButton = new Button();
    
    
    

    @Override//start method from the Application class needs to be overridden
    public void start(Stage stage) throws Exception {
       
    }
    
    
    
    public static void main(String[] args){
        launch(args);
    }
    
    
}

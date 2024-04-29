import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.*;
import java.util.*;
public class GuessingGame extends Application{
   private int randomNumber, guesses, attempt;
   
   @Override
   
   public void start(Stage stage){
      Random rand = new Random(); 
      int max = 100; // default max, 0 to 99
      randomNumber = rand.nextInt(max);
      
      guesses = 5; // default lives
      attempt = 0;
      
      // user inputed number
      TextField userInputNumber = new TextField();
      userInputNumber.setMaxWidth(200);
       
      
      
      Button submit = new Button("Submit");
      
      Text attemptText = new Text(20, 20, "Attempts: "+attempt);
      attemptText.setFont(Font.font("Arial", 30));
   
      Text msg = new Text(10, 20, "Guess the number");
      msg.setFont(Font.font("Arial", 15));
      
      // number of guesses available
      Text msgGuess = new Text(10, 20, "You have "+guesses+" guesses left");
      msgGuess.setFont(Font.font("Arial", 15));
      
      // show the max number of rand 
      Text text = new Text(10, 20, "Maximum number : "+max); 
      text.setFont(Font.font("Arial", 12));
      
      //button on click
      
      submit.setOnAction( 
         e -> {
            if(guesses > 0){
               int guess = Integer.parseInt(userInputNumber.getText());
               if(guess > randomNumber){
                  msg.setText("The number is too high!");
                  msg.setFill(Color.RED);
                  guesses -= 1;
                  msgGuess.setText("You have " + guesses + " heart/s left");
                  attempt++;
                  
               }
               else if(guess < randomNumber){
                  msg.setText("The number is too low!");
                  msg.setFill(Color.RED);
                  guesses -= 1;
                  msgGuess.setText("You have " + guesses + " guesses left");
                  attempt++;
               }
               else{
                  msg.setText("You are CORRECT!! CONGRATULATIONS!!");
                  msg.setFill(Color.GREEN);
                  randomNumber = rand.nextInt(max);
                  guesses = 5;
                  msgGuess.setText("New number generated\nYou have " + guesses + " guesses left");
                  attempt++;
               }
            }
            else{
               randomNumber = rand.nextInt(max);
               guesses = 5;
               msgGuess.setText("           GAME OVER!!!\nNote: new number is generated");
            } 
            attemptText.setText("Attempts: "+attempt);
         });
     
      
      VBox root = new VBox();
      root.setSpacing(10);
      root.setAlignment(Pos.CENTER);
   
      root.getChildren().addAll(attemptText, msgGuess, text, userInputNumber, submit, msg);
   
      Scene scene = new Scene(root, 400, 400);
      stage.setScene(scene);
      stage.setTitle("Emmanuel A. Braza");
      stage.show();
   }
   
   
   public static void main(String[] args){
      launch(args);
   }
  
}

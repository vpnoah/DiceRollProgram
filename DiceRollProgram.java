import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.paint.*;
import javafx.scene.Scene;
import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.image.*;
import java.io.*;
import javafx.event.*;
import javafx.scene.canvas.*;
import java.util.*;
import javafx.collections.*;

public class DiceRollProgram extends Application{

   BorderPane bp = new BorderPane(); //pane that will be the root of the scene
   
   int result = 0; //dice result
   
   Label l1 = new Label("");

   public static void main(String args[]){
   
      launch(args);
   
   }
   
   public void start(Stage stage){
   
   VBox top = new VBox(); //creates the Vbox for the top that will hold the label
   l1.setText("Current Dice" + "\n" + "    Result: " + result);
   top.getChildren().add(l1);
   top.setAlignment(Pos.CENTER);
   bp.setTop(top);
   
   HBox left = new HBox(); //creates the hbox for the left part of the border pane
   
   VBox left1 = new VBox(); //first vbox that will go in the left hbox
   
   for(int i=2; i<6; i++){ //adds buttons to the first vbox
      Button b = new Button("" + i*2);
      b.setPrefSize(75,75);
      left1.getChildren().add(b);
      b.setOnAction(new ButtonListener());
   }
   
   VBox left2 = new VBox(); //second vbox that will go in the left hbox

   Button b1 = new Button("12"); //creates buttons for second vbox
   b1.setPrefSize(75,75);
   Button b2 = new Button("20");
   b2.setPrefSize(75,75);
   Button b3 = new Button("100");
   b3.setPrefSize(75,75);
   
   left2.getChildren().add(b1); //adds buttons to second vbox
   left2.getChildren().add(b2);
   left2.getChildren().add(b3);
   
   b1.setOnAction(new ButtonListener());
   b2.setOnAction(new ButtonListener());
   b3.setOnAction(new ButtonListener());
   
   left.getChildren().add(left1); //adds the vboxs to the hbox
   left.getChildren().add(left2);
   
   bp.setLeft(left); //puts the hbox in the left part of the borderpane
   
   left.setSpacing(5); //sets spacing so it looks more like the example
   left1.setSpacing(5);
   left2.setSpacing(5);
        
   Scene x = new Scene(bp,500,400);
   stage.setScene(x);
   stage.setTitle("Dice Roll");
   stage.show();
   
   
   }

   public class ButtonListener implements EventHandler<ActionEvent>{
   
      public void handle(ActionEvent e){
      
         Button b = (Button)(e.getSource());
         String x = b.getText();
         
         int z = Integer.parseInt(x);
         
         Random gen = new Random();
         
         result = gen.nextInt(z) + 1;
         
         l1.setText("Current Dice" + "\n" + "    Result: " + result);
      
      }
   
   }



}
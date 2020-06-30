/*
  Author:  Chad Lister
  Date:  06/30/2020
  
  This program draws a retangle following the outline of a pentagon.  Animation pause and play originally had button control but changed because exercise 15 - animation calls for mouse control.  Play / pause on mouse click.  Rectangle also uses fade transition effect.
*/

import javafx.animation.PathTransition;
import javafx.animation.FadeTransition;
import javafx.animation.Animation;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.layout.StackPane;

public class Exercise_15_Animation extends Application {
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    // Create a pane 
    Pane pane = new Pane();

    // Create a rectangle
    Rectangle rectangle = new Rectangle(230, 240, 10, 20);
    rectangle.setFill(Color.RED);
     
    //  Create Pentagon
    Polygon pentagon = new Polygon(200, 100, 150, 150, 150, 250, 250, 250, 250, 150, 200, 100);
    pentagon.setStroke(Color.BLACK);
    pentagon.setFill(Color.WHITE);
    
    pane.getChildren().add(pentagon);
    pane.getChildren().add(rectangle);
 

    //  Create Play / Pause Buttons.
//    HBox buttonPane = new HBox();
//    Button play = new Button("PLAY");                      //  change to mouse buttons right or left
//    Button pause = new Button("PAUSE");
//    buttonPane.getChildren().addAll(play, pause);

    // Add Pentagon and rectangle to the pane
//    pane.getChildren().addAll(rectangle, buttonPane);      // button config
 //   pane.setCenter(stack);
//    pane.setBottom(buttonPane);
//    pane.getChildren().add(rectangle);
    
    // Create a path transition 
    PathTransition path = new PathTransition();
    path.setDuration(Duration.millis(8000));
    path.setPath(pentagon);
    path.setNode(rectangle);
    path.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
    path.setCycleCount(Timeline.INDEFINITE);
    path.play();    // Start Path.
    
    //  Add fade to rectangle.
    FadeTransition fade = new FadeTransition(Duration.millis(4000), rectangle);
    fade.setFromValue(1.0);
    fade.setToValue(0.1);
    fade.setCycleCount(Timeline.INDEFINITE);
    fade.play(); // Start fade.

    //  Changed to mouse button control.
    pane.setOnMouseClicked(e -> {
      
      // if paused then play or vise versa.
      if (path.getStatus() == Animation.Status.PAUSED) {
        path.play();
      }
      else {
        path.pause();
      }
      });

    // Create a scene and place it in the stage
    Scene scene = new Scene(pane, 400, 400);
    primaryStage.setTitle("Exercise 15 - Animation"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }
  
  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}
/*
  Author:  Chad Lister
  Date:  06/29/2020
  
  This class defines the pane and methods in MoveBall.
  
*/

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.layout.HBox;
//import javafx.scene.control.Button;

public class BallPane extends Pane {

  private Circle ball = new Circle(20, 180, 20);
  private HBox buttonPane = new HBox();
  private double moveX;
  private double moveY;
  private double x;
  private double y;
  private double upperBound = 0;
  private double lowerBound = 200;
  private double leftBound = 0;
  private double rightBound = 200;

  public BallPane() {

    setStyle("-fx-border-color: Black");
    ball.setFill(Color.BLUE);        //  To add contrast against scene.
    getChildren().add(ball);
    getChildren().add(buttonPane);
  
  }

  public void moveLeft() {
    moveX = ball.getCenterX() - 25;
    y = ball.getCenterY();

    moveBall(moveX, y);
    
    // Add Re-Request Focus on ball after move.
    ball.requestFocus();
        
    return;
  }

  public void moveRight() {
    moveX = ball.getCenterX() + 25;
    y = ball.getCenterY();
    
    moveBall(moveX, y);
    
    // Add Re-Request Focus on ball after move.
    ball.requestFocus();
        
    return;
  }

  public void moveUp() {
    x = ball.getCenterX();
    moveY = ball.getCenterY() - 25;

    moveBall(x, moveY);
    
    // Add Re-Request Focus on ball after move.
    ball.requestFocus();
        
    return;
  }

  public void moveDown() {
    x = ball.getCenterX();
    moveY = ball.getCenterY() + 25;

    moveBall(x, moveY);
    
    // Add Re-Request Focus on ball after move.
    ball.requestFocus();
        
    return;
  }
    
  public void moveBall(double x, double y) {
    
    upperBound = 0;
    lowerBound = 200;
    leftBound = 0;
    rightBound = 200;


    if (x >= leftBound + 20 && x <= rightBound - 20) {

        if (y >= upperBound + 20 && y <= lowerBound - 20) {
            ball.setCenterX(x);
            ball.setCenterY(y);
        }
    }
    ball.requestFocus();
    return;
  }      
}
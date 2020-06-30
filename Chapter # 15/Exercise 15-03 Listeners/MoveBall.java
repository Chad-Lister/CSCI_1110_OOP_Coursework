/*
	Author:  Chad Lister
	Date:  06/29/2020
	
	This program displays a Pane containing a ball and an HBox containing 4 buttons.  The ball moves on button click or arrow key and should check the scene boundries.
	
*/

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.geometry.Pos;

public class MoveBall extends Application {
	
	BallPane ballPane = new BallPane();

	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		
		//  Create and resister handlers for the arrow keys.
		//  Must refocus after key pressed.
		ballPane.setOnKeyPressed(e -> {
			
			if (e.getCode() == KeyCode.LEFT) {
				ballPane.moveLeft();
				ballPane.requestFocus();
			}
			if (e.getCode() == KeyCode.RIGHT) {
				ballPane.moveRight();
				ballPane.requestFocus();
			}
			if (e.getCode() == KeyCode.UP) {
				ballPane.moveUp();
				ballPane.requestFocus();
			}
			if (e.getCode() == KeyCode.DOWN) {
				ballPane.moveDown();
				ballPane.requestFocus();
			}

			ballPane.requestFocus();
		});
		
		ballPane.requestFocus();
		
		// Put buttons in an HBox to center align.
		HBox buttonPane = new HBox(5);
		buttonPane.setAlignment(Pos.CENTER);
		Button left = new Button("Left");
		Button right = new Button("Right");
		Button up = new Button("Up");
		Button down = new Button("Down");
		buttonPane.getChildren().addAll(left, right, up, down);
				
		// Create and register the handler for the button.
		left.setOnMouseClicked(e -> ballPane.moveLeft());
		right.setOnMouseClicked(e -> ballPane.moveRight());
		up.setOnMouseClicked(e -> ballPane.moveUp());
		down.setOnMouseClicked(e -> ballPane.moveDown());
		
		//  Tie to Border Pane.
		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(ballPane);
		borderPane.setBottom(buttonPane);
				
		// Create a scene and place it in the stage
		Scene scene = new Scene(borderPane);
		primaryStage.setTitle("Exercise 15 - 3 Move Balll"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
		
		
		//  Added requestFocus to Ball Pane Class.
		//  Focus on ball.
	
		ballPane.requestFocus();
	}
	/**
	 * The main method is only needed for the IDE with limited
	 * JavaFX support. Not needed for running from the command line.
	 */
	public static void main(String[] args) {
		launch(args);
	}		
}
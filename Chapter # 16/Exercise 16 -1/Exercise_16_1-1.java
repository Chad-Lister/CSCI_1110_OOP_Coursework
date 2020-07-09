/*
	Author:  Chad Lister
	Date:  06/30/2020
	
	This program uses radio buttons to change the text color and arrow buttons to move the message left or right.  Exercise 16 - 1.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.geometry.Insets;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.scene.layout.VBox;

public class Exercise_16_1 extends Application {

	// Do text.
	protected Text text = new Text(30, 30, "Programming is fun");
	
	protected BorderPane getPane() {
		
		//  Text Pane.
		Pane paneForText = new Pane();
		paneForText.getChildren().add(text);
		paneForText.setStyle("-fx-border-color: black; Size: 30");
		text.setFont((Font.font("Helvetica", 16)));
						
		//  Button Pane at bottom with left/right.
		HBox paneForButtons = new HBox(20);
		Button btLeft = new Button("<=");
		Button btRight = new Button("=>");   
		paneForButtons.getChildren().addAll(btLeft, btRight);
		paneForButtons.setAlignment(Pos.CENTER);

		//  Left / Right Handlers to move text.
		//  Calls moveText() to check border.
		
		btLeft.setOnAction(e -> moveText(0, paneForText.getWidth() - 140, text.getX() - 10));
		btRight.setOnAction(e -> moveText(0, paneForText.getWidth() - 140, text.getX() + 10));
						
		// Build top pane with color toggle buttons.
		HBox paneForRadioButtons = new HBox(5);
	//	paneForRadioButtons.setPadding(new Insets(5)); 
		RadioButton redButton = new RadioButton("Red");
		RadioButton yellowButton = new RadioButton("Yellow");
		RadioButton blackButton = new RadioButton("Black");
		RadioButton orangeButton = new RadioButton("Orange");
		RadioButton greenButton = new RadioButton("Green");
		paneForRadioButtons.getChildren().addAll(redButton, yellowButton, blackButton, orangeButton, greenButton);
		paneForRadioButtons.setAlignment(Pos.CENTER);

		//  Toggle selection group.
		ToggleGroup group = new ToggleGroup();
		redButton.setToggleGroup(group);
		yellowButton.setToggleGroup(group);
		blackButton.setToggleGroup(group);
		orangeButton.setToggleGroup(group);
		greenButton.setToggleGroup(group);
		
		// default values by example shot given.
		text.setFill(Color.ORANGE);
		orangeButton.setSelected(true);
	
		//  Toggle selection handler.  Can only be 1 button at a time.
		redButton.setOnAction(e -> {
			if (redButton.isSelected()) {
				text.setFill(Color.RED);
			}
		});
	
		yellowButton.setOnAction(e -> {
			if (yellowButton.isSelected()) {
				text.setFill(Color.YELLOW);
			}
		});

		blackButton.setOnAction(e -> {
			if (blackButton.isSelected()) {
				text.setFill(Color.BLACK);
			}
		});
		
		
		orangeButton.setOnAction(e -> {
			if (orangeButton.isSelected()) {
				text.setFill(Color.ORANGE);
			}
		});
		
		greenButton.setOnAction(e -> {
			if (greenButton.isSelected()) {
				text.setFill(Color.GREEN);
			}
		});
		
		//  Build Pane.
		BorderPane pane = new BorderPane();
		pane.setBottom(paneForButtons);
		pane.setTop(paneForRadioButtons);
		pane.setCenter(paneForText);
		
		return pane;
	}
	
	//  Process valid move.
	protected void moveText(double left, double right, double x) {
		
	//	double lb = super.getWidth();
	//	double leftBound = 10;
	//	double rightBound = 190;
		
		if ((x > left) && (x < right)) {
			text.setX(x);
		}
		return;
	}
		
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create a scene and place it in the stage
		Scene scene = new Scene(getPane(), 450, 200);		
		primaryStage.setTitle("Exercise 16 - 1"); // Set the stage title
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
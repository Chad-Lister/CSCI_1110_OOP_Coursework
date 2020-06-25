/*
	Author:  Chad Lister
	Date: 06/22/2020
	
	This program contains the book's DisplayClock class modified by Chad Lister according to the exercise 14 - 15.  It uses random time fields, adds 3 buttons and hides second hand by setting the boolean secondHandVisible field to False.
*/

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

public class DisplayClock extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create a clock and a label
		ClockPane clock = new ClockPane();
		
		//  Added by Chad Lister
		// Get Random numbers for hour 0 to 11, minute 0 or 30, and random for second.
		int hour = 0;
		hour = (int)(Math.random() * 11);
		if (hour == 0){
			hour = 1;
		}
		int minute = 0;
		double minuteChoice = Math.random() * 100;
		if (minuteChoice > 49) {
			minute = 30;
		}
		int second = (int)(Math.random() * 59);
				
		// send random time to set methods.
		clock.setHour(hour);
		clock.setMinute(minute);
		clock.setSecond(second);
						
		String timeString = hour + " : " + minute + " : "+ second;
		Label lblRandomTime = new Label(timeString);
		
		//  Pass secondHandVisible condition as false.
		clock.setSecondHandVisible(false);
				
		//  Added by Chad Lister
		//  Set Button Pane and Label.
//		FlowPane buttonPane = new FlowPane();
//		String buttonString = "Hide";
//		Label lblHideHand = new Label(buttonString);
			
		//  Place nodes / buttons.
//		buttonPane.getChildren().add(lblHideHand);
//		buttonPane.getChildren().add(new Button("Hour"));
//		buttonPane.getChildren().add(new Button("Minute"));
//		buttonPane.getChildren().add(new Button("Second"));
//		buttonPane.setHgap(10);
		
		// Place clock and label in border pane
		//  Added by Chad Lister
		//  place Flow Pane and Label. Modified current label.
		BorderPane pane = new BorderPane();
		pane.setTop(lblRandomTime);
		pane.setCenter(clock);
//		pane.setBottom(buttonPane);
//		pane.setAlignment(buttonPane, Pos.BOTTOM_CENTER);
		pane.setAlignment(lblRandomTime, Pos.TOP_CENTER);
		
		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 250, 250);
		primaryStage.setTitle("DisplayClock with Random Time and Hidden Second hand"); // Set the stage title. Modified by Chad Lister
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
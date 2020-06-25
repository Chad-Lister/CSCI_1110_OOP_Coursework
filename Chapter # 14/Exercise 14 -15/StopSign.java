/*
	Author:  Chad Lister
	Date: 06/23/2020
	
	This program/class modifies the ShowPolygon() example given in the book to show a stop sign as described by Exercise 14 -15.
	
	ShowPolygon() pg. 570 in textbook modified by Chad Lister 06/23/2020.
*/

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.scene.text.*;

public class StopSign extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {  
		
		//  Made poly stackpane with text at end.  Chad Lister
		StackPane stack = new StackPane(new MyPolygon());
		
		//  Made scene out of stack pane to include shape and text change.
		Scene stopsign = new Scene(stack, 400, 400);
		
		primaryStage.setTitle("Exercise 14 - 15"); // Set the stage title	Modified by Chad Lister
		primaryStage.setScene(stopsign); // Place the scene in the stage
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

//  Modified extends by Chad Lister.
class MyPolygon extends StackPane {
	private void paint() {

		// Create a polygon and place polygon to pane
		Polygon polygon = new Polygon();
		//  modified by Chad
		polygon.setFill(Color.RED);
		polygon.setStroke(Color.BLACK);
		polygon.setRotate(22.5);
		ObservableList<Double> list = polygon.getPoints();
		
		double centerX = getWidth() / 2, centerY = getHeight() / 2;
		double radius = Math.min(getWidth(), getHeight()) * 0.4;

		// s represents the number of sides of the shape
		// Make sure to update this number when necessary
		//  changed to 8 by Chad
		// Add points to the polygon list
		for (int i = 0; i < 8; i++) {
			list.add(centerX + radius * Math.cos(2 * i * Math.PI / 8)); 
			list.add(centerY - radius * Math.sin(2 * i * Math.PI / 8));
		}     
		
		//  Added by Chad
		String stopString = "STOP";
		Text stop= new Text(stopString);
		stop.setFont(Font.font("Times New Roman", 100));
		stop.setFill(Color.WHITE);

		getChildren().clear();
		//  modified by Chad
		getChildren().addAll(polygon, stop); 
	}
	
	@Override
	public void setWidth(double width) {
		super.setWidth(width);
		paint();
	}
	
	@Override
	public void setHeight(double height) {
		super.setHeight(height);
		paint();
	}
}
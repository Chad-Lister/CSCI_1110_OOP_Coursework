/*
	Author:  Chad Lister.
	Date: 07/09/2020
	
	This program gets a textfield variable and validates whether it is a number or not.  It then tries to animate the number like a counter.
	
	Exercise 16 -21.
*/

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class CountDown extends Application {
	
	int count;
	String countString;	
	private Timeline animation = new Timeline();
	private Label timer = new Label();	
	private final String  url = "https://liveexample.pearsoncmg.com/common/audio/anthem/anthem0.mp3";
	
	// Application override.
	@Override
	public void start(Stage primaryStage) {
		
		//  Get init.
		BorderPane init = new BorderPane();
//		HBox var = new HBox(20);
		Label message = new Label("Please enter a number for the count:  ");
		TextField num = new TextField();
//		var.getChildren().addAll(message,num);
		init.setCenter(num);
		init.setTop(message);
		
		//  Set on entry.  Validate whether good or bad.  Call timer.
		num.setOnAction(e -> validate(num.getText()));				
		
		Scene scene = new Scene(init, 200, 100);

		primaryStage.setTitle("Exercise Init");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
		
	public void validate(String start) throws NumberFormatException {
	
		//  If it passes, call 2nd stage otherwise show error. 
		try {
		
			countString = start;
			count = Integer.parseInt(countString);
			secondStage(countString, count);
			}
		catch (NumberFormatException e) {
			
			Pane error = new Pane(new Label("Number Required"));
			error.setStyle("-fx-font-size: 2em");
			error.setTranslateX(50);
			error.setTranslateY(50);
			Scene showMessage = new Scene(error, 200, 200);

			Stage stage = new Stage();
			stage.setScene(showMessage);
			stage.show();
		}
	}

	public void secondStage(String countString, int count) {

		StackPane c = new StackPane();
				
		// KeyFrame handler updates timer label.		
		EventHandler<ActionEvent> eventHandler = e -> {
			update(countString);
		};
		
		animation = new Timeline(new KeyFrame(Duration.millis(1000), eventHandler));
		animation.setCycleCount(count);
		animation.play();

		timer.setText(countString);
//		timer.setTranslateX(10);
//		timer.setTranslateY(50);
		timer.setStyle("-fx-font-size: 2em");
		c.getChildren().add(timer);

		
		Scene countDown = new Scene(c, 200, 200);
		Stage finalStage = new Stage();
		finalStage.setTitle("Exercise 16 - 21");
		finalStage.setScene(countDown);
		finalStage.show();
	}
	
	public void update(String countString) {

		//  Media Player
		Media sound = new Media(url);
		MediaPlayer media = new MediaPlayer(sound);
		media.setCycleCount(media.INDEFINITE);
		
		timer.getText();
		//  Subtract
		count--;
		countString = count + "";
		//  Reset Label
		timer.setText(countString);			
		if (count <= 0) {
			animation.stop();
			media.play();
		}
	}
	
	/**
	* The main method is only needed for the IDE with limited
	* JavaFX support. Not needed for running from the command line.
	*/
	public static void main(String[] args) {
		launch(args);
	}
}
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.ContentDisplay;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

/**
 * <h1>CSCI 1110 Final Project</h1>
 * <p>This program is a simulation of the inner solar system.  The scale is basically 1 pixel = 1000 miles for the size of the planets.  The sun is not to scale.  Their elliptical orbits are scaled at 1 pixel = 1 million miles.  The buttons on the bottom control the animation and the top horizontal box gives the option of listing planetary detail based upon key field entry.</p>
 * 
 * <p>Created:  07/23/2020</p>
 * 
 * @author Chad Lister
*/

public class InnerSolarSystem extends Application {
  
   // 1 day = .25 seconds. //  1,000 miles = 1px  // 1 px = 1 mil dist. from sun
  private double day = 250;
  private Circle mercury = new Circle();
  private Circle venus = new Circle();
  private Circle earth = new Circle();
  private Circle mars = new Circle();
  private PathTransition mercuryPath = new PathTransition();
  private PathTransition venusPath = new PathTransition();
  private PathTransition earthPath = new PathTransition();
  private PathTransition marsPath = new PathTransition();
  private boolean flag = false;


   @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    // Create a pane 
    BorderPane pane = new BorderPane();
    
    //  Background image.
    Image image = new Image("/Images/BackGround.png");  //  commented out for eclipse
    ImageView imageView = new ImageView(image);
    imageView.setFitHeight(500);
    imageView.setFitWidth(1500);
    pane.setCenter(imageView);

    // Create planets and sun.
    Circle sun = new Circle(750, 350, 100, Color.YELLOW);
    mercury = new Circle(815, 400, 3.03, Color.GREY); // 3,031mi  35.98 million mi  88 d 29 - 43 million35,980 px
    venus = new Circle(199, 430, 7.52, Color.ORANGE); // 4212 mi  66 - 67.24 million mi  225 d diameter 7521
    earth = new Circle(600, 340, 7.92, Color.BLUE);  //  7520  92.96  91 - 94 million mi 365 d  diameter 7926
    mars = new Circle(650, 475, 4.22, Color.RED);  // 7917 mi  141.6 million mi  687 d  128 - 154  diameter 4217

    // Create eliptical orbits.
    Ellipse e1 = new Ellipse(750, 350, 172, 21);    //  (700 - 29) - (843)
    e1.setStroke(Color.GREY);
    e1.setFill(null);
    Ellipse e2 = new Ellipse(750, 350, 233.24, 33);    //  (700 - 66) - 867.24
    e2.setStroke(Color.GREY);
    e2.setFill(null);
    Ellipse e3 = new Ellipse(750, 350, 285, 47);    //  (700 - 91) - 894    
    e3.setStroke(Color.GREY);
    e3.setFill(null);
    Ellipse e4 = new Ellipse(750, 350, 382, 63);    //  (700 - 128) - 954
    e4.setStroke(Color.GREY);
    e4.setFill(null);
    
    //  Add all to pane.
    pane.getChildren().addAll(e4, e3, e2, e1);
    pane.getChildren().addAll(sun, mercury, venus, earth, mars);

    // Create a path transition for Mercury.
    mercuryPath.setDuration(Duration.millis(day * 88));    //  88
    mercuryPath.setPath(e1);
    mercuryPath.setNode(mercury);
    mercuryPath.setRate(-1.0);
    mercuryPath.setCycleCount(Timeline.INDEFINITE);
    mercuryPath.play(); // Start animation 

    // Create a path transition for Venus.
    venusPath.setDuration(Duration.millis(day * 225));      //225
    venusPath.setPath(e2);
    venusPath.setNode(venus);
    venusPath.setRate(-1.0);
    venusPath.setCycleCount(Timeline.INDEFINITE);
    venusPath.play(); // Start animation 

    // // Create a path transition for Earth.
    earthPath.setDuration(Duration.millis(day * 365));     //   365
    earthPath.setPath(e3);
    earthPath.setNode(earth);
    earthPath.setRate(-1.0);
    earthPath.setCycleCount(Timeline.INDEFINITE);
    earthPath.play(); // Start animation 

    // // Create a path transition for Mars.
    marsPath.setDuration(Duration.millis(day * 687));      //  687 d
    marsPath.setPath(e4);
    marsPath.setNode(mars);
    marsPath.setRate(-1.0);
    marsPath.setCycleCount(Timeline.INDEFINITE);
    marsPath.play(); // Start animation 
    
    //  Add box for animation buttons.
    Button play = new Button(" Play ");
    Button pause = new Button("Pause");
    play.setOnAction(e -> {
      animationControl(true);
    });
    pause.setOnAction(e -> {
      animationControl(false);
    });
    HBox buttons = new HBox(50, play, pause);
    buttons.setStyle("-fx-border-color: black; -fx-border-width: 2");
    buttons.setPadding(new Insets(20, 5, 5, 20));
    buttons.setAlignment(Pos.CENTER);
    pane.setBottom(buttons);

    //  Top Hbox.
    HBox detail = new HBox(50);
    detail.setStyle("-fx-border-color: black; -fx-border-width: 2");
    Label label = new Label("Show detail pane for:  ");
    TextField choice = new TextField();
    choice.setPrefSize(50, 20);
    Text message = new Text("1 - Mercury, 2 - Venus, 3 - Earth or 4 - Mars.");
    Text scale = new Text("Planet Scale:  1 pixel equals 1,000 miles.  Sun is not to scale.\nDistance Scale:  1 pixel equals 1 million miles.\nOrbital period:  .25 seconds equals 1 day.");
    detail.getChildren().addAll(label, choice, message, scale);
    detail.setPadding(new Insets(20, 5, 5, 20));
    detail.setAlignment(Pos.CENTER);
    pane.setTop(detail);

    //  Process Text Field.
    choice.setOnAction(e -> {
      animationControl(false);
      processTextField(choice.getText());
      choice.clear();
      animationControl(true);
    });

    // Create a scene and place it in the stage
    Scene scene = new Scene(pane, 1500, 500);
    primaryStage.setTitle("Inner System"); // Set the stage title
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
 
  /**
  * This method controls the pause / play action of the planet's orbit.
  * 
  * @param flag (boolean; whether to start or continue to play the animation.)
  */

  public void animationControl(boolean flag) {
    
    //  If animation play.
    if (flag == true) {
      mercuryPath.play();
      venusPath.play();
      earthPath.play();
      marsPath.play();
      flag = false;
    }
    else {
      mercuryPath.pause();
      venusPath.pause();
      earthPath.pause();
      marsPath.pause();
      flag = true;
    }
  }
  
  /**
  * This method processes the text field for planet detail choice in the top HBox.
  * 
  * @param number (String; What planetary detail box to display to the screen.)
  */

  public void processTextField(String number) throws NumberFormatException {

    try {

      int choice = Integer.parseInt(number);

      if (choice == 1) {
        mercuryDetail();
      }
      if (choice == 2) {
        venusDetail();
      }
      if (choice == 3) {
        earthDetail();
      }
      if (choice == 4) {
        marsDetail();
      }
    }
    catch (NumberFormatException e) {
      animationControl(false);
    }
  }

  /**
  * This method is the planet Mercury's detail pane.  It includes an image, title and some factual details.
  */

  public void mercuryDetail() {

   // Declare and create a description pane
   DescriptionPane descriptionPane = new DescriptionPane();
   
   // Set title, text and image in the description pane
   descriptionPane.setTitle("Mercury");
   String description = "Discovery: Known to the ancient Greeks and visible to the naked eye.\nNamed for the messenger of the Roman gods.\nDiameter: 3,031 miles (4,878 km).\nOrbit: 88 Earth days.\nDay: 58.6 Earth days.\n\nMercury (0.4 AU from the Sun) is the closest planet to the Sun and on average, all seven other planets. The smallest planet in the Solar System (0.055 M⊕), Mercury has no natural satellites. Besides impact craters, its only known geological features are lobed ridges or rupes that were probably produced by a period of contraction early in its history. Mercury's very tenuous atmosphere consists of atoms blasted off its surface by the solar wind. Its relatively large iron core and thin mantle have not yet been adequately explained. Hypotheses include that its outer layers were stripped off by a giant impact, or that it was prevented from fully accreting by the young Sun's energy.";
   Image mercury = new Image("/Images/Mercury.png");    //  commented out for eclipse.
   descriptionPane.setImageView(new ImageView(mercury));
   descriptionPane.setDescription(description);

   Scene mercPane = new Scene(descriptionPane);
   Stage mercStage = new Stage();
   mercStage.setScene(mercPane);
   mercStage.show();
  }
  
  /**
  * This method is the planet Venus's details.  It includes an image, title and some factual details.
  */

  public void venusDetail() {

  // Declare and create a description pane
  DescriptionPane descriptionPane = new DescriptionPane();
  
  // Set title, text and image in the description pane
  descriptionPane.setTitle("Venus");
  String description = "Discovery: Known to the ancient Greeks and visible to the naked eye.\nNamed for the Roman goddess of love and beauty.\nDiameter: 7,521 miles (12,104 km).\nOrbit: 225 Earth days.\nDay: 241 Earth days.\n\nVenus (0.7 AU from the Sun) is close in size to Earth (0.815 M⊕) and, like Earth, has a thick silicate mantle around an iron core, a substantial atmosphere, and evidence of internal geological activity. It is much drier than Earth, and its atmosphere is ninety times as dense. Venus has no natural satellites. It is the hottest planet, with surface temperatures over 400 °C (752 °F), most likely due to the amount of greenhouse gases in the atmosphere. No definitive evidence of current geological activity has been detected on Venus, but it has no magnetic field that would prevent depletion of its substantial atmosphere, which suggests that its atmosphere is being replenished by volcanic eruptions.";
  Image venus = new Image("/Images/Venus.png");  //  commented out for eclipse
  descriptionPane.setImageView(new ImageView(venus));
  descriptionPane.setDescription(description);

  Scene venusPane = new Scene(descriptionPane);
  Stage venusStage = new Stage();
  venusStage.setScene(venusPane);
  venusStage.show();
  }
  
  /**
  * This method is the planet Earth's details.  It includes an image, title and some factual details.
  */

  public void earthDetail() {

  // Declare and create a description pane
  DescriptionPane descriptionPane = new DescriptionPane();
  
  // Set title, text and image in the description pane
  descriptionPane.setTitle("Earth");
  String description = "Name originates from 'Die Erde', the German word for 'the ground'.\nDiameter: 7,926 miles (12,760 km).\nOrbit: 365.24 days.\nDay: 23 hours, 56 minutes.\n\nEarth (1 AU from the Sun) is the largest and densest of the inner planets, the only one known to have current geological activity, and the only place where life is known to exist. Its liquid hydrosphere is unique among the terrestrial planets, and it is the only planet where plate tectonics has been observed. Earth's atmosphere is radically different from those of the other planets, having been altered by the presence of life to contain 21% free oxygen. It has one natural satellite, the Moon, the only large satellite of a terrestrial planet in the Solar System.";

  Image earth = new Image("/Images/Earth.png");  //  commented out for eclipse.
  descriptionPane.setImageView(new ImageView(earth));
  descriptionPane.setDescription(description);

  Scene earthPane = new Scene(descriptionPane);
  Stage earthStage = new Stage();
  earthStage.setScene(earthPane);
  earthStage.show();
  }
 
  /**
  * This method is the planet Mars's details.  It includes an image, title and some factual details.
  */

  public void marsDetail() {

  // Declare and create a description pane
  DescriptionPane descriptionPane = new DescriptionPane();
  
  // Set title, text and image in the description pane
  descriptionPane.setTitle("Mars");
  String description = "Discovery: Known to the ancient Greeks and visible to the naked eye.\nNamed for the Roman god of war.\nDiameter: 4,217 miles (6,787 km).\nOrbit: 687 Earth days.\nDay: Just more than one Earth day (24 hours, 37 minutes).\n\nMars (1.5 AU from the Sun) is smaller than Earth and Venus (0.107 M⊕). It has an atmosphere of mostly carbon dioxide with a surface pressure of 6.1 millibars (roughly 0.6% of that of Earth). Its surface, peppered with vast volcanoes, such as Olympus Mons, and rift valleys, such as Valles Marineris, shows geological activity that may have persisted until as recently as 2 million years ago. Its red colour comes from iron oxide (rust) in its soil. Mars has two tiny natural satellites (Deimos and Phobos) thought to be either captured asteroids, or ejected debris from a massive impact early in Mars's history.";

  Image mars = new Image("/Images/Mars.png");
  descriptionPane.setImageView(new ImageView(mars));
  descriptionPane.setDescription(description);

  Scene marsPane = new Scene(descriptionPane);
  Stage marsStage = new Stage();
  marsStage.setScene(marsPane);
  marsStage.show();
  }
}
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;

/**
 * <h1>CSCI 1110 Final Project</h1>
 * <p>This is the books Description pane used for giving the planetary detail in my simulation.  "Introduction to Java Programming", 10th edition, Y. Daniel Liang, Pearson.
 * 
 * <p>Created:  07/23/2020</p>
 */


public class DescriptionPane extends BorderPane {
  // Label for displaying an image and a title
  private Label lblImageTitle = new Label();

  // Text area for displaying text
  private TextArea taDescription = new TextArea();
  
  public DescriptionPane() {
    // Center the icon and text and place the text under the icon
    lblImageTitle.setContentDisplay(ContentDisplay.TOP);
    lblImageTitle.setPrefSize(50, 50);
    
    // Set the font in the label and the text field
    lblImageTitle.setFont(new Font("SansSerif", 16));
    taDescription.setFont(new Font("Serif", 14));
    
    taDescription.setWrapText(true);
    taDescription.setEditable(false);

    // Create a scroll pane to hold the text area
    ScrollPane scrollPane = new ScrollPane(taDescription);

    // Place label and scroll pane in the border pane
    setLeft(lblImageTitle);
    setCenter(scrollPane);
    setPadding(new Insets(5, 5, 5, 5));
  }
  
  // Set the title 
  public void setTitle(String title) {
    lblImageTitle.setText(title);
  }

  // Set the image view 
  public void setImageView(ImageView icon) {
    lblImageTitle.setGraphic(icon);
  }

  // Set the text description 
  public void setDescription(String text) {
    taDescription.setText(text);
  }
}
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


/**
 * Nick Neal
 *
 * Controller which connects the view and model. 
 */
public class MvController implements Initializable {

  @FXML
  private Button btngo;
  
  @FXML 
  private TextField txtmovie;
  
  @FXML
  private Label lbltitle;
  
  @FXML
  private ImageView poster;
  
  @FXML 
  private Label lbldate;
  
  @FXML
  private Label lblgenre;
  
  @FXML
  private Label lblruntime;
  
  @FXML
  private Label lbldirector;
  
  @FXML
  private Label lblactors;
  
  @FXML
  private Label lblrating;
  
  @FXML
  private Label lblplot;

  @FXML
  private void handleButtonAction(ActionEvent e) {
    // Create object to access the Model
    MvModel mv = new MvModel();

    // Has the go button been pressed?
    if (e.getSource() == btngo)
    {
      String movie = txtmovie.getText();
      if (mv.getMovie(movie))
      {
        lbltitle.setText(mv.getTitle());
        poster.setImage(mv.getPoster());
        lbldate.setText(mv.getDate());
        lblgenre.setText(mv.getGenre());
        lblruntime.setText(mv.getRuntime());
        lbldirector.setText(mv.getDirector());
        lblactors.setText(mv.getActors());
        lblrating.setText(mv.getRating());
        lblplot.setText(mv.getPlot());
        
      }
      else
      {
        lbltitle.setText("Invalid Movie!");
        poster.setImage(new Image("Badmovietitle.png"));
        lbldate.setText("N/A");
        lblgenre.setText("N/A");
        lblruntime.setText("N/A");
        lbldirector.setText("N/A");
        lblactors.setText("N/A");
        lblrating.setText("N/A");
        lblplot.setText("N/A");
      }
    }
  }

  @Override
  public void initialize(URL url, ResourceBundle rb) {

  }    

}

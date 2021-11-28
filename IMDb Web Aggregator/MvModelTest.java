import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import javafx.scene.image.Image;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;



/*
 * Test the MvModel class
 */
public class MvModelTest
{ 
  // api key declaration
  private final String apiKey = "1cbd005e";
  
  @Test
  public void testGetMovie1()
  {
    String movie = "A Quiet Place";
    MvModel m = new MvModel();
    assertEquals(true, m.getMovie(movie));
  }
  
  @Test
  public void testGetMovie2()
  {
    String movie = "abcdef";
    MvModel m = new MvModel();
    assertEquals(false, m.getMovie(movie));
  }
  
  @Test
  public void testGetMovie3()
  {
    String movie = "Solo: A Star Wars Story";
    MvModel m = new MvModel();
    assertEquals(true, m.getMovie(movie));
  }
  
  
  @Test
  public void testGetTitle()
  {
    String movie = "Titanic";
    MvModel m = new MvModel();
    if (m.getMovie(movie)) {
        assertEquals("Titanic", m.getTitle());
    }
  }
  
  @Test
  public void testGetDate()
  {
    String movie = "Titanic";
    MvModel m = new MvModel();
    if (m.getMovie(movie)) {
        assertEquals("19 Dec 1997", m.getDate());
    }
  }
  
  @Test
  public void testGetGenre()
  {
    String movie = "Avatar";
    MvModel m = new MvModel();
    if (m.getMovie(movie)) {
        assertEquals("Action, Adventure, Fantasy", m.getGenre());
    }
  }
  
  @Test
  public void testGetRating()
  {
    String movie = "Avatar";
    MvModel m = new MvModel();
    if (m.getMovie(movie)) {
        assertEquals("PG-13", m.getRating());
    }
  }
  
  @Test
  public void testGetRuntime()
  {
    String movie = "Black Panther";
    MvModel m = new MvModel();
    if (m.getMovie(movie)) {
        assertEquals("134 min", m.getRuntime());
    }
  }
  
  @Test
  public void testGetDirector()
  {
    String movie = "Black Panther";
    MvModel m = new MvModel();
    if (m.getMovie(movie)) {
        assertEquals("Ryan Coogler", m.getDirector());
    }
  }
  
  @Test
  public void testGetActors()
  {
    String movie = "Guardians of the Galaxy";
    MvModel m = new MvModel();
    if (m.getMovie(movie)) {
        assertEquals("Chris Pratt, Zoe Saldana, Dave Bautista, Vin Diesel", 
                     m.getActors());
    }
  }
  
  @Test
  public void testGetPlot()
  {
    String movie = "Guardians of the Galaxy";
    MvModel m = new MvModel();
    if (m.getMovie(movie)) {
        assertEquals("A group of intergalactic criminals are forced to work"  
                     + " together to stop a fanatical warrior from taking control" 
                     + " of the universe.", m.getPlot());
    }
  }  
}

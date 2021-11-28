import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Nick Neal
 *
 * Model to get movie information.
 */
public class MvModel {
  private JsonElement jse;
  private final String apiKey = "1cbd005e";

  public boolean getMovie(String movie)
  {
    try
    {
      movie.replaceAll(" ", "_").toLowerCase();
      URL mvURL = new URL("http://www.omdbapi.com/?t=" 
                          + movie.replaceAll(" ", "_").toLowerCase() 
                          + "&apiKey=" + apiKey);
      // Open connection
      InputStream is = mvURL.openStream();
      BufferedReader br = new BufferedReader(new InputStreamReader(is));

      // Read the results into a JSON Element
      jse = new JsonParser().parse(br);

      // Close connection
      is.close();
      br.close();
    }
    catch (java.io.UnsupportedEncodingException uee)
    {
      uee.printStackTrace();
    }
    catch (java.net.MalformedURLException mue)
    {
      mue.printStackTrace();
    }
    catch (java.io.IOException ioe)
    {
      ioe.printStackTrace();
    }
    catch (java.lang.NullPointerException npe)
    {
      npe.printStackTrace();
    }

    // check to see if movie title is valid
    return isValid();
  }

  public boolean isValid()
  {
    // invalid movie title
    try {
      String error = jse.getAsJsonObject().get("Error").getAsString();
      return false;
    }

    catch (java.lang.NullPointerException npe)
    {
      // valid movie title
      return true;
    }
  }

  public String getTitle()
  {
    return jse.getAsJsonObject().get("Title").getAsString();
  }

  public String getDate()
  {
    return jse.getAsJsonObject().get("Released").getAsString();
  }

  public Image getPoster()
  {
    String posterURL = jse.getAsJsonObject().get("Poster").getAsString();
    return new Image(posterURL);
  }
  public String getGenre()
  {
    return jse.getAsJsonObject().get("Genre").getAsString();
  }
  
  public String getRuntime()
  {
    return jse.getAsJsonObject().get("Runtime").getAsString();
  }
  
  public String getDirector()
  {
    return jse.getAsJsonObject().get("Director").getAsString();
  }
  
  public String getActors()
  {
    return jse.getAsJsonObject().get("Actors").getAsString();
  }
  public String getRating()
  {
    return jse.getAsJsonObject().get("Rated").getAsString();
  }
  
  public String getPlot()
  {
    return jse.getAsJsonObject().get("Plot").getAsString();
  }
}


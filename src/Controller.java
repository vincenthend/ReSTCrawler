import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import org.json.JSONObject;

/**
 * Kelas Controller, mengontrol flow data.
 *
 * @author Vincent Hendryanto Halim / 13515089
 */
public class Controller {
  private final String apiRoot = "https://api.github.com";
  private UserInterface controllableUI;

  /**
   * Konstruktor controller
   */
  public Controller() {
    controllableUI = new UserInterface();
  }

  public JSONObject getJson(String link) {
    JSONObject jsonObject = null;
    HttpURLConnection connection;
    try {
      connection = (HttpURLConnection) new URL(link).openConnection();
      connection.setRequestMethod("GET");
      connection.setRequestProperty("Content-length", "0");
      connection.setAllowUserInteraction(false);
      connection.setUseCaches(false);
      connection.connect();
      int response = connection.getResponseCode();
      if (response == 200 || response == 201) {
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(connection.getInputStream()));
        StringBuilder jsonString = new StringBuilder();
        String line;
        line = reader.readLine();
        while (line != null) {
          jsonString.append(line + "\n");
          line = reader.readLine();
        }
        reader.close();
        System.out.println(jsonString);
        jsonObject = new JSONObject(jsonString);
      }
    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return jsonObject;
  }

  /**
   * Melakukan search username/email/nama dengan request kepada REST API.
   *
   * @param query string username/email/nama yang dicari
   * @return daftar username yang ditemukan
   */
  public LinkedList<String> searchUsername(StringBuffer query) {
    JSONObject searchResult = getJson(apiRoot+"/search/users?q="+query);
    return null;
  }


}

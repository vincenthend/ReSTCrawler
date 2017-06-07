import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Kelas Controller, mengontrol flow data.
 *
 * @author Vincent Hendryanto Halim / 13515089
 */
public class Controller {

  private UserInterface controlledUI;

  /**
   * Konstruktor controller, membuat UI dan memasang action listener.
   */
  public Controller() {
    controlledUI = new UserInterface();

    //Add action listener
    controlledUI.setSearchListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
        SearchQuery query = controlledUI.getSearchQuery();
        System.out.println(searchUsername(query));
        //controlledUI.showSearchResult(searchUsername(query));
      }
    });
  }

  /**
   * Mengambil data JSON dari lokasi URL tertentu.
   *
   * @param link URL lokasi file JSON
   * @return JSONObject berisi data JSON dari URL
   */
  public JSONObject getJson(String link) {
    JSONObject jsonObject = null;
    HttpURLConnection connection;
    try {
      connection = (HttpURLConnection) new URL(link).openConnection();
      connection.setRequestMethod("GET");
      connection.connect();
      int response = connection.getResponseCode();
      if (response == 200 || response == 201) {
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(connection.getInputStream()));
        StringBuilder jsonString = new StringBuilder();
        String line;
        line = reader.readLine();
        while (line != null) {
          jsonString.append(line);
          line = reader.readLine();
        }
        reader.close();
        jsonObject = new JSONObject(jsonString.toString());
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
   * @param query data mengenai searching yang harus dilakukan elemen pertama berisi keyword, elemen
   * kedua
   * @return daftar username yang ditemukan
   */
  public LinkedList<String> searchUsername(SearchQuery query) {
    final int userPerPage = 100;

    //Set method string query
    String searchURL = query.getSearchURL();
    JSONObject searchResult = getJson(searchURL);

    //Process JSONObject
    int i;
    int j;
    int count = searchResult.getInt("total_count");

    LinkedList<String> usernameList = new LinkedList<>();

    int pageCount = count / userPerPage;
    if (count % userPerPage != 0) {
      pageCount++;
    }

    System.out.println(count);
    System.out.println(pageCount);

    for (i = 1; i <= pageCount; i++) {
      searchResult = getJson(searchURL + "&per_page=" + userPerPage + "&page=" + i);
      System.out.println(searchURL + "&per_page=" + userPerPage + "&page=" + i);
      JSONArray resultArray = searchResult.getJSONArray("items");
      for (j = 0; j < resultArray.length(); j++) {
        usernameList.addLast(resultArray.getJSONObject(j).getString("login"));
      }
    }

    return usernameList;
  }
}

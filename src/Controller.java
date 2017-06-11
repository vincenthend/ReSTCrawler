import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import javax.swing.JTable;
import model.Repository;
import model.SearchQuery;
import model.User;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import view.UserInterface;

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
    controlledUI.getSearchView().getSearchField().setSearchListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent actionEvent) {
        SearchQuery query = controlledUI.getSearchView().getSearchField().getSearchQuery();
        controlledUI.getSearchView().getSearchResultView().setResult(searchUsername(query));
      }
    });
    controlledUI.getSearchView().getSearchResultView().setSelectionListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent mouseEvent) {
        //Get selected username
        JTable resultTable = controlledUI.getSearchView().getSearchResultView()
            .getResultTable();
        int row = resultTable.rowAtPoint(mouseEvent.getPoint());
        int col = resultTable.columnAtPoint(mouseEvent.getPoint());
        System.out.println(row + "" + col);
        if(row >= 0) {
          String username = (String) resultTable.getModel().getValueAt(row, col);
          User selectedUser = getUserDetail(username);
          controlledUI.getUserView().setUser(selectedUser);
        }
      }
    });
  }

  /**
   * Mengambil data JSON dari lokasi URL tertentu.
   *
   * @param link URL lokasi file JSON
   * @return JSONObject berisi data JSON dari URL
   */
  public String getJsonString(String link) {
    StringBuilder jsonString = new StringBuilder();
    HttpURLConnection connection;
    try {
      connection = (HttpURLConnection) new URL(link).openConnection();
      connection.setRequestMethod("GET");
      connection.connect();
      int response = connection.getResponseCode();
      if (response == 200 || response == 201) {
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(connection.getInputStream()));
        String line;
        line = reader.readLine();
        while (line != null) {
          jsonString.append(line);
          line = reader.readLine();
        }
        reader.close();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return jsonString.toString();
  }

  /**
   * Melakukan search username/email/nama dengan request kepada REST API.
   *
   * @param query data mengenai searching yang harus dilakukan
   * @return daftar username yang ditemukan
   */
  public LinkedList<String> searchUsername(SearchQuery query) {
    final int userPerPage = 100;

    //Set method string query
    String searchURL = query.getSearchURL();
    System.out.println(searchURL);
    JSONObject searchResult = new JSONObject(getJsonString(searchURL));
    //Process JSONObject
    int i;
    int j;
    int count = searchResult.getInt("total_count");

    LinkedList<String> usernameList = new LinkedList<>();

    //Count page number needed
    int pageCount = count / userPerPage;
    if (count % userPerPage != 0) {
      pageCount++;
    }

    //Get username
    for (i = 1; i <= pageCount; i++) {
      searchResult = new JSONObject(
          getJsonString(searchURL + "&per_page=" + userPerPage + "&page=" + i));
      JSONArray resultArray = searchResult.getJSONArray("items");
      for (j = 0; j < resultArray.length(); j++) {
        usernameList.addLast(resultArray.getJSONObject(j).getString("login"));
      }
    }

    return usernameList;
  }

  /**
   * Mengambil data mengenai user.
   *
   * @param username username yang datanya diambil
   * @return object user berisi data mengenai user terkait
   */
  public User getUserDetail(String username) {
    String link = "https://api.github.com/users/";
    System.out.println(link + username);
    JSONObject userJson = new JSONObject(getJsonString(link + username));
    JSONArray userRepo = new JSONArray(getJsonString(link + username + "/repos"));

    User selectedUser = new User();

    //Set model.User Detail
    selectedUser.setUsername(userJson.getString("login"));
    try {
      selectedUser.setName(userJson.getString("name"));
    } catch (JSONException e) {
      selectedUser.setName("-no name-");
    }
    selectedUser.setRepoCount(userJson.getInt("public_repos"));
    selectedUser.setFollowersCount(userJson.getInt("followers"));

    //Add model.Repository Detail
    int i;
    Repository repoTemp;
    String repoName;
    String repoURL;
    String repoDesc;
    for (i = 0; i < userRepo.length(); i++) {
      repoName = userRepo.getJSONObject(i).getString("name");
      repoURL = userRepo.getJSONObject(i).getString("html_url");
      try {
        repoDesc = userRepo.getJSONObject(i).getString("description");
      } catch (JSONException e) {
        //Exception in case of null value of description
        repoDesc = "";
      }
      repoTemp = new Repository(repoName, repoURL, repoDesc);
      selectedUser.addRepository(repoTemp);
    }

    return selectedUser;
  }
}

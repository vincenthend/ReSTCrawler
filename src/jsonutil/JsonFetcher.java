package jsonutil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import model.Repository;
import model.SearchQuery;
import model.User;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Kelas JsonFetcher, mengambil data JSON dari URL tertentu.
 *
 * @author Vincent Hendryanto Halim / 13515089
 */
public class JsonFetcher {

  /**
   * Mengambil data JSON dari lokasi URL tertentu.
   *
   * @param link URL lokasi file JSON
   * @return JSONObject berisi data JSON dari URL
   */
  private static String getJsonString(String link) {
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
  public static LinkedList<String> searchUsername(SearchQuery query) {
    final int userPerPage = 100;

    //Set method string query
    String searchUrl = query.getSearchUrl();
    System.out.println(searchUrl);
    JSONObject searchResult = new JSONObject(getJsonString(searchUrl));
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
          getJsonString(searchUrl + "&per_page=" + userPerPage + "&page=" + i));
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
  public static User getUserDetail(String username) {
    String link = "https://api.github.com/users/";
    System.out.println(link + username);
    JSONObject userJson = new JSONObject(getJsonString(link + username));


    User selectedUser = new User();

    //Set User Detail
    selectedUser.setUsername(userJson.getString("login"));
    try {
      selectedUser.setName(userJson.getString("name"));
    } catch (JSONException e) {
      selectedUser.setName("-no name-");
    }
    selectedUser.setRepoCount(userJson.getInt("public_repos"));
    selectedUser.setFollowersCount(userJson.getInt("followers"));

    //Add Repository Detail
    int i;
    Repository repoTemp;
    String repoName;
    String repoUrl;
    String repoDesc;
    JSONArray userRepo = new JSONArray(getJsonString(link + username + "/repos"));
    for (i = 0; i < userRepo.length(); i++) {
      repoName = userRepo.getJSONObject(i).getString("name");
      repoUrl = userRepo.getJSONObject(i).getString("html_url");
      try {
        repoDesc = userRepo.getJSONObject(i).getString("description");
      } catch (JSONException e) {
        //Exception in case of null value of description
        repoDesc = "";
      }
      repoTemp = new Repository(repoName, repoUrl, repoDesc);
      selectedUser.addRepository(repoTemp);
    }

    return selectedUser;
  }
}

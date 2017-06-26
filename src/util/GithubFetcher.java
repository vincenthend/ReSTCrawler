package util;

import java.util.LinkedList;
import javax.swing.JOptionPane;
import model.Repository;
import model.SearchQuery;
import model.User;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * Kelas GithubFetcher, mengambil data menggunakan Github API.
 *
 * @author Vincent Hendryanto Halim / 13515089
 */
public class GithubFetcher {

  /**
   * Melakukan search username/email/nama dengan request kepada Github API.
   *
   * @param query data mengenai searching yang harus dilakukan
   * @return daftar username yang ditemukan
   */
  public static LinkedList<String> searchUsername(SearchQuery query) {
    LinkedList<String> usernameList = new LinkedList<>();

    try {
      final int userPerPage = 100;

      //Set method string query
      String searchUrl = query.getSearchUrl();
      JSONObject searchResult = new JSONObject(JsonFetcher.getJsonString(searchUrl));

      //Process JSONObject
      int i;
      int j;
      int count = searchResult.getInt("total_count");

      //Count page number needed
      int pageCount = count / userPerPage;
      if (count % userPerPage != 0) {
        pageCount++;
      }

      //Get username
      for (i = 1; i <= pageCount; i++) {
        searchResult = new JSONObject(
            JsonFetcher.getJsonString(searchUrl + "&per_page=" + userPerPage + "&page=" + i));
        JSONArray resultArray = searchResult.getJSONArray("items");
        for (j = 0; j < resultArray.length(); j++) {
          usernameList.addLast(resultArray.getJSONObject(j).getString("login"));
        }
      }
    } catch (JSONException e) {
      //Request limit reached
      JOptionPane.showMessageDialog(null, "Some results are not shown due to request limit");
    }

    return usernameList;
  }

  /**
   * Mengambil data mengenai user.
   *
   * @param username username yang datanya diambil
   * @return object user berisi data mengenai user terkait
   */

  public static User getUserDetail(String username) throws JSONException {
    String link = "https://api.github.com/users/";
    JSONObject userJson = new JSONObject(JsonFetcher.getJsonString(link + username));

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
    JSONArray userRepo = new JSONArray(JsonFetcher.getJsonString(link + username + "/repos"));
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

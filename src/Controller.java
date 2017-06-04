import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.LinkedList;
import org.json.JSONObject;

/**
 * Kelas Controller, mengontrol flow data.
 *
 * @author Vincent Hendryanto Halim / 13515089
 */
public class Controller {
  private UserInterface controllableUI;
  /**
   * Konstruktor controller
   */
  public Controller(){
    controllableUI = new UserInterface();
  }

  private JSONObject getJson(String link){
    JSONObject jsonObject = null;
    try {
      InputStream input = new URL(link).openStream();
      StringBuffer jsontext = new StringBuffer();

      int i;
      i = input.read();
      while(i != -1){
        jsontext.append((char)i);
        i = input.read();
      }
      System.out.println(jsontext);
      jsonObject = new JSONObject(jsontext);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return jsonObject;
  }

  /**
   * Melakukan search username dengan request kepada REST API.
   * @param query string username yang dicari
   * @param method metode pencarian (0 =
   * @return daftar user yang ditemukan
   */
  public LinkedList<User> searchUser(String query, int method){

    return null;
  }
}

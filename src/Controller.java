import java.net.URL;
import java.util.LinkedList;
import jdk.nashorn.internal.parser.JSONParser;


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

  private JSONParser getJson(URL link){
    /*try {
      connection = (HttpURLConnection) link.openConnection();
      connection.setRequestMethod("GET");
      connection.setRequestProperty("Content-length", "0");
      connection.getInputStream();
      connection.setConnectTimeout(20000);
      connection.setRequestProperty("Content-Type", "application/json");


    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }*/
    return null;
  }

  /**
   * Melakukan search username dengan request kepada REST API.
   * @param query string username yang dicari
   * @param method
   * @return daftar user yang ditemukan
   */
  public LinkedList<User> searchUser(String query, int method){

    return null;
  }
}

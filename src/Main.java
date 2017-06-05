import org.json.JSONObject;

/**
 * Kelas main.
 */
public class Main {

  public static void main(String[] args){
    Controller controller = new Controller();

    JSONObject a = controller.getJson("https://api.github.com");
  }

}

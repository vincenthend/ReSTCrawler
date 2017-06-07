import java.util.LinkedList;

/**
 * Kelas main.
 */
public class Main {

  public static void main(String[] args){
    Controller controller = new Controller();

    LinkedList<String> result = controller.searchUsername(new SearchQuery("jetero",0));
    System.out.println(result);

    //JSONObject a = controller.getJson("https://api.github.com/");
    //System.out.println(a.toString());
  }

}

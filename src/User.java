import java.net.URL;
import java.util.LinkedList;

/**
 * Kelas User, berisi data tentang user.
 *
 * @author Vincent Hendryanto Halim / 13515089
 */
public class User {

  private String username;
  private URL url;
  private LinkedList<Repository> repositoryList;
  private String email;

  /**
   * Getter username dari user.
   * @return username dari user
   */
  public String getUsername() {
    return username;
  }

  /**
   * Getter URL dari user.
   * @return URL dari username
   */
  public URL getUrl() {
    return url;
  }

  /**
   * Getter daftar repository yang dimiliki user.
   * @return Linked list berisi daftar repository yang dimiliki user
   */
  public LinkedList<Repository> getRepositoryList() {
    return repositoryList;
  }
}

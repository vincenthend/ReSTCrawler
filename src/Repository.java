import java.net.URL;

/**
 * Kelas Repository, berisi data tentang Repository yang dimiliki user.
 *
 * @author Vincent Hendryanto Halim / 13515089
 */
public class Repository {

  public String name;
  public URL url;

  /**
   * Getter nama repository.
   * @return nama repository
   */
  public String getName() {
    return name;
  }

  /**
   * Getter URL dari repository.
   * @return URL dari repository
   */
  public URL getUrl() {
    return url;
  }
}

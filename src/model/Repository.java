package model;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Kelas Repository, berisi data tentang Repository yang dimiliki user.
 *
 * @author Vincent Hendryanto Halim / 13515089
 */
public class Repository {

  private String name;
  private URL url;
  private String description;

  /**
   * Konstruktor repository.
   *
   * @param name nama Repository
   * @param url alamat repository
   * @param description deskripsi repository
   */
  public Repository(String name, String url, String description) {
    try {
      this.name = name;
      this.url = new URL(url);
      this.description = description;
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
  }

  /**
   * Getter nama repository.
   *
   * @return nama repository
   */
  public String getName() {
    return name;
  }

  /**
   * Getter URL dari repository.
   *
   * @return URL dari repository
   */
  public URL getUrl() {
    return url;
  }

  /**
   * Getter deskripsi repository.
   *
   * @return isi deskripsi repository
   */
  public String getDescription() {
    return description;
  }
}

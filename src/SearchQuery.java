import java.util.LinkedList;


/**
 * Kelas SearchQuery, berisi data mengenai pencarian yang dilakukan
 *
 * @author Vincent Hendryanto Halim / 13515089
 */
public class SearchQuery {

  private String keyword;
  private int method;
  private LinkedList<String[]> filter;


  /**
   * Konstruktor kelas search query.
   *
   * @param keyword kata kunci pencarian
   * @param method metode pencarian, 0 = username, 1 = email, 2 = nama lengkap
   */
  public SearchQuery(String keyword, int method) {
    this.keyword = keyword;
    this.method = method;
    filter = new LinkedList<>();
  }

  /**
   * Memasang filter sesuai dengan parameter yang diberikan.
   *
   * @param code kode filter yang digunakan
   * @param sign tanda yang digunakan pada filter (<= atau >=)
   * @param amount nilai jumlah untuk filter
   */
  public void setFilter(String code, char sign, int amount) {
    String[] parameter = new String[3];
    parameter[0] = code;
    parameter[1] = Character.toString(sign);
    parameter[2] = Integer.toString(amount);
    filter.add(parameter);
  }

  /**
   * Mengembalikan URL search query.
   *
   * @return URL yang digunakan untuk melakukan search query
   */
  public String getSearchQuery() {
    String root = "https://api.github.com/search/users?q=";
    String wordQuery = "";
    String locationQuery;
    String filterQuery;
    String searchURL;

    if (keyword != "") {
      if (method == 1) {
        locationQuery = "+in:email";
      } else if (method == 2) {
        locationQuery = "+in:fullname";
      } else {
        locationQuery = "+in:login";
      }
      wordQuery = keyword  + locationQuery;
    }

    String[] tempFilter;
    filterQuery = "";
    while (!filter.isEmpty()) {
      tempFilter = filter.removeFirst();
      filterQuery += "&" + tempFilter[0] + ":" + tempFilter[1] + tempFilter[2];
    }

    searchURL = root + wordQuery + filterQuery;
    return searchURL;
  }
}
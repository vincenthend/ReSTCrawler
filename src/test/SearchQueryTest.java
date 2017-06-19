import static org.junit.Assert.assertTrue;

import model.SearchQuery;
import org.junit.Test;

public class SearchQueryTest {

  @Test
  public void getSearchUrl() {
    System.out.println("Testing URL Generation for login method...");
    SearchQuery searchQuery = new SearchQuery("keyword", 0);
    assertTrue(searchQuery.getSearchUrl()
        .equals("https://api.github.com/search/users?q=keyword+in:login"));
    System.out.println("Testing URL Generation for email method...");
    searchQuery.setMethod(1);
    assertTrue(searchQuery.getSearchUrl()
        .equals("https://api.github.com/search/users?q=keyword+in:email"));
    System.out.println("Testing URL Generation for fullname method");
    searchQuery.setMethod(2);
    assertTrue(searchQuery.getSearchUrl()
        .equals("https://api.github.com/search/users?q=keyword+in:fullname"));
  }


  @Test
  public void addFilter() {
    System.out.println("Testing URL Generation for filter...");
    SearchQuery searchQuery = new SearchQuery("keyword", 0);
    searchQuery.addFilter("repos", ">", 250);
    assertTrue(searchQuery.getSearchUrl()
        .equals("https://api.github.com/search/users?q=keyword+in:login&repos:>250"));
  }

  @Test
  public void getKeyword() {
    System.out.println("Testing keyword getter...");
    SearchQuery searchQuery = new SearchQuery("keyword", 1);
    assertTrue(searchQuery.getKeyword().equals("keyword"));
  }

  @Test
  public void setKeyword() {
    System.out.println("Testing keyword setter...");
    SearchQuery searchQuery = new SearchQuery("keyword", 1);
    searchQuery.setKeyword("abc");
    assertTrue(searchQuery.getKeyword().equals("abc"));
  }

}

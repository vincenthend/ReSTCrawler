import model.Repository;
import org.junit.Assert;
import org.junit.Test;


public class RepositoryTest {


  @Test
  public void test_getName() {
    System.out.println("Testing Name getter and creator...");
    Repository repo = new Repository("name", "http://www.google.com", "abcdefg");
    Assert.assertTrue(repo.getName().equals("name"));
  }

  @Test
  public void test_getUrl() {
    System.out.println("Testing URL getter and creator...");
    Repository repo = new Repository("name", "http://www.google.com", "abcdefg");
    Assert.assertTrue(repo.getUrl().getHost().equals("www.google.com"));
  }

  @Test
  public void test_getDescription() {
    System.out.println("Testing Description getter and creator...");
    Repository repo = new Repository("name", "http://www.google.com", "abcdefg");
    Assert.assertTrue(repo.getDescription().equals("abcdefg"));
  }

}

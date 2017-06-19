import static org.junit.Assert.assertTrue;

import model.Repository;
import model.User;
import org.junit.Test;

public class UserTest {
  @Test
  public void addRepository() {
    User user = new User("user", "name", 1, 2);
    user.addRepository(new Repository("repo", "http://www.google.com", "abc"));

    assertTrue(user.getRepositoryList().size() == 1);
  }

  @Test
  public void getUsername() {
    User user = new User("user", "name", 1, 2);
    assertTrue(user.getUsername().equals("user"));
  }

  @Test
  public void setUsername() {
    User user = new User("user", "name", 1, 2);
    user.setUsername("user2");

    assertTrue(user.getUsername().equals("user2"));
  }

  @Test
  public void getName() {
    User user = new User("user", "name", 1, 2);

    assertTrue(user.getName().equals("name"));
  }

  @Test
  public void setName() {
    User user = new User("user", "name", 1, 2);
    user.setName("name2");

    assertTrue(user.getName().equals("name2"));
  }

  @Test
  public void getFollowersCount() {
    User user = new User("user", "name", 1, 2);

    assertTrue(user.getFollowersCount() == 2);
  }

  @Test
  public void setFollowersCount() {
    User user = new User("user", "name", 1, 2);
    user.setFollowersCount(3);

    assertTrue(user.getFollowersCount() == 3);
  }

  @Test
  public void getRepoCount() {
    User user = new User("user", "name", 1, 2);

    assertTrue(user.getRepoCount() == 1);
  }

  @Test
  public void setRepoCount() {
    User user = new User("user", "name", 1, 2);
    user.setRepoCount(3);

    assertTrue(user.getRepoCount() == 3);
  }

}

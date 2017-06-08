import java.util.LinkedList;

/**
 * Kelas User, berisi data tentang user.
 *
 * @author Vincent Hendryanto Halim / 13515089
 */
public class User {

  private String username;
  private LinkedList<Repository> repositoryList;
  private String name;
  private int repoCount;
  private int followersCount;

  public User(){
    name = "";
    username = "";
    repoCount = 0;
    followersCount = 0;
    repositoryList = new LinkedList<>();
  }

  public User(String username, String name, int repoCount, int followersCount){
    this.username = username;
    this.name = name;
    this.repoCount = repoCount;
    this.followersCount = followersCount;
    repositoryList = new LinkedList<>();
  }

  public void setRepoCount(int repoCount) {
    this.repoCount = repoCount;
  }

  public void setFollowersCount(int followersCount) {
    this.followersCount = followersCount;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void addRepository(Repository repo){
    repositoryList.addLast(repo);
  }

  /**
   * Getter username dari user.
   * @return username dari user
   */
  public String getUsername() {
    return username;
  }

  /**
   * Getter daftar repository yang dimiliki user.t[poikqww
   * @return Linked list berisi daftar repository yang dimiliki user
   */
  public LinkedList<Repository> getRepositoryList() {
    return repositoryList;
  }

  public String getName() {
    return name;
  }

  public int getFollowersCount() {
    return followersCount;
  }

  public int getRepoCount() {
    return repoCount;
  }
}

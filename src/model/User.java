package model;

import java.util.LinkedList;

/**
 * Kelas model.User, berisi data tentang user.
 *
 * @author Vincent Hendryanto Halim / 13515089
 */
public class User {

  private String username;
  private LinkedList<Repository> repositoryList;
  private String name;
  private int repoCount;
  private int followersCount;

  /**
   * Konstruktor default user.
   */
  public User() {
    name = "";
    username = "";
    repoCount = 0;
    followersCount = 0;
    repositoryList = new LinkedList<>();
  }

  /**
   * Konstruktor user dengan parameter.
   *
   * @param username username user
   * @param name nama lengkap dari user
   * @param repoCount jumlah repository dari user
   * @param followersCount jumlah follower dari user
   */
  public User(String username, String name, int repoCount, int followersCount) {
    this.username = username;
    this.name = name;
    this.repoCount = repoCount;
    this.followersCount = followersCount;
    repositoryList = new LinkedList<>();
  }

  /**
   * Menambahkan repository yang dimiliki user.
   *
   * @param repo repository yang dimiliki
   */
  public void addRepository(Repository repo) {
    repositoryList.addLast(repo);
  }

  /**
   * Getter username dari user.
   *
   * @return username dari user
   */
  public String getUsername() {
    return username;
  }

  /**
   * Setter username dari user.
   *
   * @param username username dari user
   */
  public void setUsername(String username) {
    this.username = username;
  }

  /**
   * Getter daftar repository yang dimiliki user.t[poikqww
   *
   * @return Linked list berisi daftar repository yang dimiliki user
   */
  public LinkedList<Repository> getRepositoryList() {
    return repositoryList;
  }

  /**
   * Getter nama dari user.
   *
   * @return nama user
   */
  public String getName() {
    return name;
  }

  /**
   * Setter nama dari user.
   *
   * @param name nama user
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Getter jumlah follower.
   *
   * @return jumlah follower user
   */
  public int getFollowersCount() {
    return followersCount;
  }

  /**
   * Setter jumlah follower user.
   *
   * @param followersCount jumlah follower user
   */
  public void setFollowersCount(int followersCount) {
    this.followersCount = followersCount;
  }

  /**
   * Getter jumlah repository.
   *
   * @return jumlah repository user
   */
  public int getRepoCount() {
    return repoCount;
  }

  /**
   * Setter jumlah repository.
   *
   * @param repoCount jumlah repository user
   */
  public void setRepoCount(int repoCount) {
    this.repoCount = repoCount;
  }
}

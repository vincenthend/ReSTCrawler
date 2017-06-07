import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.JFrame;

/**
 * Kelas UserInterface, menampilkan frame yang memuat hasil search dan user yang sedang dilihat.
 *
 * @author Vincent Hendryanto H / 13515089
 */
public class UserInterface extends JFrame {
  private SearchView searchView;
  private UserView userView;

  /**
   * Konstruktor UserInterface.
   */
  public UserInterface() {
    searchView = new SearchView();
    userView = new UserView();
    setLayout(new GridBagLayout());

    GridBagConstraints constraints = new GridBagConstraints();
    constraints.fill = GridBagConstraints.BOTH;

    //add searchView
    constraints.gridx = 0;
    constraints.gridy = 0;
    constraints.weightx = 1.5;
    constraints.weighty = 1;
    constraints.insets = new Insets(0,10,0,0);
    add(searchView, constraints);

    //add userView
    constraints.gridx = 1;
    constraints.weightx = 3;
    add(userView, constraints);

    setDefaultCloseOperation(EXIT_ON_CLOSE);

    setTitle("Github Search");
    setSize(1000, 500);
    setVisible(true);
  }

  public void setSearchListener(ActionListener actionListener){
    searchView.setSearchListener(actionListener);
  }


  /**
   * Menampilkan daftar user hasil pencarian.
   *
   * @param userList daftar user hasil pencarian
   */
  public void showSearchResult(LinkedList<String> userList) {
    searchView.setResult(userList);
    repaint();
  }

  /**
   * Menampilkan user yang dipilih.
   *
   * @param user user yang dipilih
   */
  public void showUser(User user) {
    userView.setUser(user);
    repaint();
  }
}

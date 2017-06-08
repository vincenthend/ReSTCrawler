import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Kelas UserView, menampilkan user yang dipilih.
 *
 * @author Vincent Hendryanto H / 13515089
 */
public class UserView extends JPanel {

  public JLabel username;
  public JLabel fullName;
  public JLabel repoCount;
  public JLabel followCount;
  public RepoDataView repoDataView;

  /**
   * Konstruktor kelas userView
   */
  public UserView() {
    setLayout(new GridBagLayout());
    GridBagConstraints constraints = new GridBagConstraints();
    username = new JLabel();
    fullName = new JLabel();
    repoCount = new JLabel();
    followCount = new JLabel();
    repoDataView = new RepoDataView();

    //Username
    constraints.gridx = 0;
    constraints.gridy = 0;
    constraints.weighty = 1;
    username.setText(" ");
    username.setHorizontalAlignment(JLabel.LEFT);
    add(username, constraints);

    //Full Name
    constraints.gridx = 0;
    constraints.gridy = 1;
    constraints.gridwidth = 4;
    constraints.weighty = 2;
    fullName.setFont(new Font("serif", Font.PLAIN, 24));
    fullName.setText(" ");
    fullName.setHorizontalAlignment(JLabel.LEFT);
    add(fullName, constraints);

    //Repo Count & Foll Count
    constraints.gridx = 0;
    constraints.gridy = 2;
    constraints.weighty = 0.5;
    repoCount.setText(" ");
    repoCount.setHorizontalAlignment(JLabel.LEFT);
    add(repoCount, constraints);

    constraints.gridy = 3;
    followCount.setText(" ");
    followCount.setHorizontalAlignment(JLabel.LEFT);
    add(followCount, constraints);

    constraints.fill = GridBagConstraints.BOTH;
    constraints.weighty = 20;
    constraints.weightx = 4;
    constraints.gridwidth = 8;
    constraints.gridy = 4;
    add(repoDataView, constraints);
  }

  /**
   * Menampilkan info user yang dipilih.
   *
   * @param user user yang dipilih
   */
  public void setUser(User user) {
    username.setText(user.getUsername());
    fullName.setText(user.getName());
    repoCount.setText("Repos :" + Integer.toString(user.getRepoCount()));
    followCount.setText("Followers :" + Integer.toString(user.getFollowersCount()));

    repoDataView.setData(user.getRepositoryList());
  }
}

package view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.User;

/**
 * Kelas view.UserView, menampilkan user yang dipilih.
 *
 * @author Vincent Hendryanto H / 13515089
 */
public class UserView extends JPanel {

  private JLabel username;
  private JLabel fullName;
  private JLabel repoCount;
  private JLabel followCount;
  private RepoDataView repoDataView;

  /**
   * Konstruktor kelas userView.
   */
  public UserView() {
    setLayout(new GridBagLayout());
    username = new JLabel(" ");
    fullName = new JLabel(" ");
    repoCount = new JLabel(" ");
    followCount = new JLabel(" ");
    repoDataView = new RepoDataView();
    GridBagConstraints constraints = new GridBagConstraints();
    constraints.fill = GridBagConstraints.BOTH;

    //Username
    constraints.gridx = 0;
    constraints.gridy = 0;
    constraints.weighty = 1;
    constraints.weightx = 8;
    add(username, constraints);

    //Full Name
    constraints.gridx = 0;
    constraints.gridy = 1;
    constraints.gridwidth = 4;
    constraints.weighty = 1;
    fullName.setFont(new Font("sans-serif", Font.PLAIN, 24));
    add(fullName, constraints);

    //Repo Count & Foll Count
    constraints.gridx = 0;
    constraints.gridy = 2;
    constraints.weighty = 0.5;
    add(repoCount, constraints);

    constraints.gridy = 3;
    followCount.setText(" ");
    add(followCount, constraints);

    constraints.fill = GridBagConstraints.BOTH;
    constraints.weighty = 20;
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

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Kelas SearchView, menampilkan hasil pencarian.
 *
 * @author Vincent Hendryanto H / 13515089
 */
public class SearchView extends JPanel {
  private final int searchLength = 200;
  private JTextField searchBox;
  private JButton searchButton;
  private SearchResult searchResult;

  /**
   * Konstruktor kelas SearchView.
   */
  public SearchView(){
    setLayout(new GridBagLayout());
    GridBagConstraints constraints = new GridBagConstraints();

    //Text Search Box
    searchBox = new JTextField();
    searchBox.setColumns(searchLength);
    constraints.gridx = 0;
    constraints.gridy = 0;
    constraints.fill = GridBagConstraints.HORIZONTAL;
    constraints.weighty = 0.5;
    constraints.weightx = 0.85;
    add(searchBox,constraints);

    //Search Button
    searchButton = new JButton();
    searchButton.setText("Search");
    constraints.gridx = 1;
    constraints.weightx = 0.15;
    add(searchButton,constraints);

    //Search Result
    searchResult = new SearchResult();
    constraints.gridx = 0;
    constraints.gridy = 1;
    constraints.gridwidth = 2;
    constraints.weighty = 10;
    constraints.weightx = 1;
    constraints.fill = GridBagConstraints.BOTH;
    add(searchResult,constraints);
  }

  /**
   * Menampilkan hasil pencarian.
   * @param result list user hasil pencarian
   */
  public void setResult(LinkedList<User> result) {
    //this.result = result;
  }
}

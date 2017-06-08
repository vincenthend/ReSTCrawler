import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Kelas SearchView, menampilkan hasil pencarian.
 *
 * @author Vincent Hendryanto H / 13515089
 */
public class SearchView extends JPanel {

  private JTextField searchBox;
  private JButton searchButton;
  private JComboBox searchOption;
  private SearchResultView searchResultViewView;

  /**
   * Konstruktor kelas SearchView.
   */
  public SearchView() {
    setLayout(new GridBagLayout());
    GridBagConstraints constraints = new GridBagConstraints();

    //Text Search Box
    searchBox = new JTextField();
    int searchLength = 200;
    searchBox.setColumns(searchLength);
    constraints.gridx = 0;
    constraints.gridy = 0;
    constraints.fill = GridBagConstraints.HORIZONTAL;
    constraints.weightx = 0.85;
    constraints.insets = new Insets(5, 0, 0, 0);
    add(searchBox, constraints);

    //Text Combo Box
    String[] searchMethod = {"Username", "Email", "Full Name"};
    searchOption = new JComboBox(searchMethod);
    constraints.gridx = 1;
    constraints.weightx = 0.15;
    add(searchOption, constraints);

    //Search Button
    searchButton = new JButton();
    searchButton.setText("Search");
    constraints.gridx = 0;
    constraints.gridy = 1;
    constraints.fill = GridBagConstraints.HORIZONTAL;
    constraints.gridwidth = 2;
    add(searchButton, constraints);

    //Search Result
    searchResultViewView = new SearchResultView();
    constraints.gridx = 0;
    constraints.gridy = 2;
    constraints.gridwidth = 2;
    constraints.weighty = 10;
    constraints.weightx = 1;
    constraints.insets = new Insets(5, 0, 5, 0);
    constraints.fill = GridBagConstraints.BOTH;
    add(searchResultViewView, constraints);
  }

  public void setSearchListener(ActionListener actionListener) {
    searchButton.addActionListener(actionListener);
  }

  public SearchQuery getSearchQuery() {
    SearchQuery query = new SearchQuery(searchBox.getText(), searchOption.getSelectedIndex());

    //add filter

    return query;
  }

  public SearchResultView getSearchResultViewView() {
    return searchResultViewView;
  }
}

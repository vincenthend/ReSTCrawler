package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JPanel;

/**
 * Kelas view.SearchView, menampilkan hasil pencarian.
 *
 * @author Vincent Hendryanto H / 13515089
 */
public class SearchView extends JPanel {
  private SearchField searchField;
  private SearchResultView searchResultView;

  /**
   * Konstruktor kelas view.SearchView.
   */
  public SearchView() {
    setLayout(new GridBagLayout());
    GridBagConstraints constraints = new GridBagConstraints();

    //Search Field
    searchField = new SearchField();
    constraints.gridx = 0;
    constraints.gridy = 0;
    constraints.weighty = 1.5;
    constraints.weightx = 1;
    constraints.fill = GridBagConstraints.BOTH;
    add(searchField, constraints);


    //Search Result
    searchResultView = new SearchResultView();
    constraints.gridx = 0;
    constraints.gridy = 1;
    constraints.gridwidth = 2;
    constraints.weighty = 10;
    constraints.weightx = 1;
    constraints.insets = new Insets(5, 0, 5, 0);
    constraints.fill = GridBagConstraints.BOTH;
    add(searchResultView, constraints);
  }

  public SearchField getSearchField() {
    return searchField;
  }

  public SearchResultView getSearchResultView() {
    return searchResultView;
  }
}

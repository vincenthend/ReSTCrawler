package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.SearchQuery;
import view.component.FilterSlider;

public class SearchField extends JPanel {
  private JTextField searchBox;
  private JButton searchButton;
  private JComboBox searchOption;
  private FilterSlider followersValue;
  private FilterSlider repoValue;
  private JComboBox repoSign;

  public SearchField(){
    setLayout(new GridBagLayout());
    GridBagConstraints constraints = new GridBagConstraints();

    searchBox = new JTextField();
    int searchLength = 200;
    searchBox.setColumns(searchLength);
    constraints.gridx = 0;
    constraints.gridy = 0;
    constraints.fill = GridBagConstraints.BOTH;
    constraints.weightx = 0.85;
    constraints.insets = new Insets(5, 0, 0, 0);
    add(searchBox, constraints);

    //Text Combo Box
    String[] searchMethod = {"Username", "Email", "Full Name"};
    searchOption = new JComboBox(searchMethod);
    constraints.gridx = 1;
    constraints.weightx = 0.15;
    add(searchOption, constraints);

    //Repository slider
    repoValue = new FilterSlider("Repository : ");
    constraints.gridx = 0;
    constraints.gridy = 1;
    constraints.gridwidth = 2;
    add(repoValue,constraints);

    //Followers slider
    followersValue = new FilterSlider("Followers : ");
    constraints.gridx = 0;
    constraints.gridy = 2;
    constraints.gridwidth = 2;
    add(followersValue,constraints);


    //Search Button
    searchButton = new JButton();
    searchButton.setText("Search");
    constraints.gridx = 0;
    constraints.gridy = 3;
    constraints.fill = GridBagConstraints.HORIZONTAL;
    constraints.gridwidth = 2;
    add(searchButton, constraints);

  }

  public void setSearchListener(ActionListener actionListener) {
    searchButton.addActionListener(actionListener);
  }

  public SearchQuery getSearchQuery() {
    SearchQuery query = new SearchQuery(searchBox.getText(), searchOption.getSelectedIndex());

    //add filter
    int followersValue = this.followersValue.getFilterSlider().getValue();
    int repoValue = this.repoValue.getFilterSlider().getValue();
    if(followersValue > 0){
      query.addFilter("followers", (String) this.followersValue.getFilterSign().getSelectedItem(),followersValue);
    }

    if(repoValue > 0){
      query.addFilter("repos", (String) this.repoValue.getFilterSign().getSelectedItem(),repoValue);
    }
    return query;
  }

}

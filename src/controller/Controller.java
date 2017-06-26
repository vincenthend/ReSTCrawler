package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import util.GithubFetcher;
import model.SearchQuery;
import model.User;
import org.json.JSONException;
import view.UserInterface;

/**
 * Kelas Controller, mengontrol flow data dan munculnya UI.
 *
 * @author Vincent Hendryanto Halim / 13515089
 */
public class Controller {

  private UserInterface controlledUi;

  /**
   * Konstruktor controller, membuat UI dan memasang action listener.
   */
  public Controller() {
    controlledUi = new UserInterface();

    //Add action listener
    controlledUi.getSearchView().getSearchField().setSearchListener(actionEvent -> {
      SearchQuery query = controlledUi.getSearchView().getSearchField().getSearchQuery();
      if (query.getKeyword().length() <= 3) {
        String message = "Keyword has to be more than 3 characters";
        JOptionPane.showMessageDialog(null, message, null, JOptionPane.INFORMATION_MESSAGE);
      } else {
        controlledUi.getSearchView().getSearchResultView()
            .setResult(GithubFetcher.searchUsername(query));
      }
    });
    controlledUi.getSearchView().getSearchResultView().addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent mouseEvent) {
        //Get selected username
        JTable resultTable = controlledUi.getSearchView().getSearchResultView()
            .getResultTable();
        int row = resultTable.rowAtPoint(mouseEvent.getPoint());
        int col = resultTable.columnAtPoint(mouseEvent.getPoint());
        try {
          if (row >= 0) {
            String username = (String) resultTable.getModel().getValueAt(row, col);
            User selectedUser = GithubFetcher.getUserDetail(username);
            controlledUi.getUserView().setUser(selectedUser);
          }
        } catch (JSONException e) {
          //Failed to get data because of request limit
          JOptionPane.showMessageDialog(null, "Request limit reached, please try again later");
        }
      }
    });
  }


}

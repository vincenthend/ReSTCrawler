package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import jsonutil.JsonFetcher;
import model.SearchQuery;
import model.User;
import view.UserInterface;

/**
 * Kelas controller.Controller, mengontrol flow data.
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
            .setResult(JsonFetcher.searchUsername(query));
      }
    });
    controlledUi.getSearchView().getSearchResultView().setSelectionListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent mouseEvent) {
        //Get selected username
        JTable resultTable = controlledUi.getSearchView().getSearchResultView()
            .getResultTable();
        int row = resultTable.rowAtPoint(mouseEvent.getPoint());
        int col = resultTable.columnAtPoint(mouseEvent.getPoint());
        System.out.println(row + "" + col);
        if (row >= 0) {
          String username = (String) resultTable.getModel().getValueAt(row, col);
          User selectedUser = JsonFetcher.getUserDetail(username);
          controlledUi.getUserView().setUser(selectedUser);
        }
      }
    });
  }


}

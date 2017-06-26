package view;

import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.LinkedList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import model.Repository;
import view.component.UneditableTableModel;

/**
 * Kelas RepoDataView, berisi data dari repository milik user.
 *
 * @author Vincent Hendryanto Halim / 13515089
 */
public class RepoDataView extends JScrollPane {

  private JTable tableData;

  /**
   * Konstruktor kelas RepoDataView.
   */
  public RepoDataView() {
    tableData = new JTable(0, 3);
    tableData.setFillsViewportHeight(true);
    tableData.setTableHeader(null);
    tableData.setColumnSelectionAllowed(false);
    tableData.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent mouseEvent) {
        int row = tableData.rowAtPoint(mouseEvent.getPoint());
        int col = tableData.columnAtPoint(mouseEvent.getPoint());
        if (row >= 0 && col == 1) {
          try {
            URL repoURL = (URL) tableData.getModel().getValueAt(row, col);
            Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
            if (desktop != null && Desktop.isDesktopSupported()) {
              desktop.browse(repoURL.toURI());
            }
          } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
          }
        }
      }
    });

    getViewport().add(tableData);
  }

  /**
   * Memasang data repository pada tabel.
   *
   * @param repoData data repository
   */
  public void setData(LinkedList<Repository> repoData) {
    int i;
    UneditableTableModel tableModel = new UneditableTableModel(repoData.size(), 3);
    for (i = 0; i < repoData.size(); i++) {
      tableModel.setValueAt(repoData.get(i).getName(), i, 0);
      tableModel.setValueAt(repoData.get(i).getUrl(), i, 1);
      tableModel.setValueAt(repoData.get(i).getDescription(), i, 2);
    }

    tableData.setModel(tableModel);
  }

}

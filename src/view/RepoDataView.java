package view;

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

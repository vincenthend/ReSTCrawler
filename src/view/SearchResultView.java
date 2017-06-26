package view;

import java.awt.Dimension;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import view.component.UneditableTableModel;

/**
 * Kelas SearchResultView, berisi daftar nama hasil pencarian.
 *
 * @author Vincent Hendryanto H / 13515089
 */
public class SearchResultView extends JScrollPane {

  private JTable resultTable;

  /**
   * Konstruktor kelas SearchResultView.vi
   */
  public SearchResultView() {
    resultTable = new JTable(0, 1);
    resultTable.setFillsViewportHeight(true);
    resultTable.setTableHeader(null);
    resultTable.setRowSelectionAllowed(false);
    setPreferredSize(new Dimension(100, 100));
    getViewport().add(resultTable);
  }

  /**
   * Setter hasil pada tabel.
   *
   * @param result hasil pencarian
   */
  public void setResult(LinkedList<String> result) {
    int i;
    UneditableTableModel tableModel = new UneditableTableModel(result.size(), 1);
    for (i = 0; i < result.size(); i++) {
      tableModel.setValueAt(result.get(i), i, 0);
    }
    resultTable.setModel(tableModel);
  }

  /**
   * Setter actionListener langsung pada tabel.
   *
   * @param mouseListener mouse listener yang digunakan
   */
  public void addMouseListener(MouseListener mouseListener) {
    resultTable.addMouseListener(mouseListener);
  }

  /**
   * Getter Result Table.
   *
   * @return Objek JTable berisi result
   */
  public JTable getResultTable() {
    return resultTable;
  }
}

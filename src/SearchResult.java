import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * Kelas SearchResult, berisi daftar nama hasil pencarian.
 *
 * @author Vincent Hendryanto H / 13515089
 */
public class SearchResult extends JScrollPane {

  private JTable resultTable;

  public SearchResult() {
    resultTable = new JTable(0, 1);
    resultTable.setFillsViewportHeight(true);
    resultTable.setTableHeader(null);

    setPreferredSize(new Dimension(100,100));

    getViewport().add(resultTable);
  }

}

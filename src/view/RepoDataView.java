package view;

import java.util.LinkedList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import model.Repository;
import view.component.UneditableTableModel;

public class RepoDataView extends JScrollPane {
  JTable tableData;

  public RepoDataView(){
    tableData = new JTable(0,3);
    tableData.setFillsViewportHeight(true);
    tableData.setTableHeader(null);

    getViewport().add(tableData);
  }

  public void setData(LinkedList<Repository> repoData){
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

package view.component;

import javax.swing.table.DefaultTableModel;


public class UneditableTableModel extends DefaultTableModel {

  public UneditableTableModel(int row, int column){
    super(row,column);
  }

  @Override
  public boolean isCellEditable(int i, int j){
    return false;
  }


}

package view.component;

import javax.swing.table.DefaultTableModel;


/**
 * Kelas model tabel yang tidak bisa diedit.
 *
 * @author Vincent Hendryanto Halim / 13515089
 */
public class UneditableTableModel extends DefaultTableModel {

  /**
   * Konstruktor kelas UneditableTableModel.
   * @param row jumlah baris
   * @param column jumlah kolom
   */
  public UneditableTableModel(int row, int column) {
    super(row, column);
  }

  /**
   * Override method untuk mencegah cell diedit.
   * @param i nilai baris
   * @param j nilai kolom
   * @return cell tidak bisa diedit
   */
  @Override
  public boolean isCellEditable(int i, int j) {
    return false;
  }


}

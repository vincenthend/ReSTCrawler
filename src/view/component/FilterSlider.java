package view.component;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class FilterSlider extends JPanel {

  private final int MIN_VALUE = 0;
  private final int MAX_VALUE = 100;
  private final int INIT_VALUE = 0;
  private JSlider filterSlider;
  private JLabel filterLabel;
  private JComboBox filterSign;

  public FilterSlider(String filterLabel) {
    setLayout(new GridBagLayout());

    GridBagConstraints constraints = new GridBagConstraints();

    this.filterLabel = new JLabel(filterLabel);
    constraints.gridy = 0;
    constraints.gridx = 0;
    constraints.weightx = 0.25;
    constraints.fill = GridBagConstraints.BOTH;
    add(this.filterLabel, constraints);

    filterSlider = new JSlider();
    filterSlider.setMinimum(MIN_VALUE);
    filterSlider.setMaximum(MAX_VALUE);
    filterSlider.setValue(INIT_VALUE);
    filterSlider.setPaintLabels(true);
    filterSlider.setPaintTicks(false);
    filterSlider.setMajorTickSpacing(20);
    filterSlider.setMinorTickSpacing(1);
    filterSlider.setFocusable(false);
    constraints.gridx = 1;
    constraints.weightx = 0.8;
    add(filterSlider, constraints);

    String[] sign = {">", "<"};
    filterSign = new JComboBox(sign);
    constraints.gridx = 3;
    constraints.weightx = 0.2;
    constraints.insets = new Insets(0, 10, 0, 0);
    add(filterSign, constraints);
  }

  public JComboBox getFilterSign() {
    return filterSign;
  }

  public JSlider getFilterSlider() {
    return filterSlider;
  }
}

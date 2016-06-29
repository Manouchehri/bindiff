package org.jfree.ui;

import javax.swing.border.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.*;

public class SortButtonRenderer implements TableCellRenderer
{
    public static final int NONE = 0;
    public static final int DOWN = 1;
    public static final int UP = 2;
    private int pressedColumn;
    private JButton normalButton;
    private JButton ascendingButton;
    private JButton descendingButton;
    private boolean useLabels;
    private JLabel normalLabel;
    private JLabel ascendingLabel;
    private JLabel descendingLabel;
    
    public SortButtonRenderer() {
        this.pressedColumn = -1;
        this.pressedColumn = -1;
        this.useLabels = UIManager.getLookAndFeel().getID().equals("Aqua");
        final Border border = UIManager.getBorder("TableHeader.cellBorder");
        if (this.useLabels) {
            (this.normalLabel = new JLabel()).setHorizontalAlignment(10);
            (this.ascendingLabel = new JLabel()).setHorizontalAlignment(10);
            this.ascendingLabel.setHorizontalTextPosition(2);
            this.ascendingLabel.setIcon(new BevelArrowIcon(1, false, false));
            (this.descendingLabel = new JLabel()).setHorizontalAlignment(10);
            this.descendingLabel.setHorizontalTextPosition(2);
            this.descendingLabel.setIcon(new BevelArrowIcon(0, false, false));
            this.normalLabel.setBorder(border);
            this.ascendingLabel.setBorder(border);
            this.descendingLabel.setBorder(border);
        }
        else {
            (this.normalButton = new JButton()).setMargin(new Insets(0, 0, 0, 0));
            this.normalButton.setHorizontalAlignment(10);
            (this.ascendingButton = new JButton()).setMargin(new Insets(0, 0, 0, 0));
            this.ascendingButton.setHorizontalAlignment(10);
            this.ascendingButton.setHorizontalTextPosition(2);
            this.ascendingButton.setIcon(new BevelArrowIcon(1, false, false));
            this.ascendingButton.setPressedIcon(new BevelArrowIcon(1, false, true));
            (this.descendingButton = new JButton()).setMargin(new Insets(0, 0, 0, 0));
            this.descendingButton.setHorizontalAlignment(10);
            this.descendingButton.setHorizontalTextPosition(2);
            this.descendingButton.setIcon(new BevelArrowIcon(0, false, false));
            this.descendingButton.setPressedIcon(new BevelArrowIcon(0, false, true));
            this.normalButton.setBorder(border);
            this.ascendingButton.setBorder(border);
            this.descendingButton.setBorder(border);
        }
    }
    
    public Component getTableCellRendererComponent(final JTable table, final Object o, final boolean b, final boolean b2, final int n, final int n2) {
        if (table == null) {
            throw new NullPointerException("Table must not be null.");
        }
        final SortableTableModel sortableTableModel = (SortableTableModel)table.getModel();
        final int convertColumnIndexToModel = table.convertColumnIndexToModel(n2);
        final boolean b3 = sortableTableModel.getSortingColumn() == convertColumnIndexToModel;
        final boolean ascending = sortableTableModel.isAscending();
        final JTableHeader tableHeader = table.getTableHeader();
        final boolean b4 = convertColumnIndexToModel == this.pressedColumn;
        JLabel label;
        if (this.useLabels) {
            final JLabel rendererLabel = this.getRendererLabel(b3, ascending);
            rendererLabel.setText((o == null) ? "" : o.toString());
            label = rendererLabel;
        }
        else {
            final JButton rendererButton = this.getRendererButton(b3, ascending);
            rendererButton.setText((o == null) ? "" : o.toString());
            rendererButton.getModel().setPressed(b4);
            rendererButton.getModel().setArmed(b4);
            label = (JLabel)rendererButton;
        }
        if (tableHeader != null) {
            label.setForeground(tableHeader.getForeground());
            label.setBackground(tableHeader.getBackground());
            label.setFont(tableHeader.getFont());
        }
        return label;
    }
    
    private JButton getRendererButton(final boolean b, final boolean b2) {
        if (!b) {
            return this.normalButton;
        }
        if (b2) {
            return this.ascendingButton;
        }
        return this.descendingButton;
    }
    
    private JLabel getRendererLabel(final boolean b, final boolean b2) {
        if (!b) {
            return this.normalLabel;
        }
        if (b2) {
            return this.ascendingLabel;
        }
        return this.descendingLabel;
    }
    
    public void setPressedColumn(final int pressedColumn) {
        this.pressedColumn = pressedColumn;
    }
}

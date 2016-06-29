/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.ButtonModel;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import org.jfree.ui.BevelArrowIcon;
import org.jfree.ui.SortableTableModel;

public class SortButtonRenderer
implements TableCellRenderer {
    public static final int NONE = 0;
    public static final int DOWN = 1;
    public static final int UP = 2;
    private int pressedColumn = -1;
    private JButton normalButton;
    private JButton ascendingButton;
    private JButton descendingButton;
    private boolean useLabels = UIManager.getLookAndFeel().getID().equals("Aqua");
    private JLabel normalLabel;
    private JLabel ascendingLabel;
    private JLabel descendingLabel;

    public SortButtonRenderer() {
        Border border = UIManager.getBorder("TableHeader.cellBorder");
        if (this.useLabels) {
            this.normalLabel = new JLabel();
            this.normalLabel.setHorizontalAlignment(10);
            this.ascendingLabel = new JLabel();
            this.ascendingLabel.setHorizontalAlignment(10);
            this.ascendingLabel.setHorizontalTextPosition(2);
            this.ascendingLabel.setIcon(new BevelArrowIcon(1, false, false));
            this.descendingLabel = new JLabel();
            this.descendingLabel.setHorizontalAlignment(10);
            this.descendingLabel.setHorizontalTextPosition(2);
            this.descendingLabel.setIcon(new BevelArrowIcon(0, false, false));
            this.normalLabel.setBorder(border);
            this.ascendingLabel.setBorder(border);
            this.descendingLabel.setBorder(border);
            return;
        }
        this.normalButton = new JButton();
        this.normalButton.setMargin(new Insets(0, 0, 0, 0));
        this.normalButton.setHorizontalAlignment(10);
        this.ascendingButton = new JButton();
        this.ascendingButton.setMargin(new Insets(0, 0, 0, 0));
        this.ascendingButton.setHorizontalAlignment(10);
        this.ascendingButton.setHorizontalTextPosition(2);
        this.ascendingButton.setIcon(new BevelArrowIcon(1, false, false));
        this.ascendingButton.setPressedIcon(new BevelArrowIcon(1, false, true));
        this.descendingButton = new JButton();
        this.descendingButton.setMargin(new Insets(0, 0, 0, 0));
        this.descendingButton.setHorizontalAlignment(10);
        this.descendingButton.setHorizontalTextPosition(2);
        this.descendingButton.setIcon(new BevelArrowIcon(0, false, false));
        this.descendingButton.setPressedIcon(new BevelArrowIcon(0, false, true));
        this.normalButton.setBorder(border);
        this.ascendingButton.setBorder(border);
        this.descendingButton.setBorder(border);
    }

    @Override
    public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl2, boolean bl3, int n2, int n3) {
        boolean bl4;
        JComponent jComponent;
        if (jTable == null) {
            throw new NullPointerException("Table must not be null.");
        }
        SortableTableModel sortableTableModel = (SortableTableModel)jTable.getModel();
        int n4 = jTable.convertColumnIndexToModel(n3);
        boolean bl5 = sortableTableModel.getSortingColumn() == n4;
        boolean bl6 = sortableTableModel.isAscending();
        JTableHeader jTableHeader = jTable.getTableHeader();
        boolean bl7 = bl4 = n4 == this.pressedColumn;
        if (this.useLabels) {
            JLabel jLabel = this.getRendererLabel(bl5, bl6);
            jLabel.setText(object == null ? "" : object.toString());
            jComponent = jLabel;
        } else {
            JButton jButton = this.getRendererButton(bl5, bl6);
            jButton.setText(object == null ? "" : object.toString());
            jButton.getModel().setPressed(bl4);
            jButton.getModel().setArmed(bl4);
            jComponent = jButton;
        }
        if (jTableHeader == null) return jComponent;
        jComponent.setForeground(jTableHeader.getForeground());
        jComponent.setBackground(jTableHeader.getBackground());
        jComponent.setFont(jTableHeader.getFont());
        return jComponent;
    }

    private JButton getRendererButton(boolean bl2, boolean bl3) {
        if (!bl2) return this.normalButton;
        if (!bl3) return this.descendingButton;
        return this.ascendingButton;
    }

    private JLabel getRendererLabel(boolean bl2, boolean bl3) {
        if (!bl2) return this.normalLabel;
        if (!bl3) return this.descendingLabel;
        return this.ascendingLabel;
    }

    public void setPressedColumn(int n2) {
        this.pressedColumn = n2;
    }
}

